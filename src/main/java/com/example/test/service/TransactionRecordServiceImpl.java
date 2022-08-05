package com.example.test.service;

import com.example.test.dto.TransactionRecordDto;
import com.example.test.mapper.TransactionRecordMapper;
import com.example.test.model.TransactionRecord;
import com.example.test.repo.TransactionRecordRepository;
import com.example.test.service.impl.TransactionRecordService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TransactionRecordServiceImpl implements TransactionRecordService {

    private final TransactionRecordRepository transactionRecordRepository;

    @Override
    public void createTransactionRecord(TransactionRecordDto transactionRecordDto) {
        log.info("Create transaction record ");
        transactionRecordRepository.save(TransactionRecordMapper.toTransactionRecord(transactionRecordDto));
    }

    @Override
    public TransactionRecordDto getTransactionRecord(Integer id) {
        log.info("Get transaction record by id: id={}", id);
        return TransactionRecordMapper.toTransactionRecordDto(transactionRecordRepository.findById(id).orElseThrow());
    }

    @Override
    public List<TransactionRecordDto> getTransactionRecordList(Integer pageNo, Integer pageSize) {
        log.info("Get transaction record list");
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return TransactionRecordMapper.transactionRecordDtosList(transactionRecordRepository.findAll(pageable).toList());
    }

    @Override
    public void updateTransactionRecord(TransactionRecordDto transactionRecordDto) {
        log.info("Update transaction record");
        transactionRecordRepository.save(TransactionRecordMapper.toTransactionRecord(transactionRecordDto));
    }

    @Override
    public void deleteTransactionRecord(Integer id) {
        log.info("Delete transaction record by id: id={}", id);
        TransactionRecord transactionRecord = transactionRecordRepository.findById(id).orElseThrow();
        transactionRecordRepository.delete(transactionRecord);
    }
}
