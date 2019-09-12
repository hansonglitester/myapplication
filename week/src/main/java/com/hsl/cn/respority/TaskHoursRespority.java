package com.hsl.cn.respority;

import com.hsl.cn.pojo.dataobject.Task;
import com.hsl.cn.pojo.dataobject.TaskHours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskHoursRespority extends JpaRepository<TaskHours,Integer> {
}
