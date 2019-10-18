package com.rainbow.tony.activiti.common;

import java.io.Serializable;

/**
 * 信贷计划/需求常量类
 *
 * @author tony
 * @describe PlanMix
 * @date 2019-10-16
 */
public final class AuditMixHelper implements Serializable {
    private static final long serialVersionUID = -5888568941980132203L;
    //审批驳回标识
    public static final String AUDIT_FAILED = "0";

    //审批通过标识
    public static final String AUDIT_PASSED = "1";

    //业务流程标识
    public static final String BUSINESS_BASE_PROCESS_KEY = "business_base_process_key";

    //计划审批流程节点标识前缀
    public static final String BUSINESS_AUDITOR_PREFIX = "audit_node_level";

    //业务主键标识
    public static final String BUSINESS_KEY = "businessId";

    //流程进度标识
    public static final String WHERE_KEY = "where";

    //审批人标识
    public static final String ASSIGNEE_KEY = "assignee";

    //任务创建人标识
    public static final String BUSINESS_OPER_KEY = "business_operator_key";

    //流程实例ID
    public static final String PROCESS_INSTANCE_ID = "processInstanceId";

    //审批任务Id
    public static final String TASK_KEY = "taskId";

    //审批评语标识
    public static final String COMMENT_KEY = "comment";

    //审批结果标识 0-未通过,1-通过
    public static final String IS_AGREE_KEY = "isAgree";

    //上次审批人
    public static final String LAST_ASSIGNEE_KEY = "lastAssignee";

    //上次审批人名称
    public static final String LAST_ASSIGNEE_NAME_KEY = "lastAssigneeName";

    //审批驳回标识
    public static final String AUDIT_FAILED_SUFFIX = "failed";

    //审批通过标识
    public static final String AUDIT_PASSED_SUFFIX = "audit";

    //冒号
    public static final String COLON = ":";

    //网关标识
    public static final String EXCLUSIVE_GATEWAY_KEY = "Exclusive Gateway";

    //结束事件标识
    public static final String END_EVENT_KEY = "End Event";


}
