package com.tony.mongo.aggr.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * Grade info
 *
 * @author tony
 * @describe MongoApplication
 * @date 2019/12/20
 */
@Document(collection = "grade")
@Data
@Accessors(chain = true)
public class Grade implements Serializable {
    @Field("id")
    @Id
    private Integer id;
    private String gradeName;
    private Integer mark;
}
