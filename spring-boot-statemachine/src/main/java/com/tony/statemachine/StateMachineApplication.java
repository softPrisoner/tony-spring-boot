package com.tony.statemachine;

import com.tony.statemachine.enums.Events;
import com.tony.statemachine.enums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

/**
 * @author tony
 * @describe StateMachineApplication
 * @date 2019-10-26
 */

@SpringBootApplication
public class StateMachineApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(StateMachineApplication.class, args);
    }

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @Override
    public void run(String... args) throws Exception {
        stateMachine.start();
        stateMachine.sendEvent(Events.PAY);
        stateMachine.sendEvent(Events.RECEIVE);
    }
}
