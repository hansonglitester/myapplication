package com.hsl.cn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hsl.cn.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao extends JpaRepository <User,Integer> {
    //List<User> findById(Integer id);
    List<User> findByMobile(String mobile);
    List<User> findByMobileAndPwd(String mobile, String pwd);
    List<User> findByMobileAndStatus(String mobile,Integer status);

}
