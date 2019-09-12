package com.hsl.cn.pojo.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "project")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private  String  name;
    private  String  remark;
    private  Integer status = 0;
    @CreatedDate
    private Date createTime;
    @LastModifiedDate
    private  Date updateTime;

    @OneToMany(mappedBy = "project")
    List<Task> taskList;

}
