package com.tony.spring.dto.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author tony
 * @describe StudentDO
 * @date 2019-08-01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class StudentDO implements Serializable {
    private static final long serialVersionUID = 7821398898144192688L;
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
