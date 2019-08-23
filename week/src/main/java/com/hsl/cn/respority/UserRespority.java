package com.hsl.cn.respority;

import com.hsl.cn.pojo.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespority extends JpaRepository<User,Integer> {
}
