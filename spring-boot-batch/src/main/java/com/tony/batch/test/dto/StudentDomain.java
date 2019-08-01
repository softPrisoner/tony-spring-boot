package com.tony.batch.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tony
 * @describe StudentDomain
 * @date 2019-08-01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDomain {
    private Long id;
    private String name;
    private Integer age;
    private String mobile;
}
