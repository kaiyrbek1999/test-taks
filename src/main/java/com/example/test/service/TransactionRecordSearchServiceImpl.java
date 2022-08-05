package com.example.test.service;

import com.example.test.document.TransactionRecordModel;
import com.example.test.model.TransactionRecord;
import com.example.test.elastic.repo.TransactionRecordSearchRepository;
import com.example.test.repo.TransactionRecordRepository;
import com.example.test.service.impl.TransactionRecordSearchService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TransactionRecordSearchServiceImpl implements TransactionRecordSearchService {

    private final TransactionRecordSearchRepository transactionRecordSearchRepository;

    @Override
    public List<TransactionRecordModel> getListSearchByTerm(String term, Integer pageNo, Integer pageSize) {
        log.info("Get list transaction records by search term : term{}", term);
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return transactionRecordSearchRepository.getTransactionRecordsByTerm(term, pageable);
    }
}