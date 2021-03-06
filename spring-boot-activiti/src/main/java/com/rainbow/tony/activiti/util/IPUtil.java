package com.rainbow.tony.activiti.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Objects;

/**
 * @author tony
 * @describe IPUtil
 * @date 2019-10-17
 */
public class IPUtil {
    /**
     * 获取请求IP
     *
     * @return String
     */
    public static String getRequestIpAddr() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 获取服务器响应ip
     *
     * @return String
     */
    public static String getLocalHostIpAddr() {
        String localIp = null;
        try {
            if (isWindowsOS()) {
                localIp = InetAddress.getLocalHost().getHostAddress();
            } else {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                InetAddress inetAddress;
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface ni = networkInterfaces.nextElement();
                    System.out.println(ni.getName());
                    inetAddress = ni.getInetAddresses().nextElement();
                    if (!inetAddress.isLoopbackAddress() && !inetAddress.isSiteLocalAddress() && !inetAddress.getHostAddress().contains(":")) {
                        localIp = inetAddress.getHostAddress();
                    }

                }
            }
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        }
        return localIp;
    }

    /**
     * 判断是否是windows操作系统
     *
     * @return isWindowsOS
     */
    private static boolean isWindowsOS() {
        boolean isWindowsOS = false;
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().contains("windows")) {
            isWindowsOS = true;
        }
        return isWindowsOS;

    }
}
