package com.coder.service.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseUtils<T> {
    private int code;
    private T data;

    public static ResponseUtils success(Object data) {
        return new ResponseUtils(HttpStatus.OK.value(), data);
    }

    public static ResponseUtils error(String msg) {
        return new ResponseUtils(HttpStatus.BAD_REQUEST.value(), msg);
    }

    public static void main(String[] args) {
        ResponseUtils obj = ResponseUtils.success("token啊token");
        System.out.println(obj);
    }
}
