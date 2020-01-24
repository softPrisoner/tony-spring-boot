package com.tony.mongo.aggr.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class info
 *
 * @author tony
 * @describe ClassInfo
 * @date 2019/12/20
 */
@Document(collection = "class")
@Data
@Accessors(chain = true)
public class ClassInfo implements Serializable {
    @Field("id")
    @Id
    private Integer id;
    private String className;

    @DBRef(db = "student")
    private List<Student> studentList = new ArrayList<>();
}
