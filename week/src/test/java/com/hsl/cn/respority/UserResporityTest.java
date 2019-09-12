package com.hsl.cn.respority;

import com.hsl.cn.pojo.dataobject.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityListeners;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaAuditing
@Slf4j
public class UserResporityTest {
    @Autowired
    UserRespority userRespority;

    @Test
    public void testSave(){
        User user=new User() ;
        user.setNickName("hsl");
        user.setMail("2275057986@qq.com");
        user.setPwd("1234567");
        userRespority.save(user);
    }

    @Test
    public void testUpdate(){
        User user=userRespority.getOne(1);
        log.info(user.toString());

        user.setNickName("hsl222");
        user.setMail("2275057986@qq.com");
        user.setPwd("1234567");
        userRespority.save(user);
    }
}
