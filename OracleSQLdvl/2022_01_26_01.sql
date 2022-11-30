--2022.01.26.01 (수)

--ANSI OUTER JOIN
--형식: select * from table1 [ left | right | full ] outer join table2

--1. dept01 테이블 생성
create table dept01(deptno number(2), dname varchar2(14));
insert into dept01 values(10, 'ACCOUNTING');
insert into dept01 values(20, 'RESEARCH');
select * from dept01;

--2. dept02 테이블 생성
create table dept02(deptno number(2), dname varchar2(14));
insert into dept02 values(10, 'ACCOUNTING');
insert into dept02 values(30, 'SALES');
select * from dept02;

--3. left outer join : dept01 테이블 정보만 출력됨
select * from dept01 left outer join dept02 using (deptno);

--4. right outer join : dept02 테이블 정보만 출력됨
select * from dept01 right outer join dept02 using (deptno);

--5. full outer join : dept01, dept02 테이블 모든 정보 출력됨
select * from dept01 full outer join dept02 using (deptno);

-------------------------------------------------------------------------------------
--서브 쿼리
--Q. SCOTT 사원이 소속된 부서명을 출력하는 SQL문 작성?

--1)사원 테이블에서 SCOTT 사원의 부서번호를 구한다.
select deptno from emp where ename = 'SCOTT';  --20
--2)부서 테이블에서 20번 부서의 부서명을 구한다.
select dname from dept where deptno = 20;      --RESEARCH

-- 서브쿼리로 구하기
select dname from dept where deptno =               --메인쿼리
    (select deptno from emp where ename = 'SCOTT'); --서브쿼리
    
--join으로 구하기
select dname from dept, emp where dept.deptno = emp.deptno and ename = 'SCOTT';
select dname from dept inner join emp on dept.deptno = emp.deptno where ename = 'SCOTT';
select dname from dept inner join emp using (deptno) where ename = 'SCOTT';
select dname from dept natural join emp where ename = 'SCOTT';


--1. 단일 행 서브쿼리 : 
-- 1)서브쿼리의 검색 결과가 1개만 반환되는 쿼리
-- 2)메인쿼리의 where 조건절에서 비교 연산자(=, >, >=, <, <=, ! = )만 사용가능

--Q. 사원 테이블에서 가장 최근에 입사한 사원명을 출력하는 SQL문 작성?
select ename, hiredate from emp where hiredate = (select max(hiredate) from emp);

--Q. 사원 테이블에서 최대 급여를 받는 사원명과 최대급여 금액을 출력하는 SQL문 작성?
select ename, max(sal) from emp; --오류발생: 그룹함수와 일반컬럼 같이 사용X
select ename, sal from emp where sal=
    (select max(sal) from emp);  --KING 5000
    
--Q. 직속상관(MGR)이 KING인 사원의 사원명과 급여를 출력하는 SQL문 작성?
select ename, sal from emp where mgr =                  --메인쿼리
    (select empno from emp where ename = 'KING');       --서브쿼리 7839
    
    
--2. 다중행 서브쿼리
-- 1) 서브쿼리에서 반환되는 검색 결과가 2개 이상인 서브쿼리
-- 2) 메인 쿼리의 where 조건절에서 다중행 연산자(in, all, any...)를 사용해야 한다.

-- in 연산자
-- : 서브쿼리의 검색 결과 중에서 하나라도 일치되면 참이된다.
--Q. 급여를 3000이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원들의
--   정보를 출력하는 SQL문 작성?

-- 각 부서별 최대급여 금액 구하기
select deptno, max(sal) from emp group by deptno;
--30	2850
--20	3000
--10	5000
select ename, sal, deptno from emp where deptno in        --메인쿼리(10번 20번 둘다 검색가능)
    (select distinct(deptno) from emp where sal >= 3000); --다중행 서브쿼리 10, 20
    
--all 연산자
-- : 메인 쿼리의 비교 조건이 서브쿼리의 검색 결과와 모든 값이 일치하면 참이된다.

--Q. 30번 부서에 소속된 사원 중에서 급여를 가장 많이 받는 사원보다 더 많은
--    급여를 받는 사원의 이름과 급여를 출력하는 SQL문 작성?
--1) 단일행 서브쿼리로 구하기
select ename, sal from emp where sal >
    (select max(sal) from emp where deptno = 30);         --서브쿼리 2850
    
--2) 다중행 서브쿼리로 구하기
select ename, sal from emp where sal >all               -- >all: 서브쿼리의 결과를 모두 만족한 것보다 크다
    (select sal from emp where deptno = 30);            --다중행 서브쿼리: 결과가 여러개 나옴  
    
--any 연산자
-- : 메인쿼리의 비교 조건이 서브쿼리의 검색 결과와 하나 이상이 일치되면 참이 된다.

--Q. 부서번호가 30번인 사원들의 급여중 가장 낮은 급여(950)보다 높은 급여를 받는
--   사원명과 급여를 출력하는 SQL문 작성?
--1) 단일행 서브쿼리로 구하기
select ename, sal from emp where sal >
    (select min(sal) from emp where deptno = 30);      --서브쿼리 950
--2) 다중행 서브쿼리로 구하기    
select ename, sal from emp where sal > any             -- >any: 서브쿼리의 결과 중 하나이상 일치하면 참
    (select sal from emp where deptno = 30);          --다중행 서브쿼리: 결과가 여러개 나옴 
                                                       --  >in은 오류발생 