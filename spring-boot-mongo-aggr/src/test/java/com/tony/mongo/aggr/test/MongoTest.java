package com.tony.mongo.aggr.test;

import com.alibaba.fastjson.JSON;
import com.mongodb.BasicDBObject;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.tony.mongo.aggr.MongoApplication;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.assertj.core.util.Lists;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoApplication.class)
public class MongoTest {
    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void createTestData() {
//        //Init grade info object
//        Grade grade1 = new Grade();
//        grade1.setGradeName("math");
//        grade1.setId(1);
//        grade1.setMark(45);
//        mongoTemplate.save(grade1);
//
//        Grade grade2 = new Grade();
//        grade2.setGradeName("english");
//        grade2.setId(2);
//        grade2.setMark(80);
//        mongoTemplate.save(grade2);
//
//        List<Grade> gradeList = new ArrayList<>();
//        gradeList.add(grade1);
//        gradeList.add(grade2);
//        Student student1 = new Student();
//        student1.setId(1);
//        student1.setName("tony");
//        student1.setSex("male");
//        mongoTemplate.save(student1);
//        //Init student info
//        Student student2 = new Student();
//        student2.setId(2);
//        student2.setName("white");
//        student2.setSex("female");
//        mongoTemplate.save(student2);
//
//        List<Student> studentList = new ArrayList<>();
//        studentList.add(student1);
//        studentList.add(student2);
//        //Init class info
//        ClassInfo classInfo1 = new ClassInfo();
//        classInfo1.setClassName("Class One");
//        classInfo1.setId(1);
//        classInfo1.setStudentList(studentList);
//        mongoTemplate.save(classInfo1);


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

    @Test
    public void aggregationMainCdr() {
        int tenantId = 2092;
        long startTime = 1595352343000L;
        long endTime = 1595438743000L;
        //LookupOperation
        LookupOperation lookupOperation = lookup("robot_call_info_t", "mainCdrId",
                "main_cdr_id", "callInfo");
        //UnwindOperation
        UnwindOperation unwindOperation = unwind("$callInfo");
        //SortOperation
        SortOperation sortOperation = sort(Sort.Direction.DESC, "create_time");
        //ProjectionOperation
        ProjectionOperation projectionOperation = project(
                "tenant_id",
                "customerName",
                "caller",
                "called",
                "starting_time",
                "connect_time",
                "call_duration",
                "hang_up_time",
                "ring_duration",
                "call_result",
                "continue2live");

        LimitOperation limitOperation = limit(1000);

        SkipOperation skipOperation = skip(0L);

        Criteria criteria = new Criteria();
        criteria.and("tenant_id").is(tenantId)
                .and("create_time").gt(startTime).gt(endTime)
                .and("call_result").ne("notCallout").ne("concurrentFailed");

        MatchOperation matchOperation = match(criteria);

        Aggregation aggregation = Aggregation.newAggregation(
                lookupOperation,
                unwindOperation,
                matchOperation,
                sortOperation,
                skipOperation,
                limitOperation,
                projectionOperation);

        List<Map> results = mongoTemplate.aggregate(aggregation, "main_cdr_t", Map.class).getMappedResults();

        System.out.println("【MongoResult】:" + JSON.toJSONString(results));
    }

    @Test
    public void export2Excel() {
        try {
            WritableWorkbook wwb = null;
            // 创建可写入的Excel工作簿
            String fileName = "D://main_cdr.xls";
            File file = new File(fileName);
            if (!file.exists()) {
                boolean newFile = file.createNewFile();
                if (!newFile) {
                    System.out.println("创建文件失败");
                }
            }
            wwb = Workbook.createWorkbook(file);
            WritableSheet sheet = wwb.createSheet("通话记录", 0);
            IntStream range = IntStream.range(0, 9);
            range.parallel().forEach(i -> {
                sheet.setColumnView(i, 20);
            });

            Label labelId = new Label(0, 0, "编号(_id)");//表示第
            Label labelCaller = new Label(1, 0, "主叫号码(caller)");
            Label labelCalled = new Label(2, 0, "被叫号码(called)");
            Label labelCustomerName = new Label(3, 0, "客户姓名(customerName)");
            Label labelCallResult = new Label(4, 0, "呼叫结果(call_result)");
            Label labelCallDuration = new Label(5, 0, "通话持续时间(call_duration)");
            Label labelStartingTime = new Label(6, 0, "通话开始时间(starting_time)");
            Label labelRingDuration = new Label(7, 0, "振铃持续时长(ring_duration)");
            Label labelConnectTime = new Label(8, 0, "通话持续时长(connect_time)");
            Label labelHangupTime = new Label(9, 0, "通话挂断时间(password)");


            sheet.addCell(labelId);
            sheet.addCell(labelCaller);
            sheet.addCell(labelCalled);
            sheet.addCell(labelCustomerName);
            sheet.addCell(labelCallResult);
            sheet.addCell(labelCallDuration);
            sheet.addCell(labelStartingTime);
            sheet.addCell(labelRingDuration);
            sheet.addCell(labelConnectTime);
            sheet.addCell(labelHangupTime);

//            for (int i = 0; i < list.size(); i++) {
//                Label labelId_i = new Label(0, i + 1, list.get(i).getUserId() + "");
//                Label labelName_i = new Label(1, i + 1, list.get(i).getUserName());
//                Label labelSex_i = new Label(2, i + 1, list.get(i).getEmail());
//                Label labelNum_i = new Label(3, i + 1, list.get(i).getMobile() + "");
//                Label labelPassword_i = new Label(4, i + 1, list.get(i).getPassword() + "");
//                ws.addCell(labelId_i);
//                ws.addCell(labelName_i);
//                ws.addCell(labelSex_i);
//                ws.addCell(labelNum_i);
//                ws.addCell(labelPassword_i);
//            }
            //写进文档
            wwb.write();
            // 关闭Excel工作簿对象
            wwb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
