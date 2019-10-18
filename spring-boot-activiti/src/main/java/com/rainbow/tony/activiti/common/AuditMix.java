package com.rainbow.tony.activiti.common;

import java.io.Serializable;

/**
 * 审批常量类
 *
 * @author tony
 * @describe AuditMix
 * @date 2019-10-16
 */
public final class AuditMix implements Serializable {
    private static final long serialVersionUID = -5888568941980132203L;

    public static final String AUDIT_FAILED = "0";

    public static final String AUDIT_PASSED = "1";

    public static final String BUSINESS_BASE_PROCESS_KEY = "business_base_process_key";
    public static final String BUSINESS_AUDITOR_PREFIX = "audit_node_level";

    public static final String BUSINESS_KEY = "businessId";

    public static final String WHERE_KEY = "where";

    public static final String ASSIGNEE_KEY = "assignee";

    public static final String BUSINESS_OPER_KEY = "business_operator_key";

    public static final String PROCESS_INSTANCE_ID = "processInstanceId";

    public static final String TASK_KEY = "taskId";

    public static final String COMMENT_KEY = "comment";

    public static final String IS_AGREE_KEY = "isAgree";

    public static final String LAST_ASSIGNEE_KEY = "lastAssignee";

    public static final String LAST_ASSIGNEE_NAME_KEY = "lastAssigneeName";

    public static final String AUDIT_FAILED_SUFFIX = "failed";

    public static final String AUDIT_PASSED_SUFFIX = "audit";

    public static final String COLON = ":";

    public static final String EXCLUSIVE_GATEWAY_KEY = "Exclusive Gateway";

    public static final String END_EVENT_KEY = "End Event";


}
