--22.02.04.02 (금)

-- 저장 프로시저

--[실습]
drop table emp01 purge;
create table emp01 as select * from emp; --복사본 테이블 생성
select * from emp01;

--1. 저장 프로시저 생성
create or replace procedure del_all
is
begin
    delete from emp01;
end;

--2. 프로시저 목록 확인
select * from user_source;

--3. 프로시저 실행
execute del_all;--emp01이 지워짐
exec del_all;

--4. 프로시저 실행 확인
select * from emp01;

rollback; --자동 commit으로 복구가 안됨//프로시저 생성을 반복해서 이전 commit이 사라졌기 때문
insert into emp01 select * from emp;
---------------------------------------------------------------------------------------------
--매개변수가 있는 프로시저
--1. 매개변수가 있는 프로시저 생성
create or replace procedure del_ename(vename in emp01.ename%type)
is
begin
    delete from emp01 where ename = vename; --매개변수 vename을 통해 execute 실행문에서 선언한 
                                            --'SCOTT' 데이터를 받은 where 조건절 vename이 전달하여 데이터 지움
end;

--2. 프로시저 목록 확인
select * from user_source;

--3. 프로시저 실행
select * from emp01;
execute del_ename('SCOTT');
execute del_ename('KING');
execute del_ename('SMITH');

rollback;

-------------------------------------------------------------------------------------------
-- 매개변수의 MODE가 in, out 으로 되어 있는 프로시저
-- in : 매개변수로 값을 받는 역할
-- out : 매개변수로 값을 돌려주는 역할
--1. 프로시저 생성
-- 사원번호를 프로시저의 매개변수로 전달 받아서, 그 사원의 사원명, 급여, 직책을
-- 구하는 프로시저 생성
create or replace procedure sal_empno(
        vempno in emp.empno%type,
        vename out emp.ename%type,
        vsal out emp.sal%type,
        vjob out emp.job%type)
is
begin
    select ename, sal, job into vename, vsal, vjob from emp
        where empno = vempno;
end;


--2. 프로시저 목록 확인
select * from user_source;

--3. 바인드 변수 : 프로시저를 실행 했을때 결과를 돌려받는 변수
variable var_ename varchar2(12);
variable var_sal number;
variable var_job varchar2(10);

--4. 프로시저 실행
execute sal_empno(7788, :var_ename, :var_sal, :var_job);
execute sal_empno(7839, :var_ename, :var_sal, :var_job);
print var_ename;
print var_sal;
print var_job;

--------------------------------------------------------------------------------
--Q. 사원 테이블에서 사원명을 검색하여 사원의 직급을 구해오는 저장 프로시저를
--   생성 하세요?

----------------------------------------------------------------------------------
--자바 프로그램으로 프로시저 실행
--예1.
--1. 프로시저 생성
create or replace procedure del_all
is
begin
    delete from emp01;
end;

--2. emp01 테이블 생성
drop table emp01 purge;
create table emp01 as select * from emp;
select * from emp01;