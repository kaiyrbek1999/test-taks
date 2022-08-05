package com.example.test.service.impl;

import com.example.test.dto.TransactionRecordDto;

import java.util.List;

public interface TransactionRecordService {

    void createTransactionRecord(TransactionRecordDto transactionRecordDto);

    TransactionRecordDto getTransactionRecord(Integer id);

    List<TransactionRecordDto> getTransactionRecordList(Integer pageNo, Integer pageSize);

    void updateTransactionRecord(TransactionRecordDto transactionRecordDto);

    void deleteTransactionRecord(Integer id);
}
