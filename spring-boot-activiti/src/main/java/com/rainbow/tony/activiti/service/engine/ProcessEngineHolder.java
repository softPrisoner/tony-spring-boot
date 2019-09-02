package com.rainbow.tony.activiti.service.engine;

import lombok.Getter;
import org.activiti.engine.*;

/**
 * @author tony
 * @describe ProcessEngineHolder
 * @date 2019-09-01
 */
public final class ProcessEngineHolder {
    private static RepositoryService repositoryService;
    private static HistoryService historyService;
    private static RuntimeService runtimeService;
    private static TaskService taskService;
    private static ManagementService managerService;
    private static DynamicBpmnService dynamicBpmnService;

    private ProcessEngineHolder() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        repositoryService = processEngine.getRepositoryService();
        historyService = processEngine.getHistoryService();
        runtimeService = processEngine.getRuntimeService();
        taskService = processEngine.getTaskService();
        managerService = processEngine.getManagementService();
        dynamicBpmnService = processEngine.getDynamicBpmnService();
    }

    public static RepositoryService getRepositoryService() {
        return repositoryService;
    }

    public static HistoryService getHistoryService() {
        return historyService;
    }

    public static RuntimeService getRuntimeService() {
        return runtimeService;
    }

    public static TaskService getTaskService() {
        return taskService;
    }

    public static ManagementService getManagementService() {
        return managerService;
    }

    public static DynamicBpmnService getDynamicBpmnService() {
        return dynamicBpmnService;
    }
}
