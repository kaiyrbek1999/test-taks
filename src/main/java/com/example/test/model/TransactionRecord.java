package com.example.test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "transaction_record")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionRecord extends DateAudit{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Timestamp timestamp;

    private String type;

    private String actor;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name = "transaction_record_id")
    private List<TransactionRecordData> transactionRecordDataList;
}
