package com.hsl.cn.pojo.dataobject;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "user")
public class UserDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 20)
    private String name;
    @Column(length = 20)
    private String mail;
}
