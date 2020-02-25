package com.jcz.aop;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
@Aspect
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(* com.jcz.controller.*.*none(..))")//切入点
        public  void  chectLogin(){

        }
        @Before(value = "chectLogin()")
         public void before(JoinPoint joinPoint){
            logger.info("---前置通知---");

            // 获取目标方法的参数信息
            logger.info("目标对象参数信息: {}", Arrays.toString(joinPoint.getArgs()));

            // AOP代理类的信息
            logger.info("AOP代理类: {}", joinPoint.getThis());

            // 代理的目标对象
            logger.info("代理的目标对象: {}", joinPoint.getTarget());

            // 通知的签名
            Signature signature = joinPoint.getSignature();
            // 代理的是哪一个方法
            logger.info("代理的方法名: {}", signature.getName());

            // AOP代理类的名字
            logger.info("AOP代理类的名字: {}", signature.getDeclaringTypeName());

            // AOP代理类的类信息
            logger.info("AOP代理类的类信息: {}", signature.getDeclaringType());

//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            // 获取 HttpServletRequest
//        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);

            // 获取 Session
//        HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);


         }
    }
