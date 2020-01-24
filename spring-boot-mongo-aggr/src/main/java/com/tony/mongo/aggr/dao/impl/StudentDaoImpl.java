package com.tony.mongo.aggr.dao.impl;


import com.alibaba.fastjson.JSON;
import com.tony.mongo.aggr.dao.StudentDao;
import com.tony.mongo.aggr.domain.Student;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @describe MongoApplication
 * @date 2019/12/20
 */
@Component
public class StudentDaoImpl implements StudentDao {

    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * Insert
     *
     * @param student Student object
     */
    @Override
    public void saveStudent(Student student) {
        mongoTemplate.save(student);
    }

    /**
     * Delete
     *
     * @param id ID
     */
    @Override
    public void removeStudent(Integer id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, Student.class);
    }

    /**
     * Modify
     *
     * @param student Student info
     */
    @Override
    public void updateStudent(Student student) {
        Query query = new Query(Criteria.where("_id").is(student.getId()));
        Update update = new Update();
        update.set("name", student.getName());
        update.set("sex", student.getSex());
        // update.set("gradeId", student.getGradeId());
        mongoTemplate.updateFirst(query, update, Student.class);
    }

    /**
     * Query by ID
     *
     * @param id ID
     * @return Query result
     */
    @Override
    public Student findById(Integer id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Student.class);
    }

    /**
     * Find all
     *
     * @return Result of student List
     */
    @Override
    public List<Student> findAll() {
        return mongoTemplate.findAll(Student.class);
    }

    /**
     * Union table for querying
     *
     * @return Result object
     */
    @Override
    public Object findStudentAndGrade() {
        LookupOperation lookupOperation = LookupOperation.newLookup().
                from("grade").
                localField("gradeId").
                foreignField("_id").
                as("GradeAndStu");
        //带条件查询可以选择添加下面的条件
        //只查询有结果的学生
        //Criteria criteria=Criteria.where("studenAndgrade").not().size(0);
        //Criteria qqq=Criteria.where("name").regex("文");//只查询名字中带有文的
        //AggregationOperation match1= Aggregation.match(qqq);
        //AggregationOperation match = Aggregation.match(criteria);
        //Aggregation counts = Aggregation.newAggregation(match1,lookupOperation,match).;
        Aggregation aggregation = Aggregation.newAggregation(lookupOperation);
        List<Map> results = mongoTemplate.aggregate(aggregation, "student", Map.class).getMappedResults();
        //上面的student必须是查询的主表名
        System.out.println(JSON.toJSONString(results));
        return results;
    }
}
