package com.rainbow.tony.activiti.service;

import com.rainbow.tony.activiti.common.ListResult;
import com.rainbow.tony.activiti.common.PlainResult;
import org.activiti.engine.task.Comment;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author tony
 * @describe IBusinessAuditService
 * @date 2019-09-26
 */
public interface IBusinessAuditService {

    /**
     * ����ҵ����������
     *
     * @param organCode    ������
     * @param businessOper ҵ�񴴽���
     * @param assignee     ������
     * @param businessId   ҵ��ID
     * @return
     */
    PlainResult<String> startBusinessAuditProcess(String organCode, String businessOper, String assignee, String businessId);

    /**
     * �Ŵ��ƻ��������� 0-���� 1-ͬ��
     */
    PlainResult<String> auditBusinessRequest(HttpServletRequest request, String assignee, String organCode, String assigneeName) throws Exception;

    /**
     * �����������
     *
     * @param taskId       ����ID
     * @param comment      ��������
     * @param varMap       ��������
     * @param lastUserType �Ƿ������һ���ڵ�
     * @throws Exception �쳣
     */
    void completeTaskAudit(String taskId, String comment, Map<String, Object> varMap, boolean lastUserType) throws Exception;

    /**
     * ͨ�����������ȡ����Ա��Ϣ
     *
     * @param organLevel
     * @param where
     * @return
     * @throws Exception
     */
    ListResult<?> getOperInfoListByOrganLevel(String organLevel, String where) throws Exception;

    /**
     * ��ȡ�����û�����
     *
     * @param assignee   ������
     * @param pageNumber ҳ��
     * @param pageSize   ҳ��С
     * @return List
     * @throws Exception �쳣
     */
    List<?> getAllAssigneeTask(String assignee, int pageNumber, int pageSize) throws Exception;

    /**
     * �г���ʷ����������Ŵ��ƻ�
     *
     * @param assignee   ������
     * @param pageNumber ҳ��
     * @param pageSize   ҳ��С
     * @return ListResult
     * @throws Exception �쳣
     */
    ListResult<?> listHistoryLoanPlanWithFinished(String assignee, int pageNumber, int pageSize) throws Exception;

    /**
     * ��ȡ��Ա���в��ص�����
     *
     * @param assignee
     * @param pageNo
     * @param pageSize
     * @return
     */
    ListResult<?> getRollbackTaskListByAssignee(String assignee, int pageNo, int pageSize);

    /**
     * �����ύ���ص��Ŵ��ƻ�
     *
     * @param assignee     ������
     * @param businessOper ҵ���Ա
     * @param businessId   ҵ��id
     * @param taskId       ����id
     * @return
     */
    PlainResult<String> resubmitRollBackTask(String assignee, String businessOper, String businessId, String taskId);

    /**
     * ��������ID��ȡ��������
     *
     * @param taskId ����ID
     * @return List
     * @throws Exception �쳣
     */
    List<Comment> getTaskComments(String taskId) throws Exception;
}
