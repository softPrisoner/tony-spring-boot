//package com.rainbow.tony.activiti.drools;
//
//import org.junit.Test;
//import org.kie.api.KieBase;
//import org.kie.api.io.ResourceType;
//import org.kie.api.runtime.KieSession;
//import org.kie.internal.builder.KnowledgeBuilder;
//import org.kie.internal.builder.KnowledgeBuilderFactory;
//import org.kie.internal.io.ResourceFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * @author tony
// * @describe DroolsTest
// * @date 2019-08-28
// */
//public class DroolsBaseService {
//    private static final Logger LOGGER = LoggerFactory.getLogger(DroolsBaseService.class);
//
//    @Test
//    public void testMyRule() {
//        String str = "";
//        str += "package com.rainbow \r\n";
//        str += "import com.rainbow.tony.activiti.model.TransactionModel\r\n";
//        str += "import java.util.Date \r\n";
//        str += "global java.lang.Integer count \r\n";
//        str += "dialect  \"java\" \r\n";
//        str += "rule \"ruleNo1\" \r\n";
//        str += " salience 100 \r\n";
//        str += " lock-on-active \r\n";
//        str += "no-loop \r\n";
//        str += "when \r\n";
//        str += "$currentTime:Date();\r\n";
//        str += "$w:TransactionModel($createTime:createTime, $balance:balance); \r\n";
//        str += "then \r\n";
//        str += "if ($createTime.getTime() < ($currentTime.getTime() - 1000 * 60 * 60 * 24 * 7)) {\r\n";
//        str += "count++; \r\n";
//        str += "System.out.println(\"时间已经过期,不进行任何处理\"); \r\n";
//        str += " } else { \r\n";
//        str += " if (count == 5) {\r\n";
//        str += "System.out.println(\"异常已经超过5个了请及时处理\"); \r\n";
//        str += " }";
//        str += "System.out.println(\"记录交易记录进入数据库\");\r\n";
//        str += "} \n";
//        str += " end";
//        System.out.println(str);
//        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
//        kbuilder.add(ResourceFactory.newFileResource("classpath:drools/transaction.drl"), ResourceType.DRL);
////        kbuilder.add(ResourceFactory.newByteArrayResource(str.getBytes()), ResourceType.DRL);
//        if (kbuilder.hasErrors()) {
//            LOGGER.error("some error" + kbuilder.getErrors().toString());
//        }
//        KieBase kieBase = kbuilder.newKieBase();
//        KieSession session = kieBase.newKieSession();
//        session.fireAllRules();
//    }
//}
