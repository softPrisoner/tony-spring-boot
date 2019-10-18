package com.rainbow.tony.activiti.controller;

import com.rainbow.tony.activiti.aop.SystemLogAop;
import com.rainbow.tony.activiti.exception.SystemLogException;
import com.rainbow.tony.activiti.model.SystemLogInfo;
import com.rainbow.tony.activiti.util.IPUtil;
import com.rainbow.tony.activiti.util.MixUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tony
 * @describe BaseController
 * @date 2019-10-17
 */
public class BaseController {
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    //页面根路径
    protected String basePath = "/basePath";

    /**
     * 获取页面变量
     *
     * @param key KEY
     * @return VALUE
     * @throws Exception 异常
     */
    protected String getParameter(String key) throws Exception {
        return getRequest().getParameter(key);
    }

    /**
     * 设置属性
     *
     * @param key   KEY
     * @param value VALUE
     * @throws Exception 异常
     */
    protected void setAttribute(String key, Object value) throws Exception {
        getRequest().setAttribute(key, value);
    }

    /**
     * 获取HTTP请求
     *
     * @return HttpServletRequest
     * @throws Exception 异常
     */
    protected HttpServletRequest getRequest() throws Exception {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取HTTP响应
     *
     * @return HttpServletResponse
     * @throws Exception 异常
     */
    protected HttpServletResponse getResponse() throws Exception {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    /**
     * 获取session
     *
     * @return HttpSession session
     * @throws Exception 异常
     */
    protected HttpSession getSession() throws Exception {
        return getRequest().getSession();
    }

    /**
     * 插入日志
     *
     * @param targetName 对象名称
     * @param methodName 方法名称
     * @param consume    消费者
     * @param result     届法国
     * @throws Exception
     */
    public void insertSystemLog(String targetName, String methodName, String consume, String result) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("invokingMethod", targetName + "." + methodName + "()");
        map.put("arguments", "");

        try {
            Class targetClass = Class.forName(targetName);
            Method[] methods = targetClass.getMethods();
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Map<String, Object> methodArgsMap = SystemLogAop.buildAnnotationMap(map, method);
                    map.putAll(methodArgsMap);
                }
            }
        } catch (ClassNotFoundException e) {
            LOGGER.error("resolve the log annotation error:", e);
            throw new SystemLogException("", e);
        }

        SystemLogInfo systemLogInfo = new SystemLogInfo();
        String ip = IPUtil.getRequestIpAddr();
        if (StringUtils.isBlank(ip)) {
            ip = "not-found-ip";
        }

        systemLogInfo.setThreadCode(Thread.currentThread().getName());
        systemLogInfo.setBusinessId("businessId");
        systemLogInfo.setBusinessDate(MixUtils.getNowDate());
        systemLogInfo.setBusinessTime(MixUtils.getNowTime());

        systemLogInfo.setOperCode("---");
        systemLogInfo.setOperName("---");
        systemLogInfo.setOrganCode("---");
        systemLogInfo.setOrganName("---");
        systemLogInfo.setDeptCode("---");
        systemLogInfo.setDeptName("---");

        systemLogInfo.setFunctionCode(map.get("functionCode") + "");
        systemLogInfo.setFunctionName(map.get("functionName") + "");
        systemLogInfo.setInvokingMethod(map.get("invokingMethod") + "");
        systemLogInfo.setMethodArg(map.get("arguments") + "");
        systemLogInfo.setInvokingResult(result);

        systemLogInfo.setRequestIp(ip);
        systemLogInfo.setServiceCode(IPUtil.getLocalHostIpAddr());
        systemLogInfo.setBusinessConsumingTime(consume + "");

        systemLogInfo.setId(MixUtils.getNowDate() + MixUtils.getNowTime() + MixUtils.getLastSixNum());
        try {
            //todo 插入日志
            LOGGER.info("insert system log success. at:{}", MixUtils.getNowTime());
        } catch (Exception ex) {
            throw new SystemLogException("", ex);
        }
    }

}
