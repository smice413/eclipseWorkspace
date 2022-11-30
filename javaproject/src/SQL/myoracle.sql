
select*from tab; --테이블 목록//실행 단축 키: alt+x
select*from customer;
select*from seq;--시퀀스 목록

delete from ;--customer에 있는 내용 삭제
drop sequence customer_no_seq;--시퀀스 초기화


--desc customer; 이것은 이클립스에서 명령이 적용안됨. cmd에서는 된다. 이것 대신에 select * from customer;로 확인해라.
--예1.
--primaty key(기본키): 반드시 중복되지 않는 값을 저장 해야된다는 의미
create table customer( 
				no number(4)  primary key,  

		       name varchar2(20),

		       email varchar2(20),

		       tel varchar2(20)  );
		       
--주소와 날짜, 시퀀스를 추가 시켰다.		       
alter table customer add(address varchar2(50));

alter table customer add(reg_date timestamp);

create sequence customer_no_seq--번호 값을 1부터 1씩 증가 시키는 역할을 함.
start with 1
increment by 1
nocache; --no가 1번부 터 계속 증가가 되게 함. 이 명령어를 쓰지 않으면 no가 1부터 시작안하고 누적된 번호에서 시작한다. 즉, 캐쉬가 쌓였기 때문
--따라서 drop해서 테이블을 초기화 한후 처음부터 명령어를 같이 작성해야 정상적인 명령으로 실행된다.


--예4.

select*from member;--정보등록

create table member(name varchar2(20),
		     gender varchar2(10),
		     jumin1 varchar2(6),
             jumin2 varchar2(7),
		     address varchar2(100),
		     buseo  varchar2(20),
             sports varchar2(20),
             music varchar2(20),
             movie varchar2(20),
		     computer varchar2(20),
		     intro varchar2(1000)
		   );

		   
--예5.

select * from mem02;--회원가입과 회원정보수정 탈퇴		   

create  table  mem02(id  varchar2(20)  primary key,
		  passwd  varchar2(20),
		  name  varchar2(20),
		  reg_date  date);	   
		   
		  
		  
		  
--게시판

select *from tab;		  
select *from board;		  
		  
create table board(
	no number primary key,
	writer varchar2(20) not null, --not null은 반드시 값을 입력해야한다는 의미
    passwd varchar2(20) not null,
	subject varchar2(100) not null,--게시판 제목
	content varchar2(1000) not null,--게시판 내용
	reg_date timestamp );

	
	
create sequence board_seq
start with 1
increment by 1;

insert into board(writer,passwd,subject,content,reg_date)
	values('신성호','1234','게시판제목','게시판내용',sysdate);


--글작성 : Insertboard.java
--글목록 : Selectboard.java
--글수정 : Updateboard.java
--글삭제 : Deleteboard.java
		  
