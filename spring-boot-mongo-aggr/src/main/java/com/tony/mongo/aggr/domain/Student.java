package com.tony.mongo.aggr.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * Student info
 *
 * @author tony
 * @describe MongoApplication
 * @date 2019/12/20
 */
@Document(collection = "student")
@Data
@Accessors(chain = true)
public class Student implements Serializable {

    @Id
    @Field("id")
    private Integer id;
    private String name;
    private String sex;
    private Integer classId;

}
