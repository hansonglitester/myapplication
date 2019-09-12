package com.chinau.cc.respority;

import com.chinau.cc.DO.TUser;
import lombok.ToString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserResporityTest {
    @Autowired
    UserRespority userRespority;

    @Test
    public void oo(){
        TUser user=new TUser();
        user.setName("ooo");

        userRespority.save(user);
    }
}
