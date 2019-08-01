package com.tony.batch.config;

import com.tony.batch.domain.Person;
import com.tony.batch.processor.PersonItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

/**
 * @author tony
 * @describe HelloWordJobConfig
 * @date 2019-07-30
 */
@Configuration
public class HelloWordJobConfig {
    @Bean
    public Job helloWorldJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {

        return jobBuilderFactory
                .get("helloWorldJob")
                //启动job
                .start(helloWordStep(stepBuilderFactory))
                .build();
    }

    @Bean
    public Step helloWordStep(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory
                //获取批量数据组成一个chuck
                .get("helloWorldStep").<Person, String>chunk(10)
                //通过streamReader读取批量数据
                .reader(reader())
                //中间过程,进行数据处理
                .processor(processor())
                //将数据写入到目标地址或文件
                .writer(writer()).build();
    }

    private FlatFileItemWriter<? super String> writer() {
        return new FlatFileItemWriterBuilder<String>()
                //flatFileItemWriterBuilder
                .name("greetingItemWriter")
                //输出目标资源
                .resource(new FileSystemResource("output/batch-result.txt"))
                //聚合行
                .lineAggregator(new PassThroughLineAggregator<>()).build();
    }

    public FlatFileItemReader<? extends Person> reader() {
        //可以看出来这里使用的是文件的对象流
        return new FlatFileItemReaderBuilder<Person>()
                //命名
                .name("personItemReader")
                //设置资源文件csv
                .resource(new ClassPathResource("persons.csv"))
                //使用分隔符,分割数据,默认是逗号,可以自己配置
                .delimited().delimiter(",")
                //命名映射
                .names(new String[]{"firstName", "lastName"})
                //生成目标类型
                .targetType(Person.class).build();
    }

    private PersonItemProcessor processor() {
        return new PersonItemProcessor();
    }

}
