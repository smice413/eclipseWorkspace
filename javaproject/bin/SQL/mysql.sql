show databases; --데이터베이스 목록확인
show tables; --테이블 목록

--예1.
--primaty key(기본키): 반드시 중복되지 않는 값을 저장 해야된다는 의미
--오라클의 숫자형 number와 달리 mysql은 숫자형을 int로 쓴다.
--mysql은 시퀀스 지원이 안되기 때문에 auto_increment를 쓴다.
--오라클 varchar2와 달리 varchar로 쓴다.
--주소와 날짜를 바로 넣었다. timestamp는 같은 함수를 쓴다.

show tables;
drop table customer; --table 삭제
delete from customer;--table 내용 데이터 삭제

select * from customer;

create table customer( 
			   no int (4)  auto_increment primary key, 

		       name varchar(20),

		       email varchar(20),

		       tel varchar(20), 
		       address varchar(50),
		       reg_date timestamp );
		       
		       
		       
		       
 --게시판

drop table board; --테이블 삭제(홍길동 게시판 연습 게시판 내용입니다 이 데이터 삭제)
show tables;		       
		       
select *from board;		  
		  
create table board(
	no int auto_increment primary key, --1씩 올라간다.
	writer varchar(20) not null, --not null은 반드시 값을 입력해야한다는 의미
    passwd varchar(20) not null,
	subject varchar(100) not null, --게시판 제목
	content varchar(1000) not null, --게시판 내용
	reg_date timestamp );
		       
	
insert into board(writer,passwd,subject,content,reg_date)
	values('신성호','1234','게시판제목','게시판내용',sysdate());
	
	
--1. 전체 데이터를 검색
select * from board;

--2. 전체 데이터를 내림차순 정렬(최근글 순으로 정렬)
--			오름차순(asc)				내림차순(desc)
--------------------------------------------------
--	숫자:    1,2,3..				10,9,8..
--	문자:    사전순 정렬(a,b,c..)		사전역순 정렬(z,y,x..)

select * from board order by no desc;

--3. 최근글 5개 검색
-- limit 추출할 인덱스번호(위에서 부터 0번임 즉, 14번이 0번임), 추출할 데이터 갯수
select * from board order by no desc limit 0, 5;

--4. 3~5번째 데이터 추출
select * from board order by no desc limit 2, 3;
		       
		       