package com.rainbow.tony.activiti.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.TaskListener;

/**
 * @author tony
 * @describe UserTaskListener
 * @date 2019-08-28
 */
public class UserTaskListener implements TaskListener {
    private Expression content;
    private Expression task;

    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.setVariable("setInTaskCreate", delegateTask.getEventName()
                + "," + content.getValue(delegateTask));
        //重新分配任务
        delegateTask.setAssignee("jenny");
    }
}
