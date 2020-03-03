package com.tony.serilize;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 实现Serializable接口
 *
 * @author tony
 * @description Student
 * @copyright rainbow
 * @date 2020/03/02
 */
@Setter
@Getter
@ToString(callSuper = true)
public class Student implements Serializable {
    private transient String name;


}
