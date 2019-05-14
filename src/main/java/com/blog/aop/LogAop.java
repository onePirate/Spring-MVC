package com.blog.aop;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @function:
 * @Author: gaodawei
 * @Date: 2018/1/16 23:22
 */
@Component
@Aspect
public class LogAop {

    private static Logger log = LoggerFactory.getLogger(LogAop.class);

    private int logCost = 500;

    private int lengthLimit = 2000;

    @Pointcut("execution(* *..*Controller.*(..))")
    public void logPoint() {
    }

    /**
     * 对匹配Controller结尾的 类的所有方法做日志打印
     *
     * @param proceeding
     * @return
     */
    @Around("logPoint()")
    public Object aroundLog(ProceedingJoinPoint proceeding) {
        Object obj = null;
        long now = System.currentTimeMillis();
        try {
            obj = proceeding.proceed(proceeding.getArgs());
        } catch (Throwable e) {
            log.error(ExceptionUtils.getFullStackTrace(e));
        }
        if(!log.isInfoEnabled()){
            return obj;
        }
        try {
            long cost = System.currentTimeMillis() - now;
            StringBuilder sb = new StringBuilder();
            sb.append("【dubbo日志】  : dubboCost 【耗时】: ");
            sb.append(cost);
            if (cost > logCost) {
                sb.append("【dubbo耗时太长 】:dubboTooLong ");
            }
            sb.append(" 【方法】:");
            sb.append(proceeding.toShortString());

            Object[] args = proceeding.getArgs();
            if (args != null && args.length > 0) {
                String argStr = JSON.toJSONString(args);
                if (argStr.length() < lengthLimit) {
                    sb.append(" 【参数】:");
                    sb.append(argStr);
                }else{
                    sb.append(" 【参数太长】:");
                    sb.append(argStr.substring(0, lengthLimit /2));
                }
                sb.append(" 【参数长度】:");
                sb.append(argStr.length());

            }
            if (obj != null) {
                String result = JSON.toJSONString(obj);
                if (result.length() < lengthLimit) {
                    sb.append(" 【返回值】:");
                    sb.append(result);
                }else{
                    sb.append(" 【返回值太长】:");
                    sb.append(result.substring(0, lengthLimit /2));
                }
                sb.append(" 【返回值长度】:");
                sb.append(result.length());
            }
            log.info(sb.toString());
        } catch (Throwable e) {
            log.error(ExceptionUtils.getFullStackTrace(e));
        }
        return obj;
    }
}
