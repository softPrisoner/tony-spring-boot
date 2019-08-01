package com.tony.batch.test.dto;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tony
 * @describe Test
 * @date 2019-08-01
 */
public class Test {
    @Autowired
    private Mapper dozerMapper;

    public void test() {
        StudentDomain studentDomain = new StudentDomain(1L, "张三", 15, "15638509412");

        //只需要部分对象属性应该选择做?
        StudentVO vo = dozerMapper.map(studentDomain, StudentVO.class);
        System.out.println(vo);
        System.out.println(studentDomain);
        //对象属性是浅拷贝还是深拷贝
        vo.setAge(18);
        System.out.println(vo);
        System.out.println(studentDomain);

    }
}
