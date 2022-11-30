--22.02.04 HW(금)

--------------------------------------------------------------------------------
--Q. 사원 테이블에서 사원명을 검색하여 사원의 직급을 구해오는 저장 프로시저를
--   생성 하세요?
--프로시저 생성
create or replace procedure job_ename(
            vename in emp.ename%type,
            vjob out emp.job%type)
is
begin
    select job into vjob from emp
        where ename = vename;
end;
--프로시저 목록 확인
select * from user_source;

--바인드 변수 생성
variable var_job varchar2(14);

--프로시저 실행
execute job_ename('SCOTT', :var_job);
print var_job;



--답안
--과제.
--사원 테이블에서 사원명을 검색하여 사원의 직급을 구해오는 저장 프로시저를 만들어서 실행하세요?

--1. 저장 프로시저 생성
create or replace procedure ename_job(
        vename in emp.ename%type,
        vjob out emp.job%type)
is
begin
    select job into vjob from emp where ename = vename;
end;

--2. 프로시저 목록 확인
select * from  user_source;

--3. 바인드 변수 생성
variable var_job varchar2(10);

--4. 프로시저 실행
execute ename_job('SCOTT', :var_job); 
execute ename_job('KING', :var_job); 
execute ename_job('SMITH', :var_job); 

--5. 바인드 변수로 받은 값 출력
print var_job;