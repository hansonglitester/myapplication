package com.hsl.cn.pojo.dataobject;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Entity(name = "task")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Task  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private  String  name;
    private  String remark;
    private  Integer status = 0;
    @CreatedDate
    private Date createTime;
    @LastModifiedDate
    private  Date updateTime;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="project_id")
    private  Project project;

    @JsonIgnore
    @OneToMany(mappedBy = "task",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<TaskHours> taskHoursList;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}
