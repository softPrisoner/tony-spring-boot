package com.rainbow.tony.test.design.dproxy;

import java.lang.reflect.Method;

public class TypeGeneratorValue {
    public static String match(Method m) {
        String str = m.getReturnType().getName();
        if ("byte".equals(str)
                || "char".equals(str)
                || "int".equals(str)
                || "double".equals(str)
                || "float".equals(str)
                || "short".equals(str)) {
            return "return 0;";
        } else if ("void".equals(str)) {
            return "";
        }
        return "return null;";
    }
}
