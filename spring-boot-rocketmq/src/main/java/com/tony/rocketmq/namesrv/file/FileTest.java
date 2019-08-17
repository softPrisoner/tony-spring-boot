package com.tony.rocketmq.namesrv.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/**
 * @author tony
 * @describe FileTest
 * @date 2019-08-17
 */
public class FileTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileTest.class.getName());

    public static void main(String[] args) throws IOException {
        File file = new File("/home/tony/store/lock");

        String parentPath = file.getParent();
        System.out.println(parentPath); // /home/tony/store
        File fs = new File(parentPath);
        if (!fs.exists()) {
            boolean result = fs.mkdirs();
            LOGGER.info("Try create directory,[{}],{}", parentPath, result ? "SUCCESS" : "FAILED");
        } else {
            LOGGER.info("Directory [{}] exists", parentPath);
        }
        RandomAccessFile lockFile = new RandomAccessFile(file, "rw");
        FileLock lockTest = lockFile.getChannel().lock(0, 1, false);
        if (lockTest == null || lockTest.isShared() || !lockTest.isValid()) {
            System.out.println("File has been locked by other");
        }else{
            String flag = lockFile.readLine();
            System.out.println(flag);
            System.out.println(flag.length());
        }



    }
}
