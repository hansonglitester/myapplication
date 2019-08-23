package com.hsl.cn.pojo.dataobject;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "task")
@EntityListeners(AuditingEntityListener.class)
public class Task  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private  String  name;
    private  String remark;
    @CreatedDate
    private Date createTime;
    @LastModifiedBy
    private  Date updateTime;

    @ManyToOne
    @JoinColumn(name ="project_id")
    private  Project project;

    @OneToMany(mappedBy = "task",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<TaskHours> taskHoursList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}
