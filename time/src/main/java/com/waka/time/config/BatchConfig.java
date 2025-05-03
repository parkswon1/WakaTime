package com.waka.time.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.JobExplorerFactoryBean;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * <h1></h1>
 * <ul>
 *  <li>
 *  <li>
 * </ul
 *
 * @author 박석원
 * @updated 2025-05-03
 */
@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchConfig {
    private final DataSource dataSource;
    private final PlatformTransactionManager transactionManager;

    /**
     * <h2>JobRepository 설정</h2>
     * Spring Batch 실행 이력을 저장하는 저장소를 구성하며,
     * 테이블 prefix는 {@code SUMMARY_}로 지정됨.
     */
    @Bean
    public JobRepository jobRepository() throws Exception {
        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTransactionManager(transactionManager);
        factory.setTablePrefix("SUMMARY_");
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    /**
     * <h2>JobLauncher 설정</h2>
     * Spring Batch Job을 실행하기 위한 런처이며, 비동기 실행을 위한
     * {@code SimpleAsyncTaskExecutor}를 사용함.
     */
    @Bean
    public JobLauncher jobLauncher(JobRepository jobRepository) throws Exception {
        TaskExecutorJobLauncher jobLauncher = new TaskExecutorJobLauncher();
        jobLauncher.setJobRepository(jobRepository);
        jobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor());
        jobLauncher.afterPropertiesSet();
        return jobLauncher;
    }

    /**
     * <h2>JobExplorer 설정</h2>
     * 실행된 Job 이력을 조회하기 위한 설정이며,
     * 테이블 prefix는 {@code SUMMARY_}로 지정됨.
     */
    @Bean
    public JobExplorer jobExplorer() throws Exception {
        JobExplorerFactoryBean factory = new JobExplorerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTransactionManager(transactionManager);
        factory.setTablePrefix("SUMMARY_");
        factory.afterPropertiesSet();
        return factory.getObject();
    }
}
