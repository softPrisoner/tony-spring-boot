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
     * 启动业务审批流程
     *
     * @param organCode    机构号
     * @param businessOper 业务创建人
     * @param assignee     审批人
     * @param businessId   业务ID
     * @return
     */
    PlainResult<String> startBusinessAuditProcess(String organCode, String businessOper, String assignee, String businessId);

    /**
     * 信贷计划审批请求 0-驳回 1-同意
     */
    PlainResult<String> auditBusinessRequest(HttpServletRequest request, String assignee, String organCode, String assigneeName) throws Exception;

    /**
     * 完成任务审批
     *
     * @param taskId       任务ID
     * @param comment      任务评语
     * @param varMap       变量集合
     * @param lastUserType 是否是最后一个节点
     * @throws Exception 异常
     */
    void completeTaskAudit(String taskId, String comment, Map<String, Object> varMap, boolean lastUserType) throws Exception;

    /**
     * 通过机构级别获取审批员信息
     *
     * @param organLevel
     * @param where
     * @return
     * @throws Exception
     */
    ListResult<?> getOperInfoListByOrganLevel(String organLevel, String where) throws Exception;

    /**
     * 获取所有用户任务
     *
     * @param assignee   审批人
     * @param pageNumber 页号
     * @param pageSize   页大小
     * @return List
     * @throws Exception 异常
     */
    List<?> getAllAssigneeTask(String assignee, int pageNumber, int pageSize) throws Exception;

    /**
     * 列出历史已审批完的信贷计划
     *
     * @param assignee   审批人
     * @param pageNumber 页号
     * @param pageSize   页大小
     * @return ListResult
     * @throws Exception 异常
     */
    ListResult<?> listHistoryLoanPlanWithFinished(String assignee, int pageNumber, int pageSize) throws Exception;

    /**
     * 获取柜员所有驳回的任务
     *
     * @param assignee
     * @param pageNo
     * @param pageSize
     * @return
     */
    ListResult<?> getRollbackTaskListByAssignee(String assignee, int pageNo, int pageSize);

    /**
     * 重新提交驳回的信贷计划
     *
     * @param assignee     审批人
     * @param businessOper 业务柜员
     * @param businessId   业务id
     * @param taskId       任务id
     * @return
     */
    PlainResult<String> resubmitRollBackTask(String assignee, String businessOper, String businessId, String taskId);

    /**
     * 根据任务ID获取任务评语
     *
     * @param taskId 任务ID
     * @return List
     * @throws Exception 异常
     */
    List<Comment> getTaskComments(String taskId) throws Exception;
}
