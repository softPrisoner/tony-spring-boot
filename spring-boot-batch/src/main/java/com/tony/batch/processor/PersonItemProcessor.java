package com.tony.batch.processor;

import com.tony.batch.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * @author tony
 * @describe PersonItemProcessor
 * @date 2019-07-30
 */
public class PersonItemProcessor implements ItemProcessor<Person, String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public String process(Person person) throws Exception {
        String greeting = "Hello "
                + person.firstName()
                + " "
                + person.lastName() + "!";
        LOGGER.info("converting '{}' into '{}'", person, greeting);
        return greeting;
    }
}
