create schema bank;
create table bank.account
(
   account_id bigint not null primary key,
   username character varying (40) not null,
   balance bigint,
   creation_date timestamp
);
create table bank.operation
(
   operation_id bigint not null primary key,
   account_id bigint not null,
   operation_type character varying (40) not null,
   amount bigint not null,
   operation_date timestamp,
   constraint fk_account_id foreign key (account_id) references bank.account (account_id)
);
commit;