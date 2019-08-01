package com.tony.spring.dto.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author tony
 * @describe StudentDO
 * @date 2019-08-01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class StudentDO {
    private Long id;
    private int sex;
    private String name;
    private Integer age;
    private String avatar;
    private String telephone;
    private List<String> address;
    private String username;
    private String password;

}
