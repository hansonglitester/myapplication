package com.hsl.cn.respority;

import com.hsl.cn.pojo.dataobject.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRespority extends JpaRepository<Task,Integer> {
}
