package com.hsl.cn.service.impl;

import com.hsl.cn.common.utils.WeekUtils;
import com.hsl.cn.pojo.dataobject.Project;
import com.hsl.cn.pojo.dataobject.Task;
import com.hsl.cn.pojo.dataobject.TaskHours;
import com.hsl.cn.pojo.dataobject.User;
import com.hsl.cn.pojo.datatransferobject.TaskDTO;
import com.hsl.cn.respority.ProjectRespority;
import com.hsl.cn.respority.TaskHoursRespority;
import com.hsl.cn.respority.TaskRespority;
import com.hsl.cn.respority.UserRespority;
import com.hsl.cn.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    @Autowired
    ProjectRespority projectRespority;
    @Autowired
    TaskRespority taskRespority;
    @Autowired
    UserRespority userRespority;
    @Autowired
    TaskHoursRespority taskHoursRespority;


    /**

     * @param taskDTO
     * //创建一个任务  归属于哪个项目 ，哪个人
     * //归属于哪个项目 、哪个人是否需要判断是否存在
     * //创建时间所属周的的任务工作时间
     * @return
     * @throws ParseException
     */
    public Boolean addTask(TaskDTO taskDTO) throws ParseException {

        //创建task
        Task task =new Task();
        task.setName(taskDTO.getName());
        task.setRemark(taskDTO.getRemark());

        //任务属于哪个项目
        Project project =projectRespority.getOne(taskDTO.getProjectId());
        //任务属于哪个人
        User user =userRespority.getOne(taskDTO.getUserId());
        //设置任务和项目、人的关联关系
        task.setProject(project);
        task.setUser(user);

        //保存任务，并保存 当前任务所在周的工作时间
        if(!ObjectUtils.isEmpty(project)&& !ObjectUtils.isEmpty(user)){
            //1、保存任务
            taskRespority.save(task);
            //2、当前任务所在周的工作时间
            List<TaskHours> taskHoursList=new ArrayList<>();

            Date createDate=task.getCreateTime();
            List<Date> weeklist= WeekUtils.getWeekDayList(WeekUtils.getYear(createDate),WeekUtils.getWeekOFYear(createDate));
            for (Date date :weeklist){
                TaskHours taskHours=new TaskHours();
                taskHours.setTask(task);
                taskHours.setWorkTime(date);
                taskHoursList.add(taskHours);
            }

            taskHoursRespority.saveAll(taskHoursList);

        }
        return true;
    }

    @Override
    public Boolean add(Task entity) {
        return null;
    }
}
