package com.hsl.cn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hsl.cn.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao extends JpaRepository <User,Integer> {
    //List<User> findById(Integer id);
    List<User> findByName(String name);
    List<User> findByNameAndPwd(String name, String pwd);

}
