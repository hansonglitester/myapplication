package com.hsl.cn.respority;

import com.hsl.cn.common.utils.WeekUtils;
import com.hsl.cn.pojo.dataobject.Project;
import com.hsl.cn.pojo.dataobject.Task;
import com.hsl.cn.pojo.dataobject.TaskHours;
import com.hsl.cn.pojo.dataobject.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaAuditing
@Slf4j
public class TaskAddService {
    @Autowired
    ProjectRespority projectRespority;
    @Autowired
    TaskRespority taskRespority;
    @Autowired
    UserRespority userRespority;
    @Autowired
    TaskHoursRespority taskHoursRespority;


    //创建一个任务  归属于哪个项目 ，哪个人
    //归属于哪个项目 、哪个人是否需要判断是否存在

    //创建时间所属周的的任务工作时间
    @Test
    public void testSave() throws ParseException {
        //创建task
        Task task =new Task();
        task.setName("拼邮项目第一轮测试");
        //创建project
        Project project =projectRespority.getOne(1);
        //创建用户
        User user =userRespority.getOne(1);

        //创建关联关系
        task.setProject(project);
        task.setUser(user);
        taskRespority.save(task);


        //创建工时对象, 存放一周的工时
        List<TaskHours> taskHoursList=new ArrayList<>();

        //任务创建时间 所有周的 工时
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


}
