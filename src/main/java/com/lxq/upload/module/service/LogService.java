package com.lxq.upload.module.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lxq.upload.module.entity.Log;
import com.lxq.upload.utils.Page;

import java.util.List;

/**
 * 接口访问日志表(UploadLog)表服务接口
 *
 * @author makejava
 * @since 2020-11-23 16:25:51
 */
public interface LogService extends IService<Log> {
    /**
     *
     * @param page
     * @return
     */
    public List<Log> findByPage(Page page);
}