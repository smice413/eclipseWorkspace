--2022.01.26.02 (수)


-- DDL(Data Definition Language) : 데이터 정의어
-- create : 테이블 생성
-- alter : 테이블 구조를 변경
-- rename : 테이블 이름 변경
-- drop : 테이블 삭제
-- truncate : 테이터 삭제 (DDL SQL문) *Delete 데이터 삭제(DML SQL문)

-- 테이블 목록
select * from tab;
select * from user_tables;

--1. create
-- : 데이터베이스, 테이블 생성

--create table 테이블명( 컬럼명 데이터 타입,
--                      컬럼명 데이터 타입,
--                       .......); 

-- 오라클 데이터 타입
--1) 숫자 데이터
-- number(n) : 정수 n자리까지 저장
-- number(n1, n2) : n1 - 전체 자리수, n2 - 소수점에 할당된 자리수

--2) 문자 데이터
-- char() : 고정 길이 문자형
--          최대 2000byte 까지 저장 가능
-- varchar2() : 가변 길이 문자형
--              최대 4000byte 까지 저장 가능
-- long : 2GB 까지 저장 가능
--        long 형으로 설정된 컬럼은 기능을 지원하지 않는다.

--3) 날짜 데이터
-- date : 년/월/일 정보 저장
-- timestamp : 년/월/일/ 시:분:초 저장 가능


--1) 테이블 생성
--create table 테이블명( 컬럼명 데이터 타입,
--                      컬럼명 데이터 타입,
--                       .......); 
create table emp01( empno number(4),
                    ename varchar2(20),
                    sal number(7,2) );
select * from tab;                    

--2) 서브쿼리로 테이블 생성
--   복사본 테이블이 생성됨
--   단, 제약조건은 복사가 되지 않는다.
drop table emp02 purge;     --혹여나 emp02테이블이 있는 것 삭제
create table emp02 as select * from emp; --복사본 테이블이 생성됨
select * from tab;
select * from emp02;

--원하는 컬럼으로 구성된 복사본 테이블 생성
create table emp03 as select empno, ename from emp;
select * from emp03;
--원하는 행으로 구성된 복사본 테이블 생성
create table emp04 as select * from emp where deptno = 10;
select * from emp04;
--테이블 구조만 복사
create table emp05 as select * from emp where 1=0;-- 1=0 조건식은 항상 옳지 않다는 조건으로 데이터는 복사X
select * from emp05;

--2. alter
-- : 테이블 구조를 변경(컬럼추가, 컬럼 수정<컬럼명.자료형>, 컬럼 삭제)
-- 1) 컬럼 추가
--create table emp01( empno number(4),
--                    ename varchar2(20),
--                    sal number(7,2) );
alter table emp01 add(job varchar2(10));
desc emp01;

-- 2) 컬럼 수정
--     i)수정할 컬럼에 데이터가 없는 경우
--       컬럼의 데이터 타입을 변경할 수 있다.
--       컬럼의 크기를 변경할 수 있다.
--    ii)수정할 컬럼에 데이터가 있는 경우
--       컬럼의 데이터 타입을 변경할 수 없다.
--       컬럼의 크기는 늘리수 있지만,
--       현재 데이터 크기보다 작은 크기로 변경할 수 없다.

alter table emp01 modify(job varchar2(30)); --job의 컬럼크기를 10->30으로 변경
desc emp01;

-- 3) 컬럼 삭제
alter table emp01 drop column job;
alter table emp01 drop(job);
desc emp01;


--3. rename
-- : 테이블 이름 변경
-- 형식: rename old_name to new_name;
--Q. emp01 테이블을 TEST 테이블명으로 변경 해보자?
rename emp01 to test;
select * from tab;

--4. truncate
-- : 테이블의 모든 데이터를 삭제
-- 형식: truncate table_name;
truncate table emp02;  --emp02 테이블 안에 있는 데이터 모두 삭제
select * from emp02;

--5. drop
-- : 테이블 삭제
-- 형식: drop table table_name; (oracle 버전 10g부터는 삭제안되고 임시테이블로 교체됨)
--      drop table table_name purge; (purge를 넣어야 깨끗하게 삭제됨)

drop table test;     --임시테이블로 교체(써먹지도 못함)
select * from tab;

-- 임시 테이블 삭제
purge recyclebin;

------------------------------------------------------------------------------------------
--* 오라클의 객체
--  테이블, 뷰, 시퀀스, 인덱스, 동의어, 프로시저, 트리거
--
--//이런 객체 정보를 검색할때 데이터 딕셔너리 뷰를 통해 검색함
--//데이터 딕셔너리는 시스템 테이블이기 때문에 일반적으로 접근 안되서 딕셔너리 뷰를 이용함
--
--* 데이터 딕셔너리와 데이터 딕셔너리 뷰
--  데이터 딕셔너리를 통해서 접근가능함
--
--  - 데이터 딕셔너리 뷰 : user_xxxx
--     (가상 테이블)      all_xxxx
--		                dba_xxxx
--
--  - 데이터 딕셔너리(시스템 테이블) : 

--SCOTT 계정 소유의 테이블 객체에 대한 정보를 조회
select * from tab;              --tab : 공개 동의어
select * from sys.tab;              

select * from user_tables;

-- 자기 계정 소유(SCOTT 계정) 또는 권한을 부여 받은 객체 등에 관한 정보를 조회
select * from all_tables;

-- DBA 계정(sys 또는 system 계정)만 사용 가능함
select * from dba_tables; --오류 : 지금 SCOTT계정이 연결되어 있기 때문

-- 오라클 시스템의 계정 정보 검색
select * from dba_users;  --오류 : system 계정에서 검색해야함

------------------------------------------------------------------------------------
--DML(Data Manipulation Language, 데이터 조작어)
-- : insert, update, delete

--1. insert : 데이터 입력
-- 1)형식
--   insert into 테이블명(컬럼1, 컬럼2, ...)values(데이터1, 데이터2, ...);
--   insert into 테이블명 values(데이터1, 데이터2,....); 데이터를 컬럼순서대로 써야함

--[실습]
drop table dept01 purge; --이미 있는 dept01 테이블 삭제

--비어있는 dept01 복사본 테이블 생성
create table dept01 as select * from dept where 1=0; --테이블 구조만 복사됨. 데이터X
select * from dept01;
--형식1)
insert into dept01(deptno, dname, loc) values(10, 'ACCOUNTING', 'NEW YORK');
--형식2)
insert into dept01 values(20, 'RESEARCH', 'DALLAS');
insert into dept01 values(30, '영업부', '서울');

--NULL값 입력
insert into dept01(deptno, dname) values(40, '개발부'); --암시적 : 칼럼을 입력X
insert into dept01 values(50, '기획부', NULL);          --명시적 : 직접 NULL을 입력

--2) 서브쿼리로 데이터 입력
drop table dept02 purge;
-- dept02 테이블 생성
create table dept02 as select * from dept where 1=0; --테이블 구조만 복사
select * from dept02;
--서브쿼리로 데이터 입력
insert into dept02 select * from dept; --as는 복사본 테이블 형성할 때 쓰지만 insert는 as생략
insert into dept02 select * from dept02; --자신의 데이터를 그대로 넣으면서 데이터값이 제곱으로 늘어난다.

--3) insert all: 다중 테이블에 데이터 입력
-- 2개의 테이블 생성
create table emp_hir as select empno, ename, hiredate from emp where 1=0;
create table emp_mgr as select empno, ename, mgr from emp where 1=0;
-- insert all 명령문으로 다중 테이블에 데이터 입력
insert all 
            into emp_hir values(empno, ename, hiredate)
            into emp_mgr values(empno, ename, mgr)
            select empno, ename, hiredate, mgr from emp
            where deptno = 20;
            
select * from emp_hir;
select * from emp_mgr;


--2. update : 데이터 수정
--형식: update 테이블명 set 컬럼1 = 수정할 값1,
--                        컬럼2 = 수정할 값2
--                        where 조건절;

