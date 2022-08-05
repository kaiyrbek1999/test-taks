package com.example.test;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableElasticsearchRepositories(basePackages = "com.example.test.elastic.repo")
@EnableJpaRepositories(basePackages = "com.example.test.repo")
@EnableScheduling
@EnableJpaAuditing
@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Bean
    public boolean createTestIndex(RestHighLevelClient restHighLevelClient) throws Exception {
        try {
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("transaction_record");
            restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT); // 1
        } catch (Exception ignored) {
        }

        CreateIndexRequest createIndexRequest = new CreateIndexRequest("transaction_record");
        restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT); // 2
        return true;
    }
}
