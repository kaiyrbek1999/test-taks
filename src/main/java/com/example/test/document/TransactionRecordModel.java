package com.example.test.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Document(indexName = "transaction_record")
@Getter
@Setter
public class TransactionRecordModel {

    @Id
    private Integer id;

    @Field(type = FieldType.Date)
    private Date timestamp;

    private String type;

    private String actor;

    @Field( type = FieldType.Nested)
    private List<TransactionRecordDataModel> recordData;
}