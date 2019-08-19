package com.tony.rocketmq.namesrv.net;

import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author tony
 * @describe NetTest
 * @date 2019-08-17
 */
public class NetTest {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
        ArrayList<String> ipv4Result = new ArrayList<String>();
        ArrayList<String> ipv6Result = new ArrayList<String>();
        while (enumeration.hasMoreElements()) {
            final NetworkInterface networkInterface = enumeration.nextElement();
            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddress = inetAddresses.nextElement();
                if (!inetAddress.isLoopbackAddress()) {//127.0.0.1 0:0:0
                    if (inetAddress instanceof Inet4Address) {
                        ipv4Result.add(inetAddress.getHostAddress());
                        System.out.println(normalizeHostAddress(inetAddress));
                    } else if (inetAddress instanceof Inet6Address) {
                        ipv6Result.add(inetAddress.getHostAddress());
                        System.out.println(normalizeHostAddress(inetAddress));
                    }
                    // fetch host name [user]
                    System.out.println(inetAddress.getHostName());
                    //cpu核数
                    System.out.println(Runtime.getRuntime().availableProcessors());

                }
//                }
            }
        }

    }

    public static String normalizeHostAddress(final InetAddress localHost) {
        if (localHost instanceof Inet6Address) {
            return "[" + localHost.getHostAddress() + "]";
        } else {
            return localHost.getHostAddress();
        }
    }

    public boolean IPV4Validator(List<String> ipAddrs) {
        for (String ip : ipAddrs) {
            String[] ipBit = ip.split(".");
            if (ipBit.length != 4) {
                throw new IPFormatException("ip v4 format is illegal ip:" + ip);
            }
            isScope(ipBit);
        }
        return true;
    }

    private boolean isScope(String[] everypos) {
        boolean flag = true;
        for (int i = 0; i < everypos.length; i++) {
            boolean returnValue = isScope(Integer.parseInt(everypos[i].trim()));
            if (!returnValue) {
                flag = false;
                return flag;
            }
        }
        return true;
    }

    private boolean isScope(int everypo) {
        return everypo > 0 && everypo <= 255;
    }
}
