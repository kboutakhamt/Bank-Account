-- script de creation du schema de base de donnee metier bank version 1.0
drop schema if exists bank cascade;
create schema bank;
-- creation des index
create sequence bank.account_id_seq increment 1 start 1 minvalue 1 maxvalue 99999999999 cache 1;
alter sequence bank.account_id_seq owner to postgres;
create sequence bank.operation_id_seq increment 1 start 1 minvalue 1 maxvalue 99999999999 cache 1;
alter sequence bank.operation_id_seq owner to postgres;
create sequence bank.account_seq increment 1 start 1 minvalue 1 maxvalue 99999999999 cache 1;
alter sequence bank.account_seq owner to postgres;
create sequence bank.operation_seq increment 1 start 1 minvalue 1 maxvalue 99999999999 cache 1;
alter sequence bank.operation_seq owner to postgres;
-- creation des tables
create table bank.account
(
   account_id bigint not null default nextval ('bank.account_id_seq'::regclass) primary key,
   username character varying (40) not null,
   balance bigint,
   creation_date timestamp
)
with
(
   oids = false
)
tablespace pg_default;
comment on table bank.account is 'Informations sur le compte';
create table bank.operation
(
   operation_id bigint not null default nextval ('bank.operation_id_seq'::regclass) primary key,
   account_id bigint not null,
   operation_type character varying (40) not null,
   amount bigint not null,
   operation_date timestamp,
   constraint fk_account_id foreign key (account_id) references bank.account (account_id) on update cascade on delete restrict
)
with
(
   oids = false
)
tablespace pg_default;
comment on table bank.operation is 'Journal des operations sur le compte';
commit;