package com.hsl.cn.pojo.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class TaskHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date workTime;
    private Float hour=0F;
    private  Integer status = 0;
    @CreatedDate
    private Date createTime;
    @LastModifiedDate
    private  Date updateTime;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="task_id")
    private  Task task;

}
