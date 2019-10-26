package com.tony.spring.dto.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author tony
 * @describe StudentDTO
 * @date 2019-08-01
 */
@Data
@ToString
@Accessors(chain = true)
public class StudentDTO implements Serializable {
    private static final long serialVersionUID = 6736480979449070797L;
    private Long id;
    private String name;
    private String mobile;
    private String addr;
    private List<String> address;
    private String avatar;
}
