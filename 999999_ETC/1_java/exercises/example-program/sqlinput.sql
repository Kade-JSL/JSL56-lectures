create table liteaccount (
    accounttype varchar2(6) default '일반',
    accountnum number(5) not null primary key,
    ownername varchar2(30) not null,
    password number(2) not null,
    balance number(15)
);

insert into liteaccount (accountnum, ownername, password, balance) values (11111, '케이드', 11, 100000);