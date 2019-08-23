package com.hsl.cn.pojo.dataobject;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private  String  name;
    private  String  remark;
    @CreatedDate
    private Date createTime;
    @LastModifiedBy
    private  Date updateTime;
    @OneToMany(mappedBy = "project",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    List<Task> taskList;


}
