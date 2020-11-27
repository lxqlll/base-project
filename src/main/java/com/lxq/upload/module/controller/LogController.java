package com.lxq.upload.module.controller;


import com.lxq.upload.module.entity.Log;
import com.lxq.upload.module.service.LogService;
import com.lxq.upload.result.Response;
import com.lxq.upload.result.Result;

import com.lxq.upload.utils.Page;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 接口访问日志表(UploadLog)表控制层
 *
 * @author makejava
 * @since 2020-11-23 16:25:51
 */
@RestController
@RequestMapping("uploadLog")
public class LogController {
    /**
     * 服务对象
     */
    @Resource
    @Qualifier(value = "logServiceImpl")
    private LogService logService;

    /**
     * 查询所有
     */
    @PostMapping("findByPage")
    public Result<List<Log>> findByPage(@RequestBody Page page) {
        return Response.ok(logService.findByPage(page));
    }
}