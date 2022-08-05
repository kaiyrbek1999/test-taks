package com.example.test.service.impl;

import com.example.test.document.TransactionRecordModel;

import java.util.List;

public interface TransactionRecordSearchService {

    List<TransactionRecordModel> getListSearchByTerm(String term, Integer pageNum, Integer pageSize);
}