--[실습]
drop table emp01 purge;

--복사본 테이블 생성
create table emp01 as select * from emp;
select * from emp01;

--1) 모든 데이터 수정 : where조건절 빼고 쓰면 된다.
--Q. 모든 사원들의 부서번호를 30번으로 수정
update emp01 set deptno = 30;

--Q. 모든 사원들의 급여를 10% 인상
update emp01 set sal = sal * 1.1;

--Q. 모든 사원들의 입사일을 오늘 날짜로 수정
update emp01 set hiredate = sysdate;

--2) 특정 데이터만 수정 : where 조건절 사용
drop table emp02 purge;
create table emp02 as select * from emp; --복사본 테이블 생성
select * from emp02;

--Q. 급여가 3000 이상인 사원만 급여를 10%  인상
update emp02 set sal = sal * 1.1 where sal >= 3000;

--Q. 1987년도에 입사한 사원만 입사일을 오늘 날짜로 수정
update emp02 set hiredate = sysdate where substr(hiredate,1,2)='87';

--Q. SCOTT 사원의 입사일을 오늘 날짜로 수정하고, 급여를 50으로 커미션을 4000으로 수정
update emp02 set hiredate = sysdate, sal = 50, comm = 4000 where ename = 'SCOTT';


--3) 서브쿼리를 이용한 데이터 수정
--Q. 20번 부서의 지역명(DALLAS)을 40번 부서의 지역명(BOSTON)으로 수정
drop table dept01 purge;
create table dept01 as select * from dept; --복사본 테이블 생성
select * from dept01;

update dept01 set loc = (select loc from dept01 where deptno = 40)
    where deptno = 20;
    
--3. delete : 데이터 삭제
-- 형식: delete from 테이블명 where 조건절;
--1) 모든 데이터 삭제 : where 조건절을 사용하지 않는다.
select * from dept01;
delete from dept01;
rollback;           --트랜잭션을 취소 : delete로 삭제된 데이터를 복구한다.

--2) 조건을 만족하는 데이터 삭제 : where 조건절을 사용
delete from dept01 where deptno = 30;

--3) 서브쿼리를 이용한 데이터 삭제
--Q. 사원테이블에(emp02)에서 부서명이 SALES 부서인 사원을 삭제?
create table emp02 as select * from emp;
select * from emp02;

delete from emp02 where deptno = 
    (select deptno from dept where dname = 'SALES');
    
-------------------------------------------------------------------------------------------   
--* 테이블 구조가 동일한 두 테이블의 MERGE 연습
--
--  MERGE : 구조가 같은 2개의 테이블을 하나의 테이블로 합치는 기능.
--  MERGE명령을 수행할때 기존에 존재하는 행(ROW)이 있으면 새로운     
--  값으로 UPDATE되고, 존재하지 않으면 새로운 행(ROW)으로 추가된다.

drop table emp01 purge;
drop table emp02 purge;
select * from emp01;
select * from emp02;


1. create table emp01 as select * from emp;    --14개 데이터, 테이블 구조는 같음

2. create table emp02 as select * from emp where job='MANAGER'; --3개 데이터, 테이블 구조는 같음

3. update emp02 set job='Test'; --job이 MANAGER에서 Test로 바뀜

4. insert into emp02 values(8000, 'ahn', 'top', 7566, '2018/02/22',1200, 10, 20);

5. select * from emp02; --(확인)

6. merge into emp01
	using emp02
	on(emp01.empno = emp02.empno)
	when matched then
	     update set emp01.ename = emp02.ename,
			emp01.job = emp02.job,
			emp01.mgr = emp02.mgr,
			emp01.hiredate = emp02.hiredate,
			emp01.sal = emp02.sal,
			emp01.comm = emp02.comm,
			emp01.deptno = emp02.deptno
	when not matched then
	     insert values(emp02.empno, emp02.ename, emp02.job, 		         	         
		          emp02.mgr,emp02.hiredate, 
		         emp02.sal, emp02.comm,emp02.deptno);

7. select * from emp01; (합병된 결과 확인)
