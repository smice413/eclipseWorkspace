-- 2022.01.21(금)
select * from sys.tab;
select * from tab;

--dept 테이블 구조
describe dept;
desc dept;

--dept데이터 검색 : SQL문은 대, 소문자를 구분하지 않는다.
select * from dept;
SELECT * FROM DEPT;

--emp 테이블 구조
desc emp;

--emp 테이블 데이터 검색
select * from emp;

-- 오라클 데이터 타입
--1. 숫자 데이터
--   number(n) : number(2) 정수 2자리까지 저장하라는 의미
--   number(n1, n2) : n1은 전체 자리수
--                    n2는 소수점에 할당된 자리수

--2. 문자 데이터
--   char() : 고정 길이 문자형
--            최대 2000byte까지 저장 가능함.
--   varchar2() : 가변 길이 문자형
--                최대 4000byte까지 저장 가능함.
--   long : 2GB 까지 저장 가능.
--          long형으로 설정된 컬럼은 검색기능 지원 안함.
--          (이유: 한개의 데이터당 2GB까지 가능해서 너무 데이터가 크기 때문에)



--3. 날짜 데이터
--    date : 년/월/일 저장
--    timestamp: 년/월/일/시/분/초 저장


-- select SQL문
select * from dept;--*은 전체 컬럼을 검색하겠다는 의미

select loc,deptno, dname from dept;--컬럼 쓴 순서대로 검색함

select * from emp;

select empno, ename, sal from emp;


--산술 연산자 : +,-,*,/
select sal + comm from emp;
select sal - 100 from emp;
select sal * 100 from emp;
select sal / 100 from emp;

--Q. 사원테이블(EMP)에 소속된 사원들의 연봉을 구해보자?
--    연봉 = 급여(SAL) * 12 + 커미션(COMM)

select ename,job,sal,sal*12,sal*12+comm from emp;

-- NULL
--1. 정해지지 않은 값을 의미
--2. NULL 값은 산술연산을 할 수 없다.
--3. NULL 값의 예
--   EX) EMP 테이블 : MGR 컬럼
--                   COMM 컬럼

--문제 해결 방식 
-- NVL(컬럼, 변환될 값) : NULL 값을 다른 값(0)으로 변환 해주는 함수
-- ex) NVL(COMM, 0)

select ename, job, sal, comm, sal*12, sal*12+nvl(comm, 0) from emp;

--별칭 부여하기 : as "별칭명"
--단, 띄어쓰기 있을 경우 ""를 반드시 부여해야한다.
select ename, sal*12+nvl(comm, 0) as "Annsal"from emp;
select ename, sal*12+nvl(comm, 0) "Annsal"from emp; --as 생략가능
select ename, sal*12+nvl(comm, 0) Annsal from emp;--""만 생략 가능하고 as도 함께 생략 가능하다

select ename, sal*12+nvl(comm, 0) as "연봉"from emp;
select ename, sal*12+nvl(comm, 0) as 연봉 from emp; --""생략 가능
select ename, sal*12+nvl(comm, 0) 연봉from emp; --as 생략 가능

--Concatenation 연산자 : ||
--: 컬럼과 문자열을 연결할 때 사용함.
select ename || ' is a ' || job from emp;

--distinct : 중복행을 제거하고 1번만 출력
select deptno from emp;

select distinct deptno from emp; --3개의 부서번호 출력 : 10, 20, 30

--Q. EMP 테이블에서 각 사원들의 JOB을 1번만 출력하는 SQL문을 작성하세요
select job from emp;
select distinct job from emp;--중복되는 job을 제거하고 job의 종류가 5가지 있는지를 알 수 있다.


--count(컬럼명): 데이터 갯수 구하기
select count(*)from dept; --4개
select count(*)from emp; --emp데이터 (*)은 총 갯수구하는 것, 14개
select count(job)from emp; --14개
--Q. EMP 테이블에서 중복을 제거한 JOB의 갯수를 구하는 SQL문을 작성하세요.
select count(distinct job) from emp; --5개

-------------------------------------------------------------------------------

--where 조건절: 비교 연산자( =, >, >=, <, <=, !=,^=,<> )

--1. 숫자 데이터 검색
--Q. 사원 테이블(emp)에서 급여를 3000 이상 받는 사원을 검색하는 SQL문을 작성하세요?
select * from emp where sal >= 3000;
--Q. 급여가 3000인 사원을 검색?
select * from emp where sal = 3000;
--Q. 급여가 3000이 아닌 사원을 검색?
select * from emp where sal != 3000; --12명의 사원 검색됨
select * from emp where sal ^= 3000; --같은 결과
select * from emp where sal <> 3000; --같은 결과
--Q. 급여가 1500 이하인 사원의 사원번호, 사원명, 급여을 출력하는 SQL문 작성
select empno, ename, sal from emp where sal <= 1500;

--2. 문자 데이터 검색
--1) 문자 데이터는 대, 소문자를 구분한다.
--2) 문자 데이터를 검색 할 때는 문자열 좌.우에 외따옴표(')를 붙어야 한다.

--Q. 사원테이블에서 사원명이 FORD인 사원의 정보를 검색하는 SQL문 작성?
select * from emp where ename = 'ford'; --검색 결과 없음: 대문자 이름 데이터를 소문자로 검색했기 때문에 
select * from emp where ename = FORD; --오류 발생: 외따옴표 없음
select * from emp where ename = "FORD" --오류 발생: 쌍따옴표 안됨
select * from emp where ename = 'FORD'; --정상

--Q. SCOTT 사원의 사원번호, 사원명, 급여를 출력하는 SQL문 작성?
select empno, ename, sal from emp where ename = 'SCOTT';

--3. 날짜 데이터 검색
--1) 날짜 데이터를 검색할 때 날짜 좌.우에 외따옴표(’)를 붙여야함
--2) 날짜 데이터를 비교할 때 비교 연산자를 사용한다.

