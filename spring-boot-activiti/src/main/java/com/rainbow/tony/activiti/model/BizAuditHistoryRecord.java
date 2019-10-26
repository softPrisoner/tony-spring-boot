package com.rainbow.tony.activiti.model;

import java.io.Serializable;

/**
 * @author tony
 * @describe BizAuditHistoryRecord
 * @date 2019-10-25
 */
public class BizAuditHistoryRecord implements Serializable {
    private static final long serialVersionUID = -6178901841880358376L;
    private Long id;
    // attach business
    private String businessId;
    //bound taskId in every audit
    private String taskId;
    //process instance id
    private String processInstanceId;
    //assignee with state xx:audit  xx:reject xx:resubmit
    private String assignee;
    //audit start time
    private String startAt;
    // audit end time
    private String endAt;
    //audit name making easy query
    private String assigneeName;
    //audit status around the life circle of process
    private int status;
    //audit type with business enum
    private int auditType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAuditType() {
        return auditType;
    }

    public void setAuditType(int auditType) {
        this.auditType = auditType;
    }

    @Override
    public String toString() {
        return "TbAuditRecordHistDO{" +
                "id=" + id +
                ", businessId='" + businessId + '\'' +
                ", taskId='" + taskId + '\'' +
                ", processInstanceId='" + processInstanceId + '\'' +
                ", assignee='" + assignee + '\'' +
                ", startAt='" + startAt + '\'' +
                ", endAt='" + endAt + '\'' +
                ", assigneeName='" + assigneeName + '\'' +
                ", status=" + status +
                ", auditType=" + auditType +
                '}';
    }
}
