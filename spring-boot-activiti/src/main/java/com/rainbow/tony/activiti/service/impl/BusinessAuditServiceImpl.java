package com.rainbow.tony.activiti.service.impl;

import com.google.common.base.Preconditions;
import com.rainbow.tony.activiti.common.AuditMix;
import com.rainbow.tony.activiti.common.ListResult;
import com.rainbow.tony.activiti.common.PlainResult;
import com.rainbow.tony.activiti.service.IBusinessAuditService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.CommentEntity;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * �Ŵ���������ʵ����
 *
 * @author tony
 * @describe BusinessAuditServiceImpl
 * @date 2019-09-26
 */
@Service
public class BusinessAuditServiceImpl implements IBusinessAuditService {

    @Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskService taskService;
    @Autowired
    HistoryService historyService;
    @Autowired
    RepositoryService repositoryService;

    /**
     * ��������-�Ŵ������ϱ���������
     *
     * @param organCode ������
     * @param planOper  �ƻ��ƶ���
     * @param auditor   ��һ��������
     * @param planId    �ƻ���ʶ
     * @return ���������Ƿ�ɹ�
     */
    @Override
    public PlainResult<String> startLoanPlanAuditProcess(String organCode, String planOper, String auditor, String planId) {
        Preconditions.checkArgument(Objects.nonNull(organCode) && Objects.nonNull(planOper) && Objects.nonNull(auditor) && Objects.nonNull(planId));

        PlainResult<String> result = new PlainResult<>();
        try {
            ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(AuditMix.BUSINESS_BASE_PROCESS_KEY, new HashMap<>());
            String processInstanceId = processInstance.getId();
            Map<String, Object> varMap = buildVarMap(auditor, planOper, planId, processInstanceId);
            final int beginStep = 1;
            varMap.put(AuditMix.WHERE_KEY, beginStep);

            Task task = getTaskByProcessInstanceId(processInstanceId);
            taskService.complete(task.getId(), varMap);

            Task auditTask = getTaskByProcessInstanceId(processInstanceId);
            taskService.claim(auditTask.getId(), auditor + AuditMix.COLON + AuditMix.AUDIT_PASSED_SUFFIX);
            //todo ��������״̬

            return result.success("audit|start", "start audit task process.");
        } catch (Exception e) {
            return result.error(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "start audit task process.");
        }
    }

    /**
     * ��ȡ����ʵ��ID
     *
     * @param processInstanceId ����ʵ��ID
     * @return Task
     */
    private Task getTaskByProcessInstanceId(String processInstanceId) {
        return taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
    }

    /**
     * ��ѯ������������������ļ�¼
     *
     * @param assignee   ������
     * @param pageNumber ҳ��
     * @param pageSize   ҳ��С
     * @return ListResult
     */
    @Override
    public ListResult<?> listHistoryLoanPlanWithFinished(String assignee, int pageNumber, int pageSize) {
        Preconditions.checkArgument(null != assignee && 0L < pageNumber && 0L < pageSize);

        ListResult<?> result = new ListResult<>();
        List<HistoricTaskInstance> historyTaskInstanceList = historyService.createHistoricTaskInstanceQuery()
                .taskAssignee(assignee).processDefinitionKey(AuditMix.BUSINESS_BASE_PROCESS_KEY).processFinished().listPage(pageNumber - 1, pageSize);
        try {
            for (HistoricTaskInstance historicTaskInstance : historyTaskInstanceList) {
                String processInstanceId = historicTaskInstance.getProcessInstanceId();
                HistoricVariableInstance historicVariableInstance = historyService.createHistoricVariableInstanceQuery()
                        .processInstanceId(processInstanceId).variableName(AuditMix.BUSINESS_KEY).singleResult();
                String businessId = (String) historicVariableInstance.getValue();
            }
            return result;
        } catch (Exception e) {
            return result.error(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "list historic loan require with finished failed");
        }
    }

