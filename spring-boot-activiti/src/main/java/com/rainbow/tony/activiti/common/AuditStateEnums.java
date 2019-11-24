package com.rainbow.tony.activiti.common;

/**
 * @author tony
 * @describe AuditStateEnums
 * @date 2019-10-05
 */
public enum AuditStateEnums {

    STATE_NEW(0, "新建"),

    STATE_ISSUED(1, "已下发"),

    STATE_FILL(2, "已填写,未提交"),

    STATE_SUBMITTED(4, "已提交"),

    STATE_APPROVING(8, "审批中"),

    STATE_APPROVED(16, "已审批"),

    STATE_DISMISSED(32, "已驳回");

    public int status;
    public String description;

    AuditStateEnums(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
