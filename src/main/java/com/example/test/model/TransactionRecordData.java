package com.example.test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "transaction_record_data")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionRecordData extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String value;
    private String key;
}
