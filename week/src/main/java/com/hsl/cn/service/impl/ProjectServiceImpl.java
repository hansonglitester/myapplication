package com.hsl.cn.service.impl;

import com.hsl.cn.pojo.dataobject.Project;
import com.hsl.cn.pojo.datatransferobject.ProjectDTO;
import com.hsl.cn.pojo.viewobject.ProjectVO;
import com.hsl.cn.respority.ProjectRespority;
import com.hsl.cn.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRespority projectRespority;


    /**
     * @param projectDTO
     * @return
     */
    public Boolean add(ProjectDTO projectDTO) {

        Project project=new Project();

        project.setName(projectDTO.getName());

        project.setRemark(projectDTO.getRemark());

        projectRespority.save(project);

        return true;
    }

    @Override
    public Boolean update(ProjectDTO projectDTO) {
        Project project = projectRespority.getOne(projectDTO.getId());

        if (project != null) {
            project.setName(projectDTO.getName());

            project.setRemark(projectDTO.getRemark());
        }

        projectRespority.save(project);
        return true;

    }


    /**
     * @param offset  当前页
     * @param size    每页几条
     */
    public List <ProjectVO> getAll(Integer offset,Integer size) {
        //排序
        Sort.Order order=new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort=new Sort(order);
        //分页
        Pageable pageable=new PageRequest(offset,size,sort);

//        List<Project> list= projectRespority.findAll(pageable);
        Page <Project> page=projectRespority.findAll(pageable);

        //总条数
        System.out.println(page.getTotalElements());
        //总页数
        System.out.println(page.getTotalPages());
        //所有数据内容
        List<Project>  list=page.getContent();

        List<ProjectVO>  list1=new ArrayList <>();
        for (Project project:list){
            ProjectVO projectVO=new ProjectVO();
            projectVO.setId(project.getId());
            projectVO.setName(project.getName());
            projectVO.setRemark(project.getRemark());
            list1.add(projectVO);
        }
        return list1;
    }

    /*** @param offset
     * @param size
     * @return Integer offset, Integer size
     */
    public List <ProjectVO> getpro2(ProjectDTO projectDTO) {

        List<Project> list= (List <Project>) projectRespority.findProList3(projectDTO.getName(),projectDTO.getRemark(),new PageRequest(0,2));
        log.info(list.toString());

        List<ProjectVO>  list1=new ArrayList <>();
        for (Project project:list){
            ProjectVO projectVO=new ProjectVO();
            projectVO.setId(project.getId());
            projectVO.setName(project.getName());
            projectVO.setRemark(project.getRemark());
            list1.add(projectVO);
        }
        return list1;
    }

}
