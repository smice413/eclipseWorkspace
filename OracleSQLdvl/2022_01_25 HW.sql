--2022.01.25.HW (화)

--       Q1. 직급이 MANAGER인 사원의 이름, 부서명을 출력하는 SQL문을
--           작성 하세요? (JOIN을 사용하여 처리)
select ename, dname, job from emp e, dept d
    where e.deptno = d.deptno and job = 'MANAGER';

--       Q2. 매니저가 KING(=직속 상관이 KING)인 사원들의 이름과 직급을 출력하는 SQL문 작성?
select ename, job from emp where mgr = (select empno from emp where ename = 'KING');

--       Q3. SCOTT과 동일한 근무지에서 근무하는 사원의 이름을 출력하는 SQL문 작성?
select ename, deptno from emp where deptno = (select deptno from emp where ename = 'SCOTT')
    order by ename asc;
    
    
    
--답안.


--       Q1. 직급이 MANAGER인 사원의 이름, 부서명을 출력하는 SQL문을
--             작성 하세요? (JOIN을 사용하여 처리)
--   
--       Q2. 매니저가 KING 인 사원들의 이름과 직급을 출력하는 SQL문 작성?
--
--       Q3. SCOTT과 동일한 근무지에서 근무하는 사원의 이름을 출력하는 SQL문 작성?

Ans 1. 
        SQL> select ename, dname from emp, dept 
                  where emp.deptno=dept.deptno  and  job='MANAGER'; 

       SQL> select ename, dname from emp inner join dept 
                     on emp.deptno=dept.deptno  where  job='MANAGER'; 

       SQL> select ename, dname from emp inner join dept 
                     using(deptno)  where  job='MANAGER'; 

       SQL> select ename, dname from emp natural join dept 
                     where job='MANAGER'; 

Ans 2.
        SQL>  select employee.ename, employee.job 
                   from emp employee, emp manager
                   where employee.mgr=manager.empno and manager.ename='KING';

        SQL> select ename, job from emp where mgr = 
                 (select empno from emp where ename='KING');

Ans 3.
        SQL> select deptno, ename from emp 
                   where deptno = (select deptno from emp where ename = 'SCOTT'); 