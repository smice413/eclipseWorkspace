--2022.01.25.02(화)

--조인(join)
-- : 2개 이상의 테이블을 결합해서 정보를 구해오는 것.

--Q. SCOTT 사원(EMP 테이블에 있다)이 소속된 부서명(DEPT 테이블)을 출력하는 SQL문 작성?
--1. 사원테이블(EMP)에서 SCOTT사원의 부서번호를 구한다.
select deptno from emp where ename='SCOTT'; --20
--2. 부서테이블(DEPT)에서 20번 부서의 부서명을 구한다.
select dname from dept where deptno = 20;   --RESEARCH

--CROSS JOIN
select * from dept, emp;   --4* 14 = 56개 데이터 검색
select * from emp, dept;   --14* 4 = 56개 데이터 검색


--CROSS JOIN
--1.등가 조인(Equi Join)
--2.비등가 조인(Non-Equi Join)
--3.자체조인(Self Join)
--4.외부조인(Outer Join)

--1.등가 조인(Equi Join)
-- : 두 테이블에 동일한 컬럼을 기준으로 조인
select * from dept, emp where dept.deptno = emp.deptno;

--Q. SCOTT 사원(EMP 테이블에 있다)이 소속된 부서명(DEPT 테이블)을 출력하는 SQL문 작성?(join이용)
select ename, dname from dept, emp 
    where dept.deptno = emp.deptno and ename = 'SCOTT';

--공통컬럼(deptno)은 테이블.공통컬럼명 형식으로 출력해야 한다.
--공통컬럼이 아닌 컬럼들은 앞에 테이블명을 생략 가능.
select deptno, ename, dname from dept, emp      --공통적인 컬럼인 deptno로 그냥 썼기 때문에 오류발생
    where dept.deptno = emp.deptno and ename = 'SCOTT'; --따라서 dept.deptno 또는 emp.deptno로 써야함
    
select dept.deptno, emp.ename, dept.dname from dept, emp --원칙대로 테이블명을 앞에 모두 붙여도 실행됨.     
    where dept.deptno = emp.deptno and emp.ename = 'SCOTT';
    
--테이블에 별칭 부여하기
--1. 테이블에 대한 별칭이 부여된 다음 부터는 테이블명을 사용할 수 없고
--   별칭명만 사용해야 한다.
--2. 별칭명은 대.소문자 구분하지 않는다.
--3. 공통컬럼(deptno)은 별칭명.공통컬럼명 형식으로 사용해야 한다. ex)D.deptno
--4. 공통컬럼이 아닌 컬럼들은 앞에 별칭명을 생략할 수 있다.

select D.deptno, E.ename, D.dname from dept D, emp E
    where D.deptno = E.deptno and E.ename = 'SCOTT';
    
--오류발생 : 별칭이 부여된 다음 부터는 테이블명을 사용할 수 없다.    
select dept.deptno, e.ename, d.dname from dept D, emp E
    where d.deptno = E.deptno and E.ename = 'SCOTT';       
    
    
--별칭명은 대.소문자 구분하지 않는다.    
select d.deptno, e.ename, d.dname from dept D, emp E
    where d.deptno = E.deptno and E.ename = 'SCOTT';

--일반 컬럼은 앞에 별칭명을 생략할 수 있다.
select d.deptno, ename, dname from dept D, emp E
    where d.deptno = E.deptno and E.ename = 'SCOTT';
    
--2. 비등가 조인
-- : 두 테이블에 동일한 컬럼없이 다른 조건을 사용하여 조인

--Q. 사원테이블에 있는 각 사원들의 급여가 몇 등급인지를 출력하는 SQL문 작성?
-- EMP(SAL) - SALGRADE(GRADE)

select ename, sal, grade from emp, salgrade
    where sal >= losal and sal <= hisal;

select ename, sal, grade from emp, salgrade
    where sal between losal and hisal;

select e.ename, e.sal, grade from emp e, salgrade s
    where sal between losal and hisal;   
    
--3. 자체조인(Self Join)
-- : 한개의 테이블 내에서 컬럼과 컬럼 사이의 관계를 이용해서 조인
--Q. 자체조인(Self Join)을 이용해서 사원 테이블의 각 사원들의 사원명과
--   매니저(=직속상관)를 출력하는 SQL문 작성?
--   EMP(EMPNO) - EMP(MGR) //사원번호와 직속상관 번호 관계

select employee.ename || '의 매니저는' || manager.ename
    from emp employee, emp manager --같은 테이블이지만 cross join하여 별칭을 달리 부여함
    where employee.mgr = manager.empno;
--13개의 검색 결과가 출력된다.
--KING 사원은 직속상관이 없기 때문에 출력되지 않는다.

--4. 외부조인(Outer Join)
-- : 조인 조건을 만족하지 않는 데이터를 출력해주는 조인
-- 1) 테이블을 조인할 때 어느 한쪽의 테이블에는 데이터가 존재하지만,
--    다른 테이블에는 데이터가 존재하지 않는 경우에, 그 데이터가 출력되지 않는
--    문제를 해결하기 위해서 사용되는 조인
-- 2) 정보가 부족한 곳에 (+)를 추가한다.

--Q1. 위의 자체조인(Self Join)의 결과, KING사원은 직속상관이 없기 때문에
--   출력되지 않았는데, KING 사원도 외부조인을 이용해서 출력 하세요.
select employee.ename || '의 매니저는' || manager.ename
    from emp employee, emp manager --같은 테이블이지만 cross join하여 별칭을 달리 부여함
    where employee.mgr = manager.empno(+); --(+)추가 하여 외부조인//manager의 정보가 부족했기 때문에
                                           -- maneger 위치에 (+)를 붙여넣음
                                           
--Q2. 부서테이블(DEPT)의 40번 부서는 조인할 사원테이블(EMP)의 부서번호에는
--    나타나지 않지만, 40번 부서의 부서명을 출력하는 SQL 작성?
--  1) DEPT - EMP 등가 조인 : 40번 부서가 출력안됨
select ename, d.deptno, dname from dept d, emp e
    where d.deptno = e.deptno order by deptno asc; --40번 부서 출력 안됨
--  2) 외부조인: 출력되지 않는 40번 부서를 출력해주는 조인
select ename, d.deptno, dname from dept d, emp e
    where d.deptno = e.deptno(+) order by deptno asc; --40번 부서 출력

---------------------------------------------------------------------------------------------
--ANSI JOIN
-- : ANSI(미국 표준 협회) 표준안에 따라서 만들어진 JOIN 방법

--ANSI CROSS JOIN
select * from dept cross join emp; -- 4 * 14 = 56개 데이터 검색
select * from emp cross join dept; -- 14 * 4 = 56개 데이터 검색

--ANSI INNER JOIN : 등가 조인과 같은 의미를 가지고 있는 조인
--Q. SCOTT 사원이 소속된 부서명을 출력하는 SQL문 작성?
select ename, dname from dept inner join emp
   on dept.deptno = emp.deptno where ename = 'SCOTT';
   
--using을 이용해서 조인
select ename, dname from dept inner join emp
   using (deptno) where ename = 'SCOTT';

--ANSI NATURAL JOIN
-- : DEPT와 EMP 테이블 사이의 공통 컬럼이 같다는 의미를 가지고 있음.
select ename, dname from dept natural join emp where ename='SCOTT';