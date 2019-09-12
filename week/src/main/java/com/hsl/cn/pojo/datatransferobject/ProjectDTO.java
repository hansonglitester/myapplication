package com.hsl.cn.pojo.datatransferobject;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Service
public class ProjectDTO {
    private Integer id;
    private  String  name;
    private  String  remark;


}
