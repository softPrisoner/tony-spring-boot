package com.tony.spring.dto.config;

import com.tony.spring.dto.pojo.StudentDO;
import com.tony.spring.dto.pojo.StudentDTO;
import com.tony.spring.dto.pojo.StudentVO;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tony
 * @describe DozerTest
 * @date 2019-08-01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DozerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DozerTest.class);
    @Autowired
    private Mapper dozerMapper;

    @Test
    public void test() {
        List<String> lists = new ArrayList<>();
        lists.add("Shanghai");
        lists.add("Beijing");
        lists.add("Hangzhou");
        StudentDO studentDO = new StudentDO().setId(1L).setName("tony").setAge(15)
                .setTelephone("110").setAddress(lists)
                .setUsername("tony@qq.com").setPassword("123456");
        //只需要部分对象属性应该选择做?
        //todo only part of properties
        //if need transfer to bean fast,is it?.
        StudentVO vo = dozerMapper.map(studentDO, StudentVO.class);
        LOGGER.info(vo.toString());
        LOGGER.info(studentDO.toString());
        //copy value copy or address copy?
        vo.setAge(18);
        System.out.println(vo);
        System.out.println(studentDO);

    }

    @Test
    public void beanUtilsTest() {
        long startAt = System.currentTimeMillis();
        List<String> lists = new ArrayList<>();
        lists.add("Shanghai");
        lists.add("Beijing");
        lists.add("Hangzhou");
        StudentDO studentDO = new StudentDO().setId(1L).setName("tony").setAge(15)
                .setTelephone("110").setAddress(lists)
                .setUsername("tony@qq.com").setPassword("123456");
        LOGGER.info(studentDO.toString());
        StudentDTO studentDTO = new StudentDTO();
        //fix-@Accessors(chain = true)  not matches setP getP
        BeanUtils.copyProperties(studentDO, studentDTO);
        long endAt = System.currentTimeMillis();
        LOGGER.info("total take {} ms", endAt - startAt);
        LOGGER.info(studentDTO.toString());
    }
}
