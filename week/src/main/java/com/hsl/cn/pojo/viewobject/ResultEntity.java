package com.hsl.cn.pojo.viewobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hsl.cn.common.enums.ResponseCode;
import lombok.Data;

@Data
public class ResultEntity {
    private String code;
    private String msg;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Object data;

    public static ResultEntity ok() {
        ResultEntity r = new ResultEntity();
        r.setCode(ResponseCode.SUCCESS.getCode());
        r.setMsg(ResponseCode.SUCCESS.getMessage());
        return r;
    }

    public static ResultEntity ok(Object data) {
        ResultEntity r = new ResultEntity();
        r.setCode(ResponseCode.SUCCESS.getCode());
        r.setMsg(ResponseCode.SUCCESS.getMessage());
        r.setData(data);
        return r;
    }

    public static ResultEntity error(Object data) {
        ResultEntity r = new ResultEntity();
        r.setMsg(ResponseCode.FAIL.getCode());
        r.setMsg(ResponseCode.FAIL.getMessage());
        r.setData(data);
        return r;
    }

}
