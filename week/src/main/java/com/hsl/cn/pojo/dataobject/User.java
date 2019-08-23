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
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nick_name")
    private String nickName;
    private String pwd;
    private String mail;
    @CreatedDate
    private Date createTime;
    @LastModifiedBy
    private  Date updateTime;

    @OneToMany(mappedBy = "user",fetch=FetchType.LAZY)
    private List<Task> taskList;
}
