package com.example.test.synchronizer.impl;

import com.example.test.document.TransactionRecordModel;
import com.example.test.elastic.repo.TransactionRecordSearchRepository;
import com.example.test.mapper.TransactionRecordMapper;
import com.example.test.model.TransactionRecord;
import com.example.test.repo.TransactionRecordRepository;
import com.example.test.synchronizer.ElasticSynchronizer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.test.constant.BaseConstant.LAST_THREE_MINUTES;

@Slf4j
@Service
@AllArgsConstructor
public class ElasticSynchronizerImpl implements ElasticSynchronizer {

    private final TransactionRecordRepository transactionRecordRepository;

    private final TransactionRecordSearchRepository transactionRecordSearchRepository;

    @Override
    @Scheduled(cron = "0 */3 * * * *")
    public void syncTransactionRecords() {
        log.info("Synchronize elasticsearch transaction records");
        List<TransactionRecord> transactionRecords = transactionRecordRepository.findRecordsByCreatedOrUpdatedTime(Timestamp.valueOf(LocalDateTime.now().minusMinutes(LAST_THREE_MINUTES)), Timestamp.valueOf(LocalDateTime.now()));
        List<TransactionRecordModel> transactionRecordModels = TransactionRecordMapper.toTransactionRecordModels(transactionRecords);
        transactionRecordSearchRepository.saveAll(transactionRecordModels);
    }
}
