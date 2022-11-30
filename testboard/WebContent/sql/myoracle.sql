-- 검색 게시판
select * from tab;
select * from seq;
select * from testboard;

create table testboard(
	no number primary key,
	writer   varchar2(20)   not null,
	passwd  varchar2(20)   not null,
	subject  varchar2(100)  not null,
	content  varchar2(2000)  not null );	
	
create sequence  testboard_seq
        start with 1
        increment by 1	