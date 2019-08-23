package com.hsl.cn.pojo.dataobject;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class TaskHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date workTime;
    private Float hour;
    @CreatedDate
    private Date createTime;
    @LastModifiedBy
    private  Date updateTime;
    @ManyToOne
    @JoinColumn(name ="task_id")
    private  Task task;

}
