package com.example.test.mapper;

import com.example.test.document.TransactionRecordDataModel;
import com.example.test.dto.TransactionDataDto;
import com.example.test.dto.TransactionRecordDto;
import com.example.test.model.TransactionRecordData;
import com.example.test.model.TransactionRecord;

import java.util.ArrayList;
import java.util.List;

public class TransactionRecordMapper {

    public static TransactionRecordDto toTransactionRecordDto(TransactionRecord transactionRecord) {
        TransactionRecordDto transactionRecordDto = new TransactionRecordDto();
        transactionRecordDto.setId(transactionRecord.getId());
        transactionRecordDto.setActor(transactionRecord.getActor());
        transactionRecordDto.setType(transactionRecord.getType());
        transactionRecordDto.setTimestamp(transactionRecord.getTimestamp());
        transactionRecordDto.setTransactionData(new ArrayList<>());
        List<TransactionDataDto> dataList = transactionRecordDto.getTransactionData();
        for (TransactionRecordData transactionRecordData : transactionRecord.getTransactionRecordDataList()) {
            dataList.add(TransactionDataMapper.toTransactionRecordDto(transactionRecordData));
        }
        return transactionRecordDto;
    }

    public static TransactionRecord toTransactionRecord(TransactionRecordDto transactionRecordDto) {
        TransactionRecord transactionRecord = new TransactionRecord();
        transactionRecord.setId(transactionRecordDto.getId());
        transactionRecord.setActor(transactionRecordDto.getActor());
        transactionRecord.setType(transactionRecordDto.getType());
        transactionRecord.setTimestamp(transactionRecordDto.getTimestamp());
        transactionRecord.setTransactionRecordDataList(new ArrayList<>());
        List<TransactionRecordData> dataList = transactionRecord.getTransactionRecordDataList();
        for (TransactionDataDto transactionData : transactionRecordDto.getTransactionData()) {
            dataList.add(TransactionDataMapper.toTransactionRecord(transactionData));
        }
        return transactionRecord;
    }

    public static List<TransactionRecordDto> transactionRecordDtosList(List<TransactionRecord> transactionRecords) {
        List<TransactionRecordDto> result = new ArrayList<>();
        for (TransactionRecord transactionRecord : transactionRecords) {
            result.add(toTransactionRecordDto(transactionRecord));
        }
        return result;
    }


    public static com.example.test.document.TransactionRecordModel toTransactionRecordModel(TransactionRecord transactionRecord) {
        com.example.test.document.TransactionRecordModel transactionRecordModel = new com.example.test.document.TransactionRecordModel();
        transactionRecordModel.setId(transactionRecord.getId());
        transactionRecordModel.setType(transactionRecord.getType());
        transactionRecordModel.setActor(transactionRecord.getActor());
        transactionRecordModel.setTimestamp(transactionRecord.getTimestamp());
        transactionRecordModel.setRecordData(new ArrayList<>());
        List<TransactionRecordDataModel> transactionRecordDataModels = transactionRecordModel.getRecordData();
        for (TransactionRecordData transactionRecordData : transactionRecord.getTransactionRecordDataList()) {
            transactionRecordDataModels.add(TransactionDataMapper.toTransactionRecordDataModel(transactionRecordData));
        }
        return transactionRecordModel;
    }

    public static List<com.example.test.document.TransactionRecordModel> toTransactionRecordModels(List<TransactionRecord> transactionRecords) {
        List<com.example.test.document.TransactionRecordModel> result = new ArrayList<>();
        for (TransactionRecord transactionRecord : transactionRecords) {
            result.add(toTransactionRecordModel(transactionRecord));
        }
        return result;
    }
}