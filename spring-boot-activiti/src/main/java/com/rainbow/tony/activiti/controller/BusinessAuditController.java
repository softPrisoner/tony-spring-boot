package com.rainbow.tony.activiti.controller;

import com.rainbow.tony.activiti.annotation.SystemLog;
import com.rainbow.tony.activiti.common.Dictionary;
import com.rainbow.tony.activiti.service.IBusinessAuditService;
import org.activiti.engine.task.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 业务流程审批接口类
 *
 * @author tony
 * @describe BusinessAuditController
 * @date 2019-10-10
 */
@Controller
@RequestMapping("/businessKey")
public class BusinessAuditController extends BaseController {
    @Autowired
    IBusinessAuditService businessAuditService;

    @GetMapping("/showWaitForAuditTaskListUI")
    @SystemLog(businessName = "业务名称", functionCode = "功能编码", functionName = "功能名称", accessType = Dictionary.AccessType.READ, logLevel = Dictionary.LogLevel.DEBUG)
    public String showWaitForAuditTaskListUI() throws Exception {
        return basePath + "";
    }

    @GetMapping("/showAuditedTaskListUI")
    @SystemLog(businessName = "业务名称", functionCode = "001", functionName = "功能名称", accessType = Dictionary.AccessType.READ, logLevel = Dictionary.LogLevel.DEBUG)
    public String showAuditedTaskListUI() throws Exception {
        return basePath + "";
    }

    @GetMapping("/showResubmitAuditTaskUI")
    @SystemLog(businessName = "业务名称", functionCode = "功能编码", functionName = "功能名称", accessType = Dictionary.AccessType.READ, logLevel = Dictionary.LogLevel.DEBUG)
    public String showResubmitAuditTaskUI(String taskId, String businessId) throws Exception {
        List<Comment> comments = businessAuditService.getTaskComments(taskId);
        return basePath + "";
    }

    @GetMapping("/showRollBackTaskListUI")
    @SystemLog(businessName = "业务名称", functionCode = "功能编码", functionName = "功能名称", accessType = Dictionary.AccessType.READ, logLevel = Dictionary.LogLevel.DEBUG)
    public String showRollBackTaskListUI() throws Exception {
        return basePath + "";
    }

    @GetMapping("/showBusinessDetailAuditUI")
    @SystemLog(businessName = "业务名称", functionCode = "功能编码", functionName = "功能名称", accessType = Dictionary.AccessType.READ, logLevel = Dictionary.LogLevel.DEBUG)
    public String showBusinessDetailAuditUI(String taskId, String businessId) throws Exception {
        List<Comment> comments = businessAuditService.getTaskComments(taskId);
        return basePath + "";
    }

    @ResponseBody
    @GetMapping(value = "/startBusinessAuditProcess")
    @SystemLog(businessName = "业务名称", functionCode = "001", functionName = "功能名称", accessType = Dictionary.AccessType.READ, logLevel = Dictionary.LogLevel.DEBUG)
    public String startBusinessAuditProcess(String assignee, String businessId) throws Exception {
        return "";
    }

    @ResponseBody
    @GetMapping(value = "/listAuditingTaskByAssignee")
    @SystemLog(businessName = "业务名称", functionCode = "功能编码", functionName = "功能名称", accessType = Dictionary.AccessType.READ, logLevel = Dictionary.LogLevel.DEBUG)
    public String listAuditingTaskByAssignee(String assignee) throws Exception {
        return "";
    }

    @ResponseBody
    @GetMapping("/listAuditedTaskListByAssignee")
    @SystemLog(businessName = "业务名称", functionCode = "功能编码", functionName = "功能名称", accessType = Dictionary.AccessType.READ, logLevel = Dictionary.LogLevel.DEBUG)
    public String listAuditedTaskListByAssignee() throws Exception {
        return "";
    }

    @ResponseBody
    @PostMapping("/auditBusinessTask")
    @SystemLog(businessName = "业务名称", functionCode = "功能编码", functionName = "功能名称", accessType = Dictionary.AccessType.WRITE, logLevel = Dictionary.LogLevel.DEBUG)
    public String auditBusinessTask() throws Exception {
        return "";
    }

    @ResponseBody
    @GetMapping("/listAssigneeInfoList")
    @SystemLog(businessName = "业务名称", functionCode = "功能编码", functionName = "功能名称", accessType = Dictionary.AccessType.READ, logLevel = Dictionary.LogLevel.DEBUG)
    public String listAssigneeInfoList(String position) throws Exception {
        return "";
    }

    @ResponseBody
    @GetMapping("/listHistoryBusinessInfoWithFinished")
    @SystemLog(businessName = "业务名称", functionCode = "PUB-03", functionName = "获取已审批的任务", accessType = Dictionary.AccessType.READ, logLevel = Dictionary.LogLevel.DEBUG)
    public String listHistoryBusinessInfoWithFinished() throws Exception {
        return "";
    }

    @ResponseBody
    @GetMapping("/listRollBackTaskListByAssignee")
    @SystemLog(businessName = "业务名称", functionCode = "PUB-03", functionName = "获取已驳回的任务", accessType = Dictionary.AccessType.READ, logLevel = Dictionary.LogLevel.DEBUG)
    public String listRollBackTaskListByAssignee() throws Exception {
        return "";
    }

    @ResponseBody
    @GetMapping("/resubmitRollbackAuditTask")
    @SystemLog(businessName = "信贷计划", functionCode = "PUB-03", functionName = "重新提交驳回的任务", accessType = Dictionary.AccessType.WRITE, logLevel = Dictionary.LogLevel.DEBUG)
    public String resubmitRollbackAuditTask() throws Exception {
        return "";
    }
}
