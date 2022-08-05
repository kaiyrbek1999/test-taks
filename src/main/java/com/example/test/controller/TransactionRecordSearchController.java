package com.example.test.controller;

import com.example.test.document.TransactionRecordModel;
import com.example.test.service.impl.TransactionRecordSearchService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.test.constant.BaseConstant.*;

@RestController
@AllArgsConstructor
@RequestMapping(TRANSACTION_RECORD_SEARCH_API)
public class TransactionRecordSearchController {

    private final TransactionRecordSearchService transactionRecordSearchService;

    @GetMapping()
    @ApiOperation("Search by term")
    public List<TransactionRecordModel> getTransactionListByTerm(@RequestParam String term,
                                                                 @RequestParam(defaultValue = "0") Integer pageNum,
                                                                 @RequestParam(defaultValue = "20") Integer pageSize) {
        return transactionRecordSearchService.getListSearchByTerm(term, pageNum, pageSize);
    }
}