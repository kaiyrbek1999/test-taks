package com.example.test.controller;

import com.example.test.dto.TransactionRecordDto;
import com.example.test.service.impl.TransactionRecordService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.test.constant.BaseConstant.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(TRANSACTION_RECORD_API)
public class TransactionRecordCrudController {

    private final TransactionRecordService transactionRecordService;

    @PostMapping()
    @ApiOperation("Create transaction record")
    public void createTransactionRecord(@RequestBody TransactionRecordDto transactionRecordDto) {
        transactionRecordService.createTransactionRecord(transactionRecordDto);
    }

    @GetMapping("{id}")
    @ApiOperation("Get transaction record by id")
    public TransactionRecordDto getTransactionRecord(@PathVariable Integer id) {
        return transactionRecordService.getTransactionRecord(id);
    }

    @GetMapping
    @ApiOperation("Get all transaction records")
    public List<TransactionRecordDto> getTransactionRecords(@RequestParam(defaultValue = "0") Integer pageNo,
                                                            @RequestParam(defaultValue = "20") Integer pageSize) {
        return transactionRecordService.getTransactionRecordList(pageNo, pageSize);
    }

    @PutMapping()
    @ApiOperation("Update transaction record")
    public void updateTransactionRecord(@RequestBody TransactionRecordDto transactionRecordDto) {
        transactionRecordService.updateTransactionRecord(transactionRecordDto);
    }

    @DeleteMapping("{id}")
    @ApiOperation("Delete transaction record by id")
    public void deleteTransactionRecord(@PathVariable Integer id) {
        transactionRecordService.deleteTransactionRecord(id);
    }
}