/**
 * Author: 老洋
 * Date:  2021/6/1 15:34
 */
package com.yyy;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 自定义：异常类
 */
@ResponseStatus(HttpStatus.NOT_FOUND)  //设置状态码：NOT_FOUND底层value 为404
public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}