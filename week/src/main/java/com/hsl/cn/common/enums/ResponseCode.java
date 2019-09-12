package com.hsl.cn.common.enums;
import lombok.Data;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum  ResponseCode {

    SUCCESS("0000", "success"),
    FAIL("0001", "fail"),
    SYSERROR("500","");

    private String code;
    private String message;
    private static final Map<String, ResponseCode> lookup;

    static {
        lookup = new HashMap<>();
        for (ResponseCode e : EnumSet.allOf(ResponseCode.class)) {
            lookup.put(e.getCode(), e);
        }
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResponseCode get(String code) {
        return lookup.get(code);
    }
}
