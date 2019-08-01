package com.tony.spring.dto.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author tony
 * @describe StudentDomain
 * @date 2019-08-01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentVO {
    private Long id;
    private String name;
    private Integer age;
    private String mobile;
    private String addr;
}
