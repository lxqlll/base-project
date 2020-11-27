package com.lxq.upload.advice;

import com.lxq.upload.exception.MyException;
import com.lxq.upload.result.Response;
import com.lxq.upload.result.Result;
import com.lxq.upload.enums.ResultEnums;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: lxq
 * @createDate: 2020/11/23 0023
 * @version: 1.0
 */
@ControllerAdvice
@Log4j2
public class MyExceptionAdvice {
   /**
     * 统一处理 Exception
     *
     * @param exception
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result<Object> exceptionHandler(MyException exception) {
        log.error("统一异常处理：", exception);
        return Response.error(ResultEnums.APPEAR_EXCEPTION);
    }

}
