package com.rainbow.tony.activiti.exception;

/**
 * ϵͳ��־�쳣
 *
 * @author tony
 * @describe SystemLogException
 * @date 2019-10-17
 */
public class SystemLogException extends RuntimeException {
    private static final long serialVersionUID = 2292991280335121845L;
    // ������
    private String code;
    //ռλ����
    private Object[] params;

    /**
     * @param code ������
     */
    public SystemLogException(String code) {
        this.code = code;
    }

    /**
     * @param code ������
     * @param para ����
     */
    public SystemLogException(String code, Object... para) {
        params = new Object[para.length];
        System.arraycopy(para, 0, this.params, 0, para.length);
        this.code = code;
    }

    /**
     * @param code  ������
     * @param cause ����ԭ��
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
