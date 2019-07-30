package com.tony.batch;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author tony
 * @describe Person
 * @date 2019-07-30
 */
@Data
@ToString
@Accessors(fluent = true, prefix = "test")
public class Person {
//    private String firstName;
//    private String lastName;
    private String testFirstName;

    public static void main(String[] args) {
        Person p = new Person();
//        p.firstName("testPeter").lastName("testSmith");
//        System.out.println(p.firstName());
//        System.out.println(p.lastName());
        p.firstName("111");
        System.out.println(p.firstName());

    }
}
