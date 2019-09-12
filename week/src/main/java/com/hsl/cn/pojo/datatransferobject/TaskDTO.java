package com.hsl.cn.pojo.datatransferobject;

import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
public class TaskDTO {
    private  Integer id;
    private  String  name;
    private  String remark;
    private  Integer projectId;
    private Integer userId;


}
