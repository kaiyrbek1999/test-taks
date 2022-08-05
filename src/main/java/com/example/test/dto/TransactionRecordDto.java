package com.example.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class TransactionRecordDto {

    private Integer id;

    private Timestamp timestamp;

    private String type;

    private String actor;

    private List<TransactionDataDto> transactionData;
}