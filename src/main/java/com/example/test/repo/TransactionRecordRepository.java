package com.example.test.repo;

import com.example.test.model.TransactionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface TransactionRecordRepository extends JpaRepository<TransactionRecord, Integer> {

    @Query(value = "select *\n" +
            "from transaction_record tr\n" +
            "         join transaction_record_data trd on tr.id = trd.transaction_record_id\n" +
            "where tr.created_at > UNIX_TIMESTAMP(:fromTime) AND\n" +
            "      UNIX_TIMESTAMP(:toTime) < tr.created_at\n" +
            "   or tr.updated_at > UNIX_TIMESTAMP(:fromTime) AND\n" +
            "      UNIX_TIMESTAMP(:toTime) < tr.updated_at\n" +
            "   or trd.created_at > UNIX_TIMESTAMP(:fromTime) AND\n" +
            "      UNIX_TIMESTAMP(:toTime) < trd.created_at\n" +
            "   or trd.updated_at > UNIX_TIMESTAMP(:fromTime) AND\n" +
            "      UNIX_TIMESTAMP(:toTime) < trd.updated_at", nativeQuery = true)
    List<TransactionRecord> findRecordsByCreatedOrUpdatedTime(@Param("fromTime") Timestamp fromTime,
                                                              @Param("toTime") Timestamp toTime);
}
