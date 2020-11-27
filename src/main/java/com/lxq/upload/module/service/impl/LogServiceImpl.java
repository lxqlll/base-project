package com.lxq.upload.module.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lxq.upload.utils.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxq.upload.module.entity.Log;
import com.lxq.upload.module.mapper.LogMapper;
import com.lxq.upload.module.service.LogService;

import com.lxq.upload.utils.StringUtils;
import com.lxq.upload.utils.ThreadLocalContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 接口访问日志表(UploadLog)表服务实现类
 *
 * @author makejava
 * @since 2020-11-23 16:25:51
 */
@Service(value = "logServiceImpl")
public class LogServiceImpl extends ServiceImpl<LogMapper,Log> implements LogService  {


    @Override
    public List<Log> findByPage(Page page) {
        //分页
        IPage<Log> iPage = ThreadLocalContext.get().getIPage();
        //current 当前页
        iPage.setCurrent(page.getCurrentPage());
        //size    每页显示条数
        iPage.setSize(page.getPageSize());
        //条件
        QueryWrapper<Log> qw = ThreadLocalContext.get().getQw();
        //状态
        String logStatus = (String)page.getParams().get("logStatus");
        if(StringUtils.isBlank(logStatus)){
            qw.eq(true,"log_status",logStatus);
        }
        //请求方式
        String logMethod = (String)page.getParams().get("logMethod");
        if(StringUtils.isBlank(logMethod)){
            qw.eq(true,"log_method",logMethod);
        }
        //创建时间
        String startTime = (String)page.getParams().get("startTime");
        String endTime = (String)page.getParams().get("endTime");
        if(StringUtils.isBlank(startTime) && StringUtils.isBlank(endTime)){
            //10-25 10-26 time>=lie<=time
            qw.ge(true,"created_time",startTime);
            qw.le(true,"created_time",endTime);
        }
        String column = page.getSortColumn();
        String sortMethod = page.getSortMethod();
        if(StringUtils.isBlank(column) && StringUtils.isBlank(sortMethod)){
           if("asc".equals(sortMethod)){
               qw.orderByAsc(column);
           }else if("desc".equals(sortMethod)){
               qw.orderByDesc(column);
           }
        }
        return this.page(iPage,qw).getRecords();
    }
}