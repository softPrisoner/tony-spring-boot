package com.tony.rocketmq.namesrv.compress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/**
 * @author tony
 * @describe CompressTest
 * @date 2019-09-05
 */
public class CompressTest {
    private static final Logger log = LoggerFactory.getLogger(CompressTest.class);

    //from rocket mq
    public static byte[] uncompress(final byte[] src) throws IOException {
        byte[] result = src;
        byte[] uncompressData = new byte[src.length];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(src);
        InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(src.length);

        try {
            while (true) {
                int len = inflaterInputStream.read(uncompressData, 0, uncompressData.length);
                if (len <= 0) {
                    break;
                }
                byteArrayOutputStream.write(uncompressData, 0, len);
            }
            byteArrayOutputStream.flush();
            result = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw e;
        } finally {
            try {
                byteArrayInputStream.close();
            } catch (IOException e) {
                log.error("Failed to close the stream", e);
            }
            try {
                inflaterInputStream.close();
            } catch (IOException e) {
                log.error("Failed to close the stream", e);
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                log.error("Failed to close the stream", e);
            }
        }

        return result;
    }

    public static byte[] compress(final byte[] src, final int level) throws IOException {
        //返回结果数组
        byte[] result = src;
        //字符数组输出流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(src.length);
        //设置默认等级
        java.util.zip.Deflater defeater = new java.util.zip.Deflater(level);
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, defeater);
        try {
            deflaterOutputStream.write(src);
            deflaterOutputStream.finish();
            deflaterOutputStream.close();
            result = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            defeater.end();
            throw e;
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException ignored) {
            }

            defeater.end();
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        //1字节 每个字节8位
        String str = "123456789";
        System.out.println(str.getBytes().length);
        byte[] compress = compress(str.getBytes(), 1);
        for (byte b : compress) {
            System.out.println((char) b);
        }
        System.out.println(compress.length);
        byte[] uncompress = uncompress(compress);
        System.out.println(uncompress.length);
    }

    public static long getStringLength(String str) {
        if (!StringUtils.isEmpty(str)) {
            return str.getBytes().length * 8;
        } else {
            return -1;
        }
    }
}
