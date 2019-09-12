package com.hsl.cn.pojo.datatransferobject;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
public class TaskHoursDTO {
    private Integer id;
    private Date workTime;
    private Float hour=0F;
    private  Integer status = 0;

}