    /**
     * �г��Լ����������
     *
     * @param assignee   ������
     * @param pageNumber ҳ��
     * @param pageSize   ҳ���С
     * @return ���񼯺�
     */
    @Override
    public List<?> getAllAssigneeTask(String assignee, int pageNumber, int pageSize) {
        List<Task> taskList = taskService.createTaskQuery().processDefinitionKey(AuditMix.BUSINESS_BASE_PROCESS_KEY)
                .taskAssignee(assignee + AuditMix.COLON + AuditMix.AUDIT_PASSED_SUFFIX).listPage(pageNumber - 1, pageSize);
        for (Task task : taskList) {
            Map<String, Object> varMap = runtimeService.getVariables(task.getExecutionId());
            int where = (int) varMap.get(AuditMix.WHERE_KEY);
            String lastAssignee = (String) varMap.get(AuditMix.LAST_ASSIGNEE_KEY);
            String executionId = task.getExecutionId();
            String businessId = (String) runtimeService.getVariable(executionId, AuditMix.BUSINESS_KEY);
        }
        return null;
    }

    /**
     * ��ȡӵ���Ŵ����������Ĺ�Ա��Ϣ[ӳ���ɫ��Ϣ��]
     *
     * @param organLevel ��������
     * @return ��Ȩ������Ա�б�
     */
    @Override
    public ListResult<?> getOperInfoListByOrganLevel(String organLevel, String where) throws Exception {
        ListResult<?> result = new ListResult<>();
        Preconditions.checkArgument(Objects.nonNull(organLevel) && Objects.nonNull(where));
        String taskId = fetchTaskDefineRoleId(where);
        //TODO ��ȡ������ɫ
        return result;
    }

    /**
     * ͨ�������ѯѡ����ؽڵ��ɫ
     *
     * @param where ��λͬ���������ڵ�
     * @return ��λ�Ľڵ�ʵ������
     */
    private String fetchTaskDefineRoleId(String where) {
        return AuditMix.BUSINESS_AUDITOR_PREFIX + where;
    }


    /**
     * �Ŵ���������
     *
     * @param request �Ŵ���������
     * @return ����״̬
     * @throws Exception �쳣
     */
    @Override
    public PlainResult<String> auditLoanPlanRequest(HttpServletRequest request, String lastAssignee, String organCode, String lastAssigneeName) throws Exception {
        String taskId = request.getParameter(AuditMix.TASK_KEY);
        String businessId = request.getParameter(AuditMix.BUSINESS_KEY);
        String comment = request.getParameter(AuditMix.COMMENT_KEY);
        String isAgree = request.getParameter(AuditMix.IS_AGREE_KEY);
        String auditor = request.getParameter(AuditMix.ASSIGNEE_KEY);
        Preconditions.checkArgument(null != taskId && null != businessId && null != organCode && null != isAgree && null != comment);

        ActivityImpl activityImpl = getActivityImplByTaskId(taskId);
        boolean lastUserType = this.getLastUserType(activityImpl);
        PlainResult<String> result = new PlainResult<>();
        Map<String, Object> lastVarMap = taskService.getVariables(taskId);
        Map<String, Object> varMap = new HashMap<>();
        if (!lastUserType) {
            int newWhere = (int) lastVarMap.get(AuditMix.WHERE_KEY) + 1;
            varMap.put(AuditMix.WHERE_KEY, newWhere);
            varMap.put(AuditMix.ASSIGNEE_KEY, auditor);
        }

        varMap.put(AuditMix.TASK_KEY, taskId);
        varMap.put(AuditMix.BUSINESS_KEY, businessId);
        varMap.put(AuditMix.IS_AGREE_KEY, isAgree);
        varMap.put(AuditMix.COMMENT_KEY, comment);
        varMap.put(AuditMix.LAST_ASSIGNEE_KEY, lastAssignee);
        varMap.put(AuditMix.LAST_ASSIGNEE_NAME_KEY, lastAssigneeName);
        String processInstanceId = (String) lastVarMap.get(AuditMix.PROCESS_INSTANCE_ID);
        varMap.put(AuditMix.PROCESS_INSTANCE_ID, processInstanceId);
        completeTaskAudit(taskId, comment, varMap, lastUserType);
        return result.success("success", "audit task success");
    }

