package com.hsl.cn.pojo.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Proxy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "user")
@JsonIgnoreProperties(ignoreUnknown=true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nick_name")
    private String nickName;
    private String pwd;
    private String mail;

    private  Integer status=0;
    @CreatedDate
    private Date createTime;
    @LastModifiedDate
    private  Date updateTime;

    @JsonIgnore
    @OneToMany(mappedBy = "user",fetch=FetchType.EAGER)
    private List<Task> taskList;
}
