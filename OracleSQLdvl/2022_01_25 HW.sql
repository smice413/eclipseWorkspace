--2022.01.25.HW (ȭ)

--       Q1. ������ MANAGER�� ����� �̸�, �μ����� ����ϴ� SQL����
--           �ۼ� �ϼ���? (JOIN�� ����Ͽ� ó��)
select ename, dname, job from emp e, dept d
    where e.deptno = d.deptno and job = 'MANAGER';

--       Q2. �Ŵ����� KING(=���� ����� KING)�� ������� �̸��� ������ ����ϴ� SQL�� �ۼ�?
select ename, job from emp where mgr = (select empno from emp where ename = 'KING');

--       Q3. SCOTT�� ������ �ٹ������� �ٹ��ϴ� ����� �̸��� ����ϴ� SQL�� �ۼ�?
select ename, deptno from emp where deptno = (select deptno from emp where ename = 'SCOTT')
    order by ename asc;
    
    
    
--���.


--       Q1. ������ MANAGER�� ����� �̸�, �μ����� ����ϴ� SQL����
--             �ۼ� �ϼ���? (JOIN�� ����Ͽ� ó��)
--   
--       Q2. �Ŵ����� KING �� ������� �̸��� ������ ����ϴ� SQL�� �ۼ�?
--
--       Q3. SCOTT�� ������ �ٹ������� �ٹ��ϴ� ����� �̸��� ����ϴ� SQL�� �ۼ�?

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