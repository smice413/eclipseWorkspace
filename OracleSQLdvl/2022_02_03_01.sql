--22.02.03.01 (목)

-- 시퀀스(sequence)
-- : 테이블에 숫자를 자동으로 증가시켜서 처리해주는 역할

-- 시퀀스 생성
create sequence dept_deptno_seq 
start with 10               --시작할 번호값
increment by 10;             --증가치


-- 시퀀스 목록
select * from seq;
select * from user_sequences;

--currval : 시퀀스 현재값을 반환
--nextval : 시퀀스 다음값을 반환

select dept_deptno_seq.nextval from dual; --10, 20, 30 ..
select dept_deptno_seq.currval from dual; --10, 20 현재 값

--예1. 시퀀스를 테이블의 기본키에 적용하기
drop table emp01 purge;
create table emp01(
    empno number(4) primary key,
    ename varchar2(10),
    hiredate date);
    
create sequence emp01_empno_seq; --1부터 1씩 증가되는 시퀀스 생성

select * from tab; --테이블 목록 확인
select * from seq; --시퀀스 목록 확인

--데이터 입력
insert into emp01 values(emp01_empno_seq.nextval, '홍길동', sysdate);

select * from emp01;

--예2.
--테이블 생성
create table dept_example(
    deptno number(4) primary key,
    dname varchar2(15),
    loc varchar2(15) );
    
-- 시퀀스 생성
create sequence dept_example_seq
start with 10
increment by 10;

-- 데이터 입력
insert into dept_example values(dept_example_seq.nextval, '인사과', '서울');
insert into dept_example values(dept_example_seq.nextval, '경리과', '서울');
insert into dept_example values(dept_example_seq.nextval, '총무과', '대전');
insert into dept_example values(dept_example_seq.nextval, '기술팀', '인천');

select * from dept_example;

-- 시퀀스 삭제
-- drop sequence 시퀀스 이름;
drop sequence dept_example_seq;

select * from seq;

-- 시퀀스 수정
drop sequence dept_deptno_seq;

create sequence dept_deptno_seq
start with 10       --시작값
increment by 10     --증가값
maxvalue 30;        --최대값

-- 시퀀스 목록
select * from seq;
select * from user_sequences;

-- 시퀀스 다음값 구해오기
select dept_deptno_seq.nextval from dual;     --10 구해옴
select dept_deptno_seq.nextval from dual;     --20 구해옴
select dept_deptno_seq.nextval from dual;     --30 구해옴
select dept_deptno_seq.nextval from dual;     --오류: 최대값이 30인데 nocycle이기 때문에 반복없이 오류발생

-- 시퀀스 수정 : maxvalue: 30 --> maxvalue: 1000000
alter sequence dept_deptno_seq maxvalue 1000000;

-- 시퀀스 다음값 구해오기
select dept_deptno_seq.nextval from dual;     --40 구해옴
select dept_deptno_seq.nextval from dual;     --50 구해옴

------------------------------------------------------------------------------------
-- 인덱스(index) : 빠른 검색을 하기 위해서 사용되는 객체

-- 인덱스 목록 확인
select * from user_indexes;

-- 기본키(primary key)로 설정된 컬럼은 자동으로 고유 인덱스로 설정된다.

--[실습]
--인덱스 실습(인덱스 사용 유.무에 따른 검색 속도 비교)
--1. 테이블 생성
drop table emp01 purge;

--복사본 테이블 생성 : 제약 조건은 복사되지 않는다.
create table emp01 as select * from emp;

--2. emp01 테이블에 데이터 입력 : 1400만 데이터
insert into emp01 select * from emp01; 

--3. 검색용 데이터 입력
insert into emp01(empno, ename) values(1111, 'shin');

--4. 시간 측정 타이머 온
set timing on

--5. 검색용 데이터로 검색시간을 측정 : 인덱스가 설정되지 않은 경우
select * from emp01 where ename = 'shin';  --3.114초 소요

--6. 인덱스 생성 : ename 컬럼에 인덱스가 적용됨
create index idx_emp01_ename on emp01(ename);

--인덱스 목록
select * from user_indexes;

--7. 검색용 데이터로 검색시간을 측정 : 인덱스가 설정된 경우
select * from emp01 where ename = 'shin';  --0.012초 소요

-- 인덱스 삭제
--형식 : drop index index_name;
drop index idx_emp01_ename;


-- 인덱스 종류
-- 고유 인덱스 : 중복된 데이터가 없는 컬럼에 적용할 수 있는 인덱스
-- 비고유 인덱스 : 중복된 데이터가 있는 컬럼에 적용할 수 있는 인덱스

--1. 테이블 생성
drop table dept01 purge;
create table dept01 as select * from dept where 1=0; --테이블 구조만 복사

--2. 데이터 입력 : loc컬럼에 중복 데이터를 입력
insert into dept01 values(10, '인사과', '서울');
insert into dept01 values(20, '총무과', '대전');
insert into dept01 values(30, '교육팀', '대전');
select * from dept01;

--3. 고유 인덱스 생성 : deptno 컬럼에 고유 인덱스 적용
create unique index idx_dept01_deptno on dept01(deptno);

select * from user_indexes;

--고유 인덱스로 설정된 deptno 컬럼에 중복데이터를 입력 해보자?
--deptno 컬럼은 고유 인덱스가 설정된 이후에 중복된 데이터를 입력할 수 없다.
insert into dept01 values(30, '교육팀', '대전'); --오류

--4. 인덱스 목록 확인
select * from user_indexes;

--5. 비고유 인덱스 : loc 컬럼에 고유, 비고유 인덱스를 적용 해보자
create unique index idx_dept01_loc on dept01(loc); --오류: loc컬럼에 중복데이터가 있기 때문

create index idx_dept01_loc on dept01(loc); --비고유 인덱스 생성

--6. 결합 인덱스 : 2개 이상의 컬럼으로 만들어진 인덱스
create index idx_dept01_com on dept01(deptno, dname);

--7. 함수 기반 인덱스 : 수식이나 함수를 적용하여 만든 인덱스
create index idx_emp01_annsal on emp(sal*12);