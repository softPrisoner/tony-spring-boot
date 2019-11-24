package com.rainbow.tony.activiti.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

/**
 * @author tony
 * @describe UserTaskExecutionStartListener
 * @date 2019-08-30
 */
public class UserTaskExecutionFinishListener implements ExecutionListener {
    @Override
    public void notify(DelegateExecution delegateExecution) {
        System.out.println(delegateExecution.getId());
    }
}
