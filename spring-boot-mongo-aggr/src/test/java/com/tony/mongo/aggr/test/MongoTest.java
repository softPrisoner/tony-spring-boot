package com.tony.mongo.aggr.test;

import com.mongodb.BasicDBObject;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.tony.mongo.aggr.MongoApplication;
import com.tony.mongo.aggr.domain.ClassInfo;
import com.tony.mongo.aggr.domain.Grade;
import com.tony.mongo.aggr.domain.Student;
import org.assertj.core.util.Lists;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoApplication.class)
public class MongoTest {
    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void createTestData() {
        //Init grade info object
        Grade grade1 = new Grade();
        grade1.setGradeName("math");
        grade1.setId(1);
        grade1.setMark(45);
        mongoTemplate.save(grade1);

        Grade grade2 = new Grade();
        grade2.setGradeName("english");
        grade2.setId(2);
        grade2.setMark(80);
        mongoTemplate.save(grade2);

        List<Grade> gradeList = new ArrayList<>();
        gradeList.add(grade1);
        gradeList.add(grade2);
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("tony");
        student1.setSex("male");
        mongoTemplate.save(student1);
        //Init student info
        Student student2 = new Student();
        student2.setId(2);
        student2.setName("white");
        student2.setSex("female");
        mongoTemplate.save(student2);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        //Init class info
        ClassInfo classInfo1 = new ClassInfo();
        classInfo1.setClassName("Class One");
        classInfo1.setId(1);
        classInfo1.setStudentList(studentList);
        mongoTemplate.save(classInfo1);


    }

    @Test
    public void testMongo1() {
        MongoCollection<Document> mongoCollection = mongoTemplate.getCollection("class");
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("studentList.$ref", "student");
        FindIterable<Document> documents = mongoCollection.find(basicDBObject);
        for (Document next : documents) {
            System.out.println(next.toString());
        }
    }

    @Test
    public void testMongo() {
        BasicDBObject lookUpExp = new BasicDBObject();
        //Aggregate condition for $lookup
        BasicDBObject lookUpCondition = new BasicDBObject();
        lookUpCondition.put("from", "student");
        lookUpCondition.put("localField", "_id");
        lookUpCondition.put("foreignField", "classId");
        lookUpCondition.put("as", "studentInfo");
        lookUpExp.put("$lookup", lookUpCondition);

        BasicDBObject projectExp = new BasicDBObject();
        //Filter condition for child collections
        BasicDBObject filterCondition = new BasicDBObject();
        filterCondition.put("input", "$studentInfo");
        filterCondition.put("as", "item");
        //Vague condition  for business logic
        filterCondition.put("cond", new BasicDBObject("$eq", new Object[]{"$$item.sex", "male"}));

        BasicDBObject filterObj = new BasicDBObject("$filter", filterCondition);
        projectExp.put("$project", new BasicDBObject("studentInfo", filterObj));

        List<Bson> expressionList = Lists.list(lookUpExp, projectExp);
        AggregateIterable<Document> aggregateList = mongoTemplate
                .getCollection("class").aggregate(expressionList);

        for (Document next : aggregateList) {
            System.out.println(next.toString());
        }
    }

    @Test
    public void testDBStudent() {

    }
}
