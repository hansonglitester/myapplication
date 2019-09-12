package com.chinau.cc.respority;

import com.chinau.cc.DO.TUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespority extends JpaRepository<TUser,Integer> {
}
