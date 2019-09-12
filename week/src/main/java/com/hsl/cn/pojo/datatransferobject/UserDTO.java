package com.hsl.cn.pojo.datatransferobject;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
public class UserDTO {

    private Integer id;
    private String nickName;
    private String pwd;
    private String mail;


}
