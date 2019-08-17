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
}
