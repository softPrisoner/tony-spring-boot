package com.rainbow.tony.activiti.exception;

/**
 * 系统日志异常
 *
 * @author tony
 * @describe SystemLogException
 * @date 2019-10-17
 */
public class SystemLogException extends RuntimeException {
    private static final long serialVersionUID = 2292991280335121845L;
    // 错误码
    private String code;
    //占位参数
    private Object[] params;

    /**
     * @param code 错误码
     */
    public SystemLogException(String code) {
        this.code = code;
    }

    /**
     * @param code 错误码
     * @param para 参数
     */
    public SystemLogException(String code, Object... para) {
        params = new Object[para.length];
        System.arraycopy(para, 0, this.params, 0, para.length);
        this.code = code;
    }

    /**
     * @param code  错误码
     * @param cause 错误原因
     */
    public SystemLogException(String code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
