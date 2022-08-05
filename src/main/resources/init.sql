create table transaction_record
(
    id        int          not null
        primary key,
    timestamp timestamp    null,
    type      varchar(255) null,
    actor     varchar(255) null,
    created_at datetime     not null,
    updated_at datetime     null
);

create table transaction_record_data
(
    id                    int           not null
        primary key,
    `key`                 varchar(255)  null,
    value                 varchar(1000) null,
    transaction_record_id int           null,
    created_at             datetime      not null,
    updated_at             datetime      null,
    constraint transaction_record_data_transaction_record_id_fk
        foreign key (transaction_record_id) references transaction_record (id)
);
