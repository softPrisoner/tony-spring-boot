package com.rainbow.tony.activiti.listener;

import org.activiti.bpmn.model.EventListener;
import org.activiti.bpmn.model.ExtensionAttribute;

import java.util.List;
import java.util.Map;

/**
 * @author tony
 * @describe UserTaskEventListener
 * @date 2019-08-29
 */
public class UserTaskEventListener extends EventListener {
    @Override
    public Map<String, List<ExtensionAttribute>> getAttributes() {
        return super.getAttributes();
    }
}
