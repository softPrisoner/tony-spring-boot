package com.rainbow.tony.test.design.filter;

public class Main {
    public static void main(String[] args) {
        MsgProcessor processor = new MsgProcessor();
        String msg = "<abc>";
        processor.setMsg(msg);
        String safeMsg = processor.processor();
        System.out.println(safeMsg);
    }
}
