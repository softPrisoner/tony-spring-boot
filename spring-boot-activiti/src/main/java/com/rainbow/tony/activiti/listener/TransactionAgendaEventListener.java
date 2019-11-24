package com.rainbow.tony.activiti.listener;

import org.kie.api.definition.rule.Rule;
import org.kie.api.event.rule.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tony
 * @describe TransactionAgendaEventListener
 * @date 2019-08-28
 */
public class TransactionAgendaEventListener implements AgendaEventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionAgendaEventListener.class);

    @Override
    public void matchCreated(MatchCreatedEvent matchCreatedEvent) {
        int count = (int) matchCreatedEvent.getKieRuntime().getGlobal("count");
        if (count > 5) {
            //相当于处理监听,需要处理数据
        }
        Rule rule = matchCreatedEvent.getMatch().getRule();
        LOGGER.info("current rule name:" + rule.getName());
    }

    @Override
    public void matchCancelled(MatchCancelledEvent matchCancelledEvent) {

    }

    @Override
    public void beforeMatchFired(BeforeMatchFiredEvent beforeMatchFiredEvent) {

    }

    @Override
    public void afterMatchFired(AfterMatchFiredEvent afterMatchFiredEvent) {
        LOGGER.info("ready for database h2");
    }

    @Override
    public void agendaGroupPopped(AgendaGroupPoppedEvent agendaGroupPoppedEvent) {

    }

    @Override
    public void agendaGroupPushed(AgendaGroupPushedEvent agendaGroupPushedEvent) {

    }

    @Override
    public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent ruleFlowGroupActivatedEvent) {

    }

    @Override
    public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent ruleFlowGroupActivatedEvent) {

    }

    @Override
    public void beforeRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent ruleFlowGroupDeactivatedEvent) {

    }

    @Override
    public void afterRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent ruleFlowGroupDeactivatedEvent) {

    }
}
