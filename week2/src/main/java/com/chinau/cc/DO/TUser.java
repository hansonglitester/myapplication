package com.chinau.cc.DO;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TUser extends BaseDO{
    @Id
    @GeneratedValue
    Integer id;
    private String name;
}
