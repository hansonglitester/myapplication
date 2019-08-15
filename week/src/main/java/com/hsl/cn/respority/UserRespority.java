package com.hsl.cn.respority;

import com.hsl.cn.pojo.dataobject.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespority extends JpaRepository<Integer, UserDO> {
}
