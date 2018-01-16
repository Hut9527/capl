package com.sunjays.capl.annotation;

import java.lang.reflect.Method;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sunjays.capl.entity.SystemLog;
import com.sunjays.capl.entity.UserInfo;
import com.sunjays.capl.service.SystemLogService;
import com.sunjays.capl.utils.HostIpUtils;
import com.sunjays.capl.utils.JsonUtils;

@Aspect
@Component
public class SystemLogAspect {
	//注入Service用于把日志保存数据库  
    @Resource
    private SystemLogService systemLogService;  
    
    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class); 
    
    @Pointcut("execution (* com.sunjays.capl.web.controller.UserController.toZuGuanli(..))")
    public  void controllerAspect() {  
    }  
    
    /** 
     * 后置通知 用于拦截Controller层记录用户的操作 
     * 
     * @param joinPoint 切点 
     */  
    @After("controllerAspect()")  
    public void after(JoinPoint joinPoint) {  
  
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
       // HttpSession session = request.getSession();
        //读取session中的用户  
        //UserInfo user = (UserInfo) session.getAttribute("user"); 
        
        UserInfo user = (UserInfo)SecurityUtils.getSubject().getPrincipal();
        String realHostIp;
		try {
			realHostIp = HostIpUtils.getIpAddr(request);
		} catch (Exception e1) {
			e1.printStackTrace();
			realHostIp="0.0.0.0";
		}
         try {  
            String targetName = joinPoint.getTarget().getClass().getName();  
            String methodName = joinPoint.getSignature().getName();  
            Object[] arguments = joinPoint.getArgs();  
            Class targetClass = Class.forName(targetName);  
            Method[] methods = targetClass.getMethods();
            String operationName = "";
             for (Method method : methods) {  
                 if (method.getName().equals(methodName)) {  
                    Class[] clazzs = method.getParameterTypes();  
                     if (clazzs.length == arguments.length) {
                    	 Log log = method.getAnnotation(Log.class);
                         operationName = method.getAnnotation(Log.class).operationName();
                         break;  
                    }  
                }  
            }
            //*========控制台输出=========*//  
            System.out.println("=====controller后置通知开始=====");  
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+".");  
            System.out.println("方法描述:" + operationName);  
            System.out.println("请求人:" + user.getUsername());  
            System.out.println("请求IP:" + realHostIp);  
            //*========数据库日志=========*//  
            SystemLog log = new SystemLog();  
            log.setDescription(operationName);  
            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+".");  
            log.setLogType((long)0);  
            log.setRequestIp(realHostIp);  
            log.setExceptioncode( null);  
            log.setExceptionDetail( null);  
            log.setCreateBy(user.getUsername());  
            log.setCreateDate(new Date());  
            //保存数据库  
            systemLogService.insert(log);  
            System.out.println("=====controller后置通知结束=====");  
        }  catch (Exception e) {  
            //记录本地异常日志  
        	e.printStackTrace();
            logger.error("==后置通知异常==");  
            logger.error("异常信息:{}", e.getMessage());  
        }  
    } 
    
    
    /** 
     * 异常通知 用于拦截记录异常日志 
     * 
     * @param joinPoint 
     * @param e 
     */  
     @AfterThrowing(pointcut = "controllerAspect()", throwing="e")  
     public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {  
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
        HttpSession session = request.getSession();  
        //读取session中的用户  
        UserInfo user = (UserInfo) session.getAttribute("user");  
        String realHostIp;
		try {
			realHostIp = HostIpUtils.getIpAddr(request);
		} catch (Exception e1) {
			e1.printStackTrace();
			realHostIp="0.0.0.0";
		}
         try {  
             
             String targetName = joinPoint.getTarget().getClass().getName();  
             String methodName = joinPoint.getSignature().getName();  
             Object[] arguments = joinPoint.getArgs();  
             Class targetClass = Class.forName(targetName);  
             Method[] methods = targetClass.getMethods();
             String operationName = "";
              for (Method method : methods) {  
                  if (method.getName().equals(methodName)) {  
                     Class[] clazzs = method.getParameterTypes();  
                      if (clazzs.length == arguments.length) {  
                          operationName = method.getAnnotation(Log.class).operationName();
                          break;  
                     }  
                 }  
             }
             /*========控制台输出=========*/  
            System.out.println("=====异常通知开始=====");  
            System.out.println("异常代码:" + e.getClass().getName());  
            System.out.println("异常信息:" + e.getMessage());  
            System.out.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+".");  
            System.out.println("方法描述:" + operationName);  
            System.out.println("请求人:" + user.getUsername());  
            System.out.println("请求IP:" + realHostIp);  
               /*==========数据库日志=========*/  
            SystemLog log = new SystemLog();
            log.setDescription(operationName);  
            log.setExceptioncode(e.getClass().getName());  
            log.setLogType((long)1);  
            log.setExceptionDetail(e.getMessage());  
            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));  
            log.setCreateBy(user.getUsername());  
            log.setCreateDate(new Date());  
            log.setRequestIp(realHostIp);  
            //保存数据库  
            systemLogService.insert(log);  
            System.out.println("=====异常通知结束=====");  
        }  catch (Exception ex) {  
            //记录本地异常日志  
            logger.error("==异常通知异常==");  
            logger.error("异常信息:{}", ex.getMessage());  
        }  
         /*==========记录本地异常日志==========*/  
         Object[] objects = (Object[]) new Object();
         objects[0]= joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName();
         objects[1]=e.getClass().getName();
         objects[2]=e.getMessage();
        logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}",objects.toString()); 
  
    }  
}