    /**
     * �ж��Ƿ������һ��������
     *
     * @param activityImpl activityImpl
     * @return �Ƿ������һ��������
     */
    private boolean getLastUserType(ActivityImpl activityImpl) {
        boolean lastUserType = false;
        List<PvmTransition> pvmList = activityImpl.getOutgoingTransitions();
        if (pvmList != null && pvmList.size() > 0) {
            for (PvmTransition pvm : pvmList) {
                PvmActivity act = pvm.getDestination();
                if (AuditMix.EXCLUSIVE_GATEWAY_KEY.equals(act.getProperty("name"))) {
                    List<PvmTransition> actList = act.getOutgoingTransitions();
                    if (actList != null && actList.size() > 0) {
                        for (PvmTransition gwt : actList) {
                            PvmActivity gw = gwt.getDestination();
                            if (AuditMix.END_EVENT_KEY.equals(gw.getProperty("name"))) {
                                lastUserType = true;
                            }
                        }
                    }
                }
            }
        }
        return lastUserType;
    }

    /**
     * �������ص������б�
     *
     * @param assignee ������
     * @param pageNo   ҳ��
     * @param pageSize ҳ��С
     * @return ListResult
     */
    @Override
    public ListResult<?> getRollbackTaskListByAssignee(String assignee, int pageNo, int pageSize) {
        Preconditions.checkArgument(null != assignee && 0 < pageNo && 0 < pageSize);

        ListResult<?> result = new ListResult<>();
        List<Task> taskList = taskService.createTaskQuery().processDefinitionKey(AuditMix.BUSINESS_BASE_PROCESS_KEY)
                .taskAssignee(assignee + AuditMix.COLON + AuditMix.AUDIT_FAILED_SUFFIX).listPage(pageNo - 1, pageSize);

        for (Task task : taskList) {
            Map<String, Object> varMap = taskService.getVariables(task.getId());
            String businessId = (String) varMap.get(AuditMix.BUSINESS_KEY);
            //todo ֧��ҵ�����
        }
        return result;


    }

    /**
     * ����Ŵ���������
     *
     * @param taskId  ����Id
     * @param comment ��������
     * @param varMap  ��������
     */
    @Override
    public void completeTaskAudit(String taskId, String comment, Map<String, Object> varMap, boolean lastUserType) {
        String isAgree = (String) varMap.get(AuditMix.IS_AGREE_KEY);
        String businessId = (String) varMap.get(AuditMix.BUSINESS_KEY);
        String lastUser = (String) varMap.get(AuditMix.LAST_ASSIGNEE_KEY);
        //todo ����״̬
        switch (isAgree) {
            case AuditMix.AUDIT_FAILED:
                break;
            case AuditMix.AUDIT_PASSED:
                if (lastUserType) {
                } else {
                }
                break;
        }
        String processInstanceId = (String) varMap.get(AuditMix.PROCESS_INSTANCE_ID);
        Authentication.setAuthenticatedUserId(lastUser);
        taskService.addComment(taskId, processInstanceId, comment);
        taskService.complete(taskId, varMap);

        if (!lastUserType && !AuditMix.AUDIT_FAILED.equals(isAgree)) {
            Task auditTask = taskService.createTaskQuery().processDefinitionKey(AuditMix.BUSINESS_BASE_PROCESS_KEY).processInstanceId(processInstanceId).singleResult();
            if (Objects.nonNull(auditTask)) {
                String assignee = (String) varMap.get(AuditMix.ASSIGNEE_KEY);
                taskService.claim(auditTask.getId(), assignee + AuditMix.COLON + AuditMix.AUDIT_PASSED_SUFFIX);
            }
        } else if (AuditMix.AUDIT_FAILED.equals(isAgree)) {
            Task auditTask = taskService.createTaskQuery().processDefinitionKey(AuditMix.BUSINESS_BASE_PROCESS_KEY).processInstanceId(processInstanceId).singleResult();
            if (Objects.nonNull(auditTask)) {
                HistoricVariableInstance historicVariableInstance = historyService.createHistoricVariableInstanceQuery()
                        .variableName(AuditMix.BUSINESS_OPER_KEY).processInstanceId(processInstanceId).singleResult();
                String assignee = (String) historicVariableInstance.getValue();
                taskService.claim(auditTask.getId(), assignee + AuditMix.COLON + AuditMix.AUDIT_FAILED_SUFFIX);
            }
        }
    }