--Q. 1982년 1월 1일 이후에 입사한 사원을 검색하는 SQL문 작성
select * from emp where hiredate >= 82/01/01; --오류발생: 외따옴표 없음
select * from emp where hiredate >= '82/01/01';-- 정상
select * from emp where hiredate >= '1982/01/01'; --정상

select * from emp where hiredate >= '82/01/01'
 order by hiredate asc;-- 입사일을 오름차순 정렬


-----------------------------------------------------------------------------------------
--논리 연산자 : and, or, not
--1. and 연산자 : 두 조건식을 모두 만족하는 데이터를 검색
--Q. 사원테이블에서 부서번호가 10번이고, JOB이 MANAGER인 사원을 검색하는 SQL문 작성
select * from emp where deptno=10 and job='MANAGER';

--2. or 연산자 : 두 조건식 중에서 한가지만 만족해도 검색
--Q. 사원테이블에서 부서번호가 10이거나, JOB이 MANAGER인 사원을 검색하는 SQL문 작성
select * from emp where deptno=10 or job='MANAGER';

--3. not 연산자 : 논리값을 반대로 바꿔주는 역할
--Q. 부서번호가 10번이 아닌 사원을 검색하는 SQL문 작성
select * from emp where not deptno=10; --논리연산자
select * from emp where deptno!=10; --비교연산자
select * from emp where deptno^=10; --비교연산자
select * from emp where deptno<>10; --비교연산자

--Q1. 급여를 2000에서 3000 사이의 급여를 받는 사원을 검색하는 SQL문 작성하세요?
select * from emp where sal>=2000 and sal<=3000;

--Q2. 커미션이 300이거나 500이거나 1400인 사원을 검색하는 SQL문 작성하세요?
select * from emp where comm=300 or comm=500 or comm=1400;

--Q3. 사원번호가 7521이거나 7654이거나 7844인 사원을 검색하는 SQL문 작성하세요?
select * from emp where empno=7521 or empno=7654 or empno=7844;

--between and 연산자
-- : where 컬럼명 between 작은값 and 큰값
--Q1. 급여를 2000에서 3000 사이의 급여를 받는 사원을 검색하는 SQL문 작성하세요?
select * from emp where sal>=2000 and sal<=3000; --and 연산자로 작성 
select * from emp where sal between 2000 and 3000;--between and 연산자로 작성

--Q2. 급여가 2000미만이거나 3000 초과인 사원을 검색하는 SQL문 작성?
select * from emp where sal<2000 or sal>3000;
select * from emp where not between 2000 and 3000;

--Q3. 1987년도에 입사한 사원을 검색하는 SQL문을 작성?
select * from emp where hiredate >= '87/01/01' and hiredate <='87/12/31';
select * from emp where hiredate between '87/01/01' and '87/12/31';

--in 연산자
-- : where 컬럼명 in (데이터1, 데이터2, ...)
--Q. 커미션이 300이거나 500이거나 1400인 사원을 검색하는 SQL문 작성하세요?
select * from emp where comm=300 or comm=500 or comm=1400;
select * from emp where comm in (300,500,1400);

--Q. 커미션이 300, 500, 1400이 아닌 사원을 겁색하는 SQL문 작성?
select * from emp where comm!=300 and comm!=500 and comm!=1400;

select * from emp where comm not in (300,500,1400); --이해 not을 붙였다고 해서 or처럼 합집합이 되나?

--Q. 사원번호가 7521이거나 7844인 사원을 검색하는 SQL문 작성?
select * from emp where empno=7521 or empno=7844;

select * from emp where empno in(7521, 7844);

-- like 연산자와 와일드 카드 : 검색기능을 구현할 때 사용함.
-- : where 컬럼명 like pattern

-- 와일드 카드(pattern을 만들어 낸다)
-- 1. % : 문자가 없거나, 하나 이상의 문자에 어떤 값이 와도 상관없다는 의미.
-- 2. _ : 하나의 문자에 어떤 값이 와도 상관없다.

--Q. 사원테이블에서 사원명이 대문자 F로 시작하는 사원을 검색하는 SQL문 작성?
select *from emp where ename = 'FORD'; --FORD 사원만 검색

select *from emp where ename like 'F%';

--Q. 사원테이블에서 사원명이 N으로 끝나는 사원을 검색하는 SQL문 작성?
select * from emp where ename like '%N';

--Q. 사원테이블에서 사원명이 A를 포함하는 사원을 검색하는 SQL문 작성?
select * from emp where ename like '%A%';

--언더바(_) 와일드 카드
-- : 하나의 문자에 어떤 값이 와도 상관없다.
--Q. 사원 이름의 두번째 글자가 A인 사원을 검색하는 SQL문 작성?
select * from emp where ename like '_A%'; --첫번째 문자는 어떤 값이 와도 상관없고 두번째 글자A 그 뒤로 없거나 어떤값이 와도되는 %넣음

--Q. 사원 이름의 세번째 글자가 A인 사원을 검색하는 SQL문 작성?
select * from emp where ename like '__A%';--언더바 2개넣음

--Q. 사원 이름이 끝에서 2번째 글자가 E인 사원을 검색하는 SQL문 작성?
select * from emp where ename like '%E_';

--Q. 사원명에 A가 포함되어 있지 않은 사원을 검색하는 SQL문 작성?
select * from emp where ename not like '%A%';
