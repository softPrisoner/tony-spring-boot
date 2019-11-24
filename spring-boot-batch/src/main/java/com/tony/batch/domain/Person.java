package com.tony.batch.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author tony
 * @describe Person
 * @date 2019-07-30
 */
@Data
@ToString
// prefix = "test"
@Accessors(fluent = true)
@NoArgsConstructor
public class Person {
    private String firstName;
    private String lastName;

    //必须显式声明get,set方法.非编译后处理
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //    private String testFirstName;
    public static void main(String[] args) {
        Person p = new Person();
//        p.firstName("testPeter").lastName("testSmith");
//        System.out.println(p.firstName());
//        System.out.println(p.lastName());
        p.firstName("111");
        System.out.println(p.firstName());

    }
}