    /**
     * ������ͨ�����Ŵ��ƻ�,��������
     *
     * @param assignee ������
     * @param planOper �ƻ��ƶ���
     * @param planId   �ƻ���ʶ
     * @param taskId   ���������ʶ
     * @return PlainResult
     */
    public PlainResult<String> resubmitRollBackTask(String assignee, String planOper, String planId, String taskId) {
        PlainResult<String> result = new PlainResult<>();
        Map<String, Object> lastVarMap = taskService.getVariables(taskId);
        String processInstanceId = (String) lastVarMap.get(AuditMix.PROCESS_INSTANCE_ID);
        Map<String, Object> varMap = buildVarMap(assignee, planOper, planId, processInstanceId);
        try {
            taskService.complete(taskId, varMap);
            Task auditTask = getTaskByProcessInstanceId(processInstanceId);
            taskService.claim(auditTask.getId(), assignee + AuditMix.COLON + AuditMix.AUDIT_PASSED_SUFFIX);
            //todo ����״̬
            return result.success("audit|resubmit", "resubmit audit task success.");
        } catch (Exception e) {
            return result.error(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "resubmit audit task error.");
        }
    }

    /**
     * �������̱�������
     *
     * @param assignee          ������
     * @param businessOper      ҵ�񴴽���
     * @param businessId        �ƻ���ʶ
     * @param processInstanceId ����ʵ����ʶ
     * @return Map
     */
    private Map<String, Object> buildVarMap(String assignee, String businessOper, String businessId, String processInstanceId) {
        Map<String, Object> varMap = new HashMap<>();
        varMap.put(AuditMix.BUSINESS_KEY, businessId);
        varMap.put(AuditMix.PROCESS_INSTANCE_ID, processInstanceId);
        varMap.put(AuditMix.ASSIGNEE_KEY, assignee);
        varMap.put(AuditMix.BUSINESS_OPER_KEY, businessOper);
        int beginStep = 1;
        varMap.put(AuditMix.WHERE_KEY, beginStep);
        return varMap;
    }

    public List<Comment> getTaskComments(String taskId) throws Exception {
        List<Comment> comments = new ArrayList<>();
        Task task = getTaskById(taskId);
        String processInstanceId = task.getProcessInstanceId();

        List<HistoricTaskInstance> hti = historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstanceId)
                .orderByHistoricTaskInstanceEndTime().desc().list();

        for (HistoricTaskInstance historicTaskInstance : hti) {
            List<Comment> list = taskService.getTaskComments(historicTaskInstance.getId());
            comments.addAll(list);
        }

        CommentEntity comment = new CommentEntity();
        String assignee = task.getAssignee().substring(0, 11);
        comment.setUserId(assignee);
        comment.setFullMessage("������");
        comments.add(comment);
        return comments;
    }

    private Task getTaskById(String taskId) throws Exception {
        return taskService.createTaskQuery().taskId(taskId).singleResult();
    }

    public ActivityImpl getActivityImplByTaskId(String taskId) throws Exception {
        Task task = getTaskById(taskId);
        //1.��ȡ��ǰ��ڵ㷽����Ϊ������룬����ķ�ʽ���������л�ȡ������ڵ�ID
        String excId = task.getExecutionId();
        ExecutionEntity execution = (ExecutionEntity) runtimeService.createExecutionQuery().executionId(excId).singleResult();
        String activityId = execution.getActivityId();
        //2.��ȡ���̶���,��ڵ�(ActivityImpl�����ڴ���,���Բ�����Query�����ѯ)
        ProcessDefinitionEntity pd = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(task.getProcessDefinitionId());
        //3.ͨ����Ľڵ�ID��ȡ�ڵ����
        return pd.findActivity(activityId);
    }
}

