package com.hsl.cn.respority;

import com.hsl.cn.pojo.dataobject.Project;
import com.hsl.cn.pojo.dataobject.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaAuditing
@Slf4j
public class ProjectResporityTest {
    @Autowired
    ProjectRespority projectRespority;

    @Test
    public void testSave(){
        //创建project
        Project project =new Project();
        project.setName("拼邮项目");
        project.setRemark("拼邮项目:拼购、拼销、一体的项目");

        projectRespority.save(project);

    }
}
