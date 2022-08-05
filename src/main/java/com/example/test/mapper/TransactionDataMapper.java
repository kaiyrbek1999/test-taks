package com.example.test.mapper;

import com.example.test.dto.TransactionDataDto;
import com.example.test.model.TransactionRecordData;

public class TransactionDataMapper {

    public static TransactionDataDto toTransactionRecordDto(TransactionRecordData transactionRecordData) {
        TransactionDataDto transactionDataDto = new TransactionDataDto();
        transactionDataDto.setId(transactionRecordData.getId());
        transactionDataDto.setKey(transactionRecordData.getKey());
        transactionDataDto.setValue(transactionRecordData.getValue());
        return transactionDataDto;
    }

    public static TransactionRecordData toTransactionRecord(TransactionDataDto transactionDataDto) {
        TransactionRecordData transactionRecordData = new TransactionRecordData();
        transactionRecordData.setId(transactionDataDto.getId());
        transactionRecordData.setKey(transactionDataDto.getKey());
        transactionRecordData.setValue(transactionDataDto.getValue());
        return transactionRecordData;
    }

    public static com.example.test.document.TransactionRecordDataModel toTransactionRecordDataModel(TransactionRecordData transactionRecord) {
        com.example.test.document.TransactionRecordDataModel transactionRecordDataModel = new com.example.test.document.TransactionRecordDataModel();
        transactionRecordDataModel.setKey(transactionRecord.getKey());
        transactionRecordDataModel.setValue(transactionRecord.getValue());
        return transactionRecordDataModel;
    }
}