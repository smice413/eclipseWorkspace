
create table membership (
 id varchar2(20) primary key,
 password varchar2(20),
 name varchar2(20),
 gender varchar2(2)
);

create sequence membership_seq
start with 1
increment by 1
nocache;

select * from membership;
