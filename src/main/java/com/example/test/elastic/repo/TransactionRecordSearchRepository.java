package com.example.test.elastic.repo;

import com.example.test.document.TransactionRecordModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface TransactionRecordSearchRepository extends ElasticsearchRepository<TransactionRecordModel, Integer> {

    @Query("{\"multi_match\" : {\n" +
            "      \"query\":    \"?0\", \n" +
            " \"fields\" : [ \"type\" ,\"actor\",\"key\",\"value\" ] \n" +
            "    }}")
    List<TransactionRecordModel> getTransactionRecordsByTerm(String term, Pageable pageable);
}