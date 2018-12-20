package com.lewis.spring1.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:11:06
 * 邮箱：1981462002@qq.com
 * 说明：AOP+log4j 记录访问请求信息
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger sLogger = Logger.getLogger(LogAspect.class);
    private static final String POINT_CUT ="execution(public * com.lewis.spring1.controller.*.*(..))" ;

//    /**
//     * 拦截com.toly1994.toly_mybatis.controller包下所以方法
//     */
//    @Pointcut(POINT_CUT)
//    public void log() {
//    }
//
//    /**
//     * 前置通知
//     *
//     * @param joinPoint
//     */
//    @Before(value = POINT_CUT)//log()方法之前
//    public void doBefore(JoinPoint joinPoint) {
//        //接收请求，记录请求
//        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = sra.getRequest();
//        //记录日志
//        sLogger.info("url" + request.getRequestURI().toString());
//        sLogger.info("method" + request.getMethod());
//        sLogger.info("ip" + request.getRemoteAddr());
//
//        Enumeration<String> names = request.getParameterNames();
//        while (names.hasMoreElements()) {
//            String name = names.nextElement();
//            sLogger.info("name:" + name + ",value:{" + request.getParameter(name) + "}");
//
//        }
//    }
//
//    /**
//     * 后置通知
//     *
//     * @param ret
//     */
//    @AfterReturning(returning = "ret", value = POINT_CUT)
//    public void doAfter(Object ret) {
//        sLogger.info("response" + ret);//处理完成，返回
//    }
//    /**
//     * 后置异常通知
//     *  定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
//     *  throwing:限定了只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行，
//     *            对于throwing对应的通知方法参数为Throwable类型将匹配任何异常。
//     * @param joinPoint
//     * @param exception
//     */
//    @AfterThrowing(value = POINT_CUT,throwing = "exception")
//    public void doAfterThrowingAdvice(JoinPoint joinPoint,Throwable exception){
//        //目标方法名：
//        sLogger.info(joinPoint.getSignature().getName());
//        if(exception instanceof NullPointerException){
//            sLogger.info("发生了空指针异常!!!!!");
//        }
//    }

}

