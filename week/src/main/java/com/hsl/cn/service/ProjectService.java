package com.hsl.cn.service;

import com.hsl.cn.pojo.dataobject.Project;
import com.hsl.cn.pojo.dataobject.Task;
import com.hsl.cn.pojo.datatransferobject.ProjectDTO;
import com.hsl.cn.pojo.viewobject.ProjectVO;
import com.hsl.cn.service.IService;

import java.util.List;

/**
 *
 */
public interface ProjectService extends IService<ProjectDTO> {
    public Boolean update(ProjectDTO projectDTO);
    public List <ProjectVO> getAll(Integer offset, Integer size);
    public List <ProjectVO> getpro2(ProjectDTO projectDTO);
}

