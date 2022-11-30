--2022.01.21 과제

--과제.
--      Q1. 사원테이블(EMP)에서 입사일(HIREDATE)을 4자리 연도로 출력 
--           되도록 SQL문을 작성하세요? (ex. 1980/01/01)
select * from emp;
select ename,hiredate,to_char(hiredate, 'yyyy/mm/dd') as "HIREDATE01" from emp;

--
--     Q2. 사원테이블(EMP)에서 MGR컬럼의  값이  null 인 데이터의 MGR의 
--          값을  CEO 로  출력하는 SQL문을 작성 하세요?
select * from emp;
select ename,mgr,nvl(to_char(MGR), 'CEO') as "MGR01" from emp;


--답안.

--     Q1. 사원테이블(EMP)에서 입사일(HIREDATE)을 4자리 연도로 출력                                
--           되도록 SQL문을 작성하세요? (ex. 1980/01/01)
--
--     Q2. 사원테이블(EMP)에서 MGR컬럼의  값이  null 인 데이터의 MGR                              
--          컬럼의 값을  CEO 로  출력하는 SQL문을 작성 하세요?     


     Ans1. SQL> select  to_char(hiredate,'YYYY/MM/DD') from emp;

     Ans2. SQL> select ename, nvl(to_char(mgr,'9999'), 'CEO')  	         	                               
                    as	 MANAGER  from emp where mgr  is  null;



--
--     Q3. 사원 테이블(EMP)에서 가장 최근에 입사한 사원명을 출력 하는 
--           SQL문을 작성 하세요?
--
--     Q4. 사원 테이블(EMP)에서 최대 급여를 받는 사원명과 최대급여
--           금액을 출력하는 SQL문을 작성 하세요?