package com.hsl.cn.common.exception;

import com.hsl.cn.common.enums.ResponseCode;
import com.hsl.cn.pojo.viewobject.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class ExceptionHander {

    @ExceptionHandler(value = Exception.class)
    public ResultEntity defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        log.error(e.getMessage(),e);

        ResultEntity r= new ResultEntity();
        r.setCode(ResponseCode.SYSERROR.getCode());
        r.setMsg(e.getMessage());
        return r;
    }
}

