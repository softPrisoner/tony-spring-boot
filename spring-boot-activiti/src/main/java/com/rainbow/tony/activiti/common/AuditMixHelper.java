package com.rainbow.tony.activiti.common;

import java.io.Serializable;

/**
 * �Ŵ��ƻ�/��������
 *
 * @author tony
 * @describe PlanMix
 * @date 2019-10-16
 */
public final class AuditMixHelper implements Serializable {
    private static final long serialVersionUID = -5888568941980132203L;
    //�������ر�ʶ
    public static final String AUDIT_FAILED = "0";

    //����ͨ����ʶ
    public static final String AUDIT_PASSED = "1";

    //ҵ�����̱�ʶ
    public static final String BUSINESS_BASE_PROCESS_KEY = "business_base_process_key";

    //�ƻ��������̽ڵ��ʶǰ׺
    public static final String BUSINESS_AUDITOR_PREFIX = "audit_node_level";

    //ҵ��������ʶ
    public static final String BUSINESS_KEY = "businessId";

    //���̽��ȱ�ʶ
    public static final String WHERE_KEY = "where";

    //�����˱�ʶ
    public static final String ASSIGNEE_KEY = "assignee";

    //���񴴽��˱�ʶ
    public static final String BUSINESS_OPER_KEY = "business_operator_key";

    //����ʵ��ID
    public static final String PROCESS_INSTANCE_ID = "processInstanceId";

    //��������Id
    public static final String TASK_KEY = "taskId";

    //���������ʶ
    public static final String COMMENT_KEY = "comment";

    //���������ʶ 0-δͨ��,1-ͨ��
    public static final String IS_AGREE_KEY = "isAgree";

    //�ϴ�������
    public static final String LAST_ASSIGNEE_KEY = "lastAssignee";

    //�ϴ�����������
    public static final String LAST_ASSIGNEE_NAME_KEY = "lastAssigneeName";

    //�������ر�ʶ
    public static final String AUDIT_FAILED_SUFFIX = "failed";

    //����ͨ����ʶ
    public static final String AUDIT_PASSED_SUFFIX = "audit";

    //ð��
    public static final String COLON = ":";

    //���ر�ʶ
    public static final String EXCLUSIVE_GATEWAY_KEY = "Exclusive Gateway";

    //�����¼���ʶ
    public static final String END_EVENT_KEY = "End Event";


}
