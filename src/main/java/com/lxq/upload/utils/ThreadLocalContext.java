package com.lxq.upload.utils;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxq.upload.module.entity.Log;
import lombok.Data;

/**
 * 本地线程上下文，单例模式
 * 用来存储在同一个线程中可能会用到的全局变量
 *
 */
@Data
public class ThreadLocalContext<T> {

    /**
     * 日志实体
     */
    private Log logger = new Log();

    /**
     * 是否记录日志
     */
    private boolean isLog = false;

    /**
     *
     */
    IPage<T> iPage = new Page();

    /**
     *
     */
    QueryWrapper<T> qw = new QueryWrapper();

    /**
     * 线程本地内存中的变量
     */
    private static ThreadLocal<ThreadLocalContext> threadLocal = new ThreadLocal<>();

    public static ThreadLocalContext get() {
        if (threadLocal.get() == null) {
            ThreadLocalContext threadLocalContext = new ThreadLocalContext();
            threadLocal.set(threadLocalContext);
        }
        ThreadLocalContext threadLocalContext = threadLocal.get();
        return threadLocalContext;
    }

    public void remove() {
        this.logger = null;
        this.isLog = false;
        threadLocal.remove();
    }
}

