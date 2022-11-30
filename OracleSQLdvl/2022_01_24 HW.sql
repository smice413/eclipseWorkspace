--2022.01.24 과제

--     Q3. 사원 테이블(EMP)에서 가장 최근에 입사한 사원명을 출력 하는 
--           SQL문을 작성 하세요?
select ename, hiredate from emp order by hiredate desc;
select ename, hiredate from emp where hiredate = (select max(hiredate) from emp);

--
--     Q4. 사원 테이블(EMP)에서 최대 급여를 받는 사원명과 최대급여
--           금액을 출력하는 SQL문을 작성 하세요?
select ename, sal from emp where sal = (select max(sal) from emp);

--해설
--      Q1. 사원 테이블(EMP)에서 가장 최근에 입사한 사원명을 출력 
--	         하는 SQL문을 작성 하세요?
--
--      Q2. 사원 테이블(EMP)에서 최대 급여를 받는 사원명과 최대급여
--           금액을 출력하는 SQL문을 작성 하세요?
--    
     Ans1. SQL> select ename, hiredate from emp where hiredate=
		(select max(hiredate) from emp);

     Ans2. SQL> select ename, sal from emp where sal=
		(select max(sal) from emp);
