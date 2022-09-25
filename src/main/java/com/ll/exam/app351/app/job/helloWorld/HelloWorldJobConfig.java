package com.ll.exam.app351.app.job.helloWorld;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HelloWorldJobConfig {
    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job helloWorldJob(Step helloWorldStep1) {
        return jobBuilderFactory
                .get("helloWorldJob")
                .incrementer(new RunIdIncrementer())
                .start(helloWorldStep1)
                .build();
    }

    @Bean
    @JobScope
    public Step helloWorldStep1(Tasklet helloWorldStep1Tasklet) {
        return stepBuilderFactory
                .get("helloWorldStep1")
                .tasklet(helloWorldStep1Tasklet)
                .build();
    }

    @Bean
    @StepScope
    Tasklet helloWorldStep1Tasklet(
            @Value("#{jobParameters['name']}") String name,
            @Value("#{jobParameters['age']}") Long age
    ) {
        return (contribution, chunkContext) -> {
            System.out.printf("%s, %d\n", name, age);
            return RepeatStatus.FINISHED;
        };
    }
}
