package com.hsl.cn.controller;

import com.hsl.cn.pojo.dataobject.Project;
import com.hsl.cn.pojo.datatransferobject.ProjectDTO;
import com.hsl.cn.pojo.viewobject.ProjectVO;
import com.hsl.cn.pojo.viewobject.ResultEntity;
import com.hsl.cn.respority.ProjectRespority;
import com.hsl.cn.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.geometry.Pos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
@Api(value = "项目管理",description = "项目")
@Slf4j
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    ProjectRespority projectRespority;

    @PostMapping("/addPro")
    @ApiOperation(value = "添加项目",httpMethod = "POST")
    public ResultEntity addPro(@RequestBody ProjectDTO projectDTO){
        projectService.add(projectDTO);
        return ResultEntity.ok();
    }

    @PostMapping("/updatePro")
    @ApiOperation(value = "修改项目",httpMethod = "POST")
    public ResultEntity update(@RequestBody ProjectDTO projectDTO){
        projectService.update(projectDTO);
        return ResultEntity.ok();
    }


    @GetMapping("/getProList")
    @ApiOperation(value = "获取项目项目",httpMethod = "GET")
    public ResultEntity getProjectList(@RequestParam Integer offset,@RequestParam Integer size){

        List<ProjectVO> projectVO= projectService.getAll(offset,size);

        return  new ResultEntity().ok(projectVO) ;
    }

    //这个有bug
    @GetMapping("/getProList1")
    @ApiOperation(value = "获取项目项目",httpMethod = "")//@RequestParam Integer offset,@RequestParam Integer size
    public ResultEntity getProjectList1(){
        //List<ProjectVO> projectVO= projectService.getAll(offset,size);
        List<Project> project= projectRespority.findAll();
        ResultEntity resultEntity=new ResultEntity() ;
        resultEntity.ok(project);
        return resultEntity ;
    }

    /**
     * @return
     */
    @RequestMapping("/getProList2")
    @ApiOperation(value = "获取项目项目",httpMethod = "")//@RequestParam Integer offset,@RequestParam Integer size
    public ResultEntity getProjectList2(@RequestBody ProjectDTO ProjectDTO){
        List <ProjectVO> project= projectService.getpro2(ProjectDTO);
        log.info("project："+project);
        return new ResultEntity().ok(project);
    }
}

