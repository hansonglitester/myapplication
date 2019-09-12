package com.hsl.cn.respority;

import com.hsl.cn.pojo.dataobject.Project;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface ProjectRespority extends JpaRepository<Project,Integer> {

    @Query(value = "SELECT * FROM project where name=?1 and remark=?2",nativeQuery = true)
    List<Project> findProList2(String name,String remark);

    //多条件分页查询
    @Query(value = "SELECT * FROM project where name like %?1% and remark like %?2%",nativeQuery = true)
    List<Project> findProList3(String name, String remark, PageRequest pageable);
}
