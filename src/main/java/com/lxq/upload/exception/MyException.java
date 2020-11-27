package com.lxq.upload.exception;


import com.lxq.upload.enums.ResultEnums;

/**
 * 自定义异常
 */
public class MyException extends RuntimeException {

    private static final long serialVersionUID = 2450214686001409867L;

    private String errorCode = ResultEnums.ERROR.getCode();

    public MyException(ResultEnums resultEnum) {
        super(resultEnum.getMsg());
        this.errorCode = resultEnum.getCode();
    }

   public MyException(ResultEnums resultEnum, Throwable throwable) {
        super(resultEnum.getMsg(), throwable);
        this.errorCode = resultEnum.getCode();
    }

    public MyException(String errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public MyException(String msg) {
        super(msg);
    }

    public MyException(Throwable throwable) {
        super(throwable);
    }

    public MyException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public String getErrorCode() {
        return errorCode;
    }
}
