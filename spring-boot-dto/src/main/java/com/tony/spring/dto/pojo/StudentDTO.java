package com.tony.spring.dto.pojo;

import lombok.Data;

/**
 * @author tony
 * @describe StudentDTO
 * @date 2019-08-01
 */
@Data
public class StudentDTO {
    private Long id;
    private String name;
    private String mobile;
    private String addr;
    private String avatar;
}
