package com.tony.java8.lamda.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Supplier;

/**
 * BufferedReaderProcessorTest
 *
 * @author tony
 * @description BufferedReaderProcessorTest
 * @copyright rainbow
 * @date 2020/03/21
 */
public class BufferedReaderProcessorTest {
    /**
     * Deal File
     *
     * @return File text
     * @throws IOException Exception
     */
    public static String processFile() throws IOException {
        //Auto close the resource
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }

    /**
     * Deal with process
     *
     * @param p BufferedReaderProcessor
     * @return String
     * @throws IOException Exception
     */
    public static String processFile(BufferedReaderProcessor p) throws IOException {
        // release the idle stream resource Automatically
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        processFile();

        String line1 = processFile(BufferedReader::readLine);
        //Return with to define the action in runtime
        String line2 = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        //Create the supplier of BufferedReaderProcessorTest
        Supplier<BufferedReaderProcessorTest> supplier = BufferedReaderProcessorTest::new;
    }

}
