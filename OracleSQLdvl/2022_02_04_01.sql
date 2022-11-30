--22.02.04.01 (금)

---------------------------------------------------------------------------------------
--비공개 동의어 예제
--1. system 계정으로 접속후 테이블 생성
conn system/oracle
create table systbl(ename varchar2(20));

--2. 생성된 테이블에 데이터 추가
conn system/oracle
insert into systbl values('신성호');
insert into systbl values('홍길동');

select * from systbl;

--3. scott 계정에게 systbl 테이블에 대한 select 객체권한을 부여
conn system/oracle
grant select on systbl to scott;

--4. scott 계정으로 접속후 검색
conn scott/tiger
select * from systbl; --오류발생
select * from system.systbl;  --검색 가능함

--5. scott 계정에게 동의어를 생성할 수 있는 권한을 부여한다.
conn system/oracle
grant create synonym to scott;

--6. scott  계정으로 접속 후 비공개 동의어 생성 : system.systbl --> systbl
conn scott/tiger
create synonym systbl for system.systbl;

--7. 동의어 목록 확인
conn scott/tiger
select * from user_synonyms;

--8. 동의어를 이용해서 검색
conn scott/tiger
select * from system.systbl;
select * from systbl;   --동의어를 생성했기 때문에 검색 가능(비공개 동의어)

--9. 동의어 삭제
conn scott/tiger
--형식 : drop synonym synonym_name;
drop synonym systbl;

------------------------------------------------------------------------------------
--공개 동의어
--1. DBA 계정으로 접속해서 공개 동의어를 생성할 수 있다.
--2. 공개 동의어를 만들때는 public을 붙여서 생성할 수 있다.

-- 공개 동의어 생성
conn system/oracle
create public synonym pubdept for scott.dept;

-- 공개 동의어 목록
select * from dba_synonyms;

-- 공개 동의어 삭제
conn system/oracle
drop public synonym pubdept;

-----------------------------------------------------------------------------------------
-- PL/SQL

--Q. Hello World ~!! 출력
set SERVEROUTPUT ON
begin                      --실행부 시작
    DBMS_OUTPUT.PUT_LINE('Hello World~!!');
end;                       --실행부 끝 

-- 변수 사용하기
set SERVEROUTPUT ON
declare                    --선언부 시작
    vempno number(4);      --변수 선언: 스칼라 변수 
    vename varchar2(10);
begin                      --실행부 시작
    vempno := 7788;        --변수명을 대.소문자를 구분하지 않는다. 
    vename := 'SCOTT';
    DBMS_OUTPUT.PUT_LINE('사번 / 이름');
    DBMS_OUTPUT.PUT_LINE(VEMPNO || '/' || VENAME);
    --변수는 ''를 넣지 않는다.
    --칼럼과 문자를 연결하기 위해 반드시 || 를 넣어줘야 한다.
end;                       --실행부 끝     

--사번과 이름 검색하기 : 레퍼런스 변수 사용하기
set SERVEROUTPUT ON
declare
    vempno emp.empno%type;       --레퍼런스 변수
    vename emp.ename%type;       
begin
    select empno, ename into vempno, vename from emp
    where ename = 'SCOTT';
    DBMS_OUTPUT.put_line('사번 / 이름');
    DBMS_OUTPUT.put_line(vempno || '/' || vename);
end;    

---------------------------------------------------------------------------------
--조건문(=선택문)
--1. if ~ then ~ end if
--Q. SCOTT 사원의 부서번호를 검색해서 부서명을 출력하는 PL/SQL문 작성?
set SERVEROUTPUT ON
declare                                    --선언부
    vempno number(4);
    vename varchar2(20);
    vdeptno dept.deptno%type;
    vdname varchar2(20) := null;
begin                                      --실행부 
    select empno, ename, deptno into vempno, vename, vdeptno from emp
        where ename = 'SCOTT';
    
    if vdeptno = 10 then
        vdname := 'ACCOUNTING';
    end if;    
    if vdeptno = 20 then
        vdname := 'RESEARCH';
    end if;    
    if vdeptno = 30 then
        vdname := 'SALES';
    end if; 
    if vdeptno = 40 then
        vdname := 'OPERATIONS';
    end if;  
    
    DBMS_OUTPUT.PUT_LINE('사번 / 이름 / 부서명');
    DBMS_OUTPUT.PUT_LINE(vempno||'/'||vename||'/'||vdname);
end;    

--Q. 사원 테이블에서 SCOTT 사원의 연봉을 구하는 PL/SQL 작성?
set SERVEROUTPUT ON
declare
    vemp emp%rowtype;      --레퍼런스 변수(emp테이블의 8가지 컬럼을 모두 받음)
    annsal number(7,2);     --스칼라 변수
begin
    select * into vemp from emp where ename='SCOTT';
    --*의 값을 vemp변수에 준다
    if vemp.comm is null then --null값이면 0을 할당하라는 의미
        vemp.comm := 0;
    end if;    
    
    annsal := vemp.sal * 12 + vemp.comm;
    DBMS_OUTPUT.PUT_LINE('사번 / 이름 / 연봉');
    DBMS_OUTPUT.PUT_LINE(vemp.empno||'/'||vemp.ename||'/'||annsal);
end;    

--2. if ~ then ~ else ~ end if
--Q. 사원 테이블에서 SCOTT사원의 연봉을 구하는 PL/SQL문 작성?
set SERVEROUTPUT ON
declare
    vemp emp%rowtype;           --레퍼런스 변수
    annsal number(7,2);         --스칼라 변수
begin
    select * into vemp from emp where ename = 'SCOTT';
    
    if vemp.comm is null then
        annsal := vemp.sal * 12;
    else
        annsal := vemp.sal * 12 + vemp.comm;
    end if;
    
    DBMS_OUTPUT.PUT_LINE('사번 / 이름 / 연봉');
    DBMS_OUTPUT.PUT_LINE(vemp.empno||'/'||vemp.ename||'/'||annsal);
end;

--3. if ~ then ~ elsif ~ else ~ end if
--Q. SCOTT 사원의 부서 번호를 이용해서 부서명을 구하는 PL/SQL 작성?
set SERVEROUTPUT ON
declare
    vemp emp%rowtype;       --레퍼런스 변수
    vdname varchar2(14);    --스칼라 변수
begin
    select * into vemp from emp where ename = 'SCOTT';
    
    if vemp.deptno = 10 then
        vdname := 'ACCOUNTING';
    elsif vemp.deptno = 20 then
        vdname := 'RESEARCH';
    elsif vemp.deptno = 30 then
        vdname := 'SALES';
    elsif vemp.deptno = 40 then --여기서는 elsif 대신 else 써도 됨
        vdname := 'OPERATIONS';
    end if;
    
    DBMS_OUTPUT.PUT_LINE('사번 / 이름 / 부서명');
    DBMS_OUTPUT.PUT_LINE(vemp.empno||'/'||vemp.ename||'/'||vdname);
    
end;
--------------------------------------------------------------------------------------
--반복문
--1. Basic Loop문
-- loop
--    반복 실행된 문장;
--    조건식   exit;
-- end loop;

--Q1. 1~5까지 출력
set SERVEROUTPUT ON
declare
    n number := 1;                --변수의 초기값 1을 설정
begin                      
    loop
        DBMS_OUTPUT.PUT_LINE (n);
        n := n+1;   --if문이 없으면 무한루프가 돌며 1000000까지가 제한이기 때문에 넘어가면 오류발생
        if n>5 then --if문이 들어가 5까지만 루프가 돌며 exit로 루프를 빠져나온다.
            exit;
        end if;
    end loop;
end;

--Q2. 1부터 10까지 합을 구하는 프로그램 작성
set SERVEROUTPUT ON
declare
    n number := 1;      --루프를 돌릴 변수 n 초기 값 1
    s number := 0;      --합이 누적될 변수
begin
    loop
        s := s + n;
        n := n + 1;
        if n>10 then
            exit;
        end if;    
    end loop;
    DBMS_OUTPUT.put_line('1~10까지의 합:'|| s);  --1~10까지의 합:55
end;

--2. For Loop문
--  for  변수명  in  작은값..큰값  loop
--     반복 실행될 문장;
--  end loop;

--Q1. For Loop문으로 1부터 5까지 출력
set SERVEROUTPUT ON
begin
    for n in 1..5 loop      --자동으로 1씩 증가 //증감식 n := n+1을 넣으면 오류발생
    --작은 값과 큰값의 위치를 바꾸면 오류발생은 안하지만 결과가 출력X
        DBMS_OUTPUT.PUT_LINE (n);
    end loop;
end;

--Q2. For Loop문으로 5부터 1까지 출력
set SERVEROUTPUT ON
begin
    for n in reverse 1..5 loop      --자동으로 1씩 감소 
        DBMS_OUTPUT.PUT_LINE (n);   
    end loop;
end;

--Q3. For Loop문을 이용해서 부서 테이블(DEPT)의 모든 정보를 출력하는 PL/SQL문
--    작성 하세요?
set SERVEROUTPUT ON
declare
    vdept dept%rowtype;
begin
    DBMS_OUTPUT.PUT_LINE('부서번호 / 부서명 / 지역명');
    for cnt in 1..4 loop
        select * into vdept from dept where deptno = 10 * cnt;
        
        DBMS_OUTPUT.put_line(vdept.deptno||'/'||vdept.dname||'/'||vdept.loc);
    end loop;
end;

--3. While Loop문
-- while   조건식   loop
--     실행될 문장;
-- end loop;
--Q1. while loop문으로 1부터 5까지 출력
set SERVEROUTPUT ON
declare
    n number := 1;
begin
    while n<=5 loop
        DBMS_OUTPUT.PUT_LINE (n);
        n := n+1;
    end loop;
end;

--Q2. while loop문으로 별(*)을 삼각형 모양으로 출력
set SERVEROUTPUT ON
declare
    c number := 1;
    str varchar2(100) := null;
begin
    while c<=5 loop
        str := str || '*'; --*이 계속 누적됨
        DBMS_OUTPUT.put_line(str);
        c := c+1;
    end loop;
end;
    