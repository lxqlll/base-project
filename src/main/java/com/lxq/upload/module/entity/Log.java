package com.lxq.upload.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 接口访问日志表(UploadLog)实体类
 *
 * @author makejava
 * @since 2020-11-23 16:25:49
 */
@Data
@TableName(value = "upload_log")
public class Log implements Serializable {

    private static final long serialVersionUID = 448970700203107901L;
    /**
    * 日志id
    */
    @TableId(value = "logId",type = IdType.AUTO)
    private Integer logId;
    /**
    * 请求路径
    */
    private String logUrl;
    /**
    * 参数
    */
    private String logParams;
    /**
    * 访问状态，1正常0异常
    */
    private Integer logStatus;
    /**
    * 异常信息
    */
    private String logMessage;
    /**
    * 请求方式，get、post等
    */
    private String logMethod;
    /**
    * 响应时间
    */
    private Long logTime;
    /**
    * 返回值
    */
    private String logResult;
    /**
    * 请求ip
    */
    private String logIp;
    /**
    * 创建时间
    */
    private Date createdTime;
    /**
    * 创建人
    */
    private String createdBy;

}