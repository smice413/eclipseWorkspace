--2022.01.24.02 (월)


--SQL 함수
select 10+20 from dept;--4개 출력
select 10+20 from emp;--14개 출력

--dual 테이블
--1. sys 계정 소유의 테이블이고 공개 동의어로 설정되어 있음.
--2. dual 테이블은 공개가 되어 있기 때문에 누구나 사용 가능하다.
--3. dual 테이블은 데이터가 1개 밖에 없기 때문에, 연산 결과를 1번만 출력한다.

select 10+20 from dual;--1개 출력
select 10+20 from sys.dual; --원래는 이렇게 작성하는게 원칙임
desc dual;             --dummy 컬럼 1개 있음
select * from dual;    --대문자 X 데이터 1개 있음

select * from sys.tab;
select * from tab; --공개 동의어

--1. 숫자 함수
-- abs(): 절대값을 구해주는 함수
select -10, abs(-10), ABS(-20) from dual;
-- 함수명은 대.소문자를 구분하지 않는다.

--floor(): 소수점 이하를 버리는 역할
select 34.5678, floor(34.5678) from dual;

--round(): 특정 자리에서 반올림을 하는 역할
--round(대상값, 자리수)
select 34.5678, round(34.5678) from dual;--35출력 : 소수 첫번째 자리에서 반올림
select 34.5678, round(34.5678, 2) from dual; --34.57 : 소수 셋째자리에서 반올림해서 소수 둘째자리까지 출력
select 34.5678, round(34.5678, -1) from dual;-- 30 : -1은 정수의 일의자리를 말하는 것으로 4이기 때문에
                                             --     반올림 안되고 버려짐
select 34.5678, round(35.5678, -1) from dual;-- 40 : 정수의 일의 자리가 5이기 때문에 반올림됨

--trunc() : 지정한 자리수 이하를 버림하는 역할
select trunc(34.5678), trunc(34.5678, 2), trunc(34.5678, -1) from dual;

--mod() : 나머지를 구해주는 함수
select mod(27, 2), mod(27, 5), mod(27, 7) from dual;
--          1           2           6

--Q. 사원테이블에서 사원번호가 홀수인 사원들을 검색하는 SQL문 작성?
select * from emp where mod(empno,2) = 1;


--2. 문자 처리 함수

--upper(): 대문자로 변환 해주는 함수
select 'Welcome to Oracle', upper('Welcome to Oracle') from dual;

--lower(): 소문자로 변환 해주는 함수
select 'Welcome to Oracle', lower('Welcome to Oracle') from dual;

--initcap(): 각 단어의 첫글자를 대문자로 변환 해주는 함수
select 'Welcome to Oracle', initcap('Welcome to Oracle') from dual;

--Q. 사원 테이블에서 job이 manager인 사원을 검색하는 SQL문 작성?
select empno, ename, job from emp where job = 'manager'; --소문자라 검색안됨
select empno, ename, job from emp where lower(job) = 'manager'; --job컬럼에 있는 데이터를 소문자로 변환
                                                                --했기 때문에 검색이 됨
select empno, ename, job from emp where job = upper('manager'); --소문자를 대문자로 변환해서 검색가능                                                      

--length(): 문자열의 길이를 구해주는 함수(글자수)
select length('oracle'), length('오라클') from dual;

--lengthb(): 문자열의 길이를 바이트 단위로 구해주는 함수
--영문 1글자: 1byte, 한글 1글자 : 3byte
select lengthb('oracle'), lengthb('오라클')from dual;

--substr(): 문자열의 일부를 추출하는 함수
--형식: substr(대상 문자열, 시작위치, 추출할 문자갯수)
--시작 위치 번호는 왼쪽부터 1번부터 시작한다.

select substr('Welcome to Oracle', 4, 3) from dual; --com 출력
select substr('Welcome to Oracle', -4, 3) from dual;--acl 출력 맨뒤에서 4번째를 기준으로 3개 추출

--Q. 사원 테이블에서 입사일(hiredate)을 년, 월, 일을 추출해서 출력하는 SQL문 작성?
select substr(hiredate, 1, 2) as "년", --as ""원칙이고 생략가능
       substr(hiredate, 4, 2) 월,      --as ""생략
       substr(hiredate, 7, 2) 일 from emp;
       
--Q. 사원 테이블에서 87년도에 입사한 사원을 검색하는 SQL문 작성?
select * from emp where substr(hiredate, 1, 2) = '87';

--Q. 사원 테이블에서 사원명이 E로 끝나는 사원을 검색하는 SQL문 작성
select * from emp where ename like '%E';
select * from emp where substr(ename, -1, 1) = 'E';


--instr(): 특정 문자의 위치를 구해주는 함수
--instr(대상, 찾을 문자) : 가장 먼저 나오는 문자의 위치를 찾아준다.
--instr(대상, 찾을 문자, 시작 위치, 몇번째 발견)

--Q. 가장 먼저 나오는 'O'의 위치를 찾아준다.
select instr('Welcome to oracle', 'o') from dual;

--Q. 6번 이후에 2번째 발견된 'o'의 위치를 찾아준다.
select instr('Welcome to oracle', 'o', 6, 2) from dual;

--Q. 사원 테이블에서 사원명의 3번쨰 자리가 R로 되어있는 사원을 검색하는 SQL문 작성?
-- 3가지 방법 : like 연산자, substr(), instr()
select * from emp where ename like '__R%';
select * from emp where substr(ename, 3, 1) = 'R';
select * from emp where instr(ename, 'R') = 3;
select * from emp where instr(ename, 'R', 3, 1) = 3;

--lpad() /rpad() : 특정 기호로 채워주는 역할
select lpad('Oracle', 20, '#') from dual; --특정 기호를 왼쪽에 채워줌
select rpad('Oracle', 20, '#') from dual; --특정 기호를 오른쪽에 채워줌

--ltrim(): 왼쪽 공백을 삭제하는 함수
--rtrim(): 오른쪽 공백을 삭제하는 함수
select '     oracle     ', ltrim('     oracle     ') from dual;--oracle왼쪽 공백만 없애줌
select rtrim('    oracle      ')from dual;--oracle오른쪽 공백만 없애줌

--trim(): 문자열 좌.우의 공백을 삭제하는 함수
--        특정 문자를 잘라내는 함수
select trim('  Oracle    ') from dual;
select trim('a' from 'aaaaaOracleaaaaa') from dual;--a라는 문자를 잘라내라


--3. 날짜 함수
--sysdate: 시스템의 날짜를 구해주는 함수
select sysdate from dual; --22/01/24

select sysdate-1 어제, sysdate 오늘, sysdate+1 내일 from dual;

--Q. 사원 테이블에서 각 사원들의 현재까지 근무일수를 구하는 SQL문 작성?
select sysdate - hiredate from emp;
select round(sysdate - hiredate) from emp; --소수 1째자리에서 반올림
select trunc(sysdate - hiredate) from emp; --소수점 자리를 버림

--month_between() : 두 날짜 사이의 경과된 개월 수를 구해주는 함수
--month_between(date1, date2)
--Q. 사원 테이블에서 각 사월들의 근무한 개월 수를 구하는 SQL문 작성?
select ename, sysdate, hiredate, months_between(sysdate, hiredate)from emp;
select round(months_between(sysdate, hiredate)) from emp;
select trunc(months_between(sysdate, hiredate)) from emp;

-- add_months() : 특정 날짜에  경과된 개월의 날짜를 구해주는 함수
-- add_months(date, 개월수)
--Q. 사원 테이블에서 각 사원들의 입사한 날짜에 6개월이 경과된 일자를 구하는 SQL문 작성?
select ename, hiredate, add_months(hiredate, 6) from emp;
--Q. 입과한 후에 6개월 경과된 일자를 구하는 SQL문 작성?
select add_months('21/12/21', 6) from dual;

-- next_day() : 해당 요일의 가장 가까운 날짜를 구해주는 함수
-- next_day(date, '요일')
--Q. 오늘을 기준으로 가장 가까운 토요일이 언제인지 구하는 SQL문 작성?
select sysdate, next_day(sysdate, '토요일') from dual; --한글 운영 체제이면 요일을 한글로, 영문이면 영어로


-- last_day(): 해당 달의 마지막 날짜를 구해주는 함수
--Q. 각 사원들이 입사한 달의 마지막 날짜를 구하는 SQL문 작성?
select hiredate, last_day(hiredate) from emp;

--Q. 이번달의 가장 마지막 날짜를 구하는 SQL문 작성?
select sysdate, last_day(sysdate) from dual;
select last_day('22/02/01') from dual; --22/02/28

--4. 형변환 함수