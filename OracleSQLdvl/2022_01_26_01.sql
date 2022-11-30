--2022.01.26.01 (��)

--ANSI OUTER JOIN
--����: select * from table1 [ left | right | full ] outer join table2

--1. dept01 ���̺� ����
create table dept01(deptno number(2), dname varchar2(14));
insert into dept01 values(10, 'ACCOUNTING');
insert into dept01 values(20, 'RESEARCH');
select * from dept01;

--2. dept02 ���̺� ����
create table dept02(deptno number(2), dname varchar2(14));
insert into dept02 values(10, 'ACCOUNTING');
insert into dept02 values(30, 'SALES');
select * from dept02;

--3. left outer join : dept01 ���̺� ������ ��µ�
select * from dept01 left outer join dept02 using (deptno);

--4. right outer join : dept02 ���̺� ������ ��µ�
select * from dept01 right outer join dept02 using (deptno);

--5. full outer join : dept01, dept02 ���̺� ��� ���� ��µ�
select * from dept01 full outer join dept02 using (deptno);

-------------------------------------------------------------------------------------
--���� ����
--Q. SCOTT ����� �Ҽӵ� �μ����� ����ϴ� SQL�� �ۼ�?

--1)��� ���̺��� SCOTT ����� �μ���ȣ�� ���Ѵ�.
select deptno from emp where ename = 'SCOTT';  --20
--2)�μ� ���̺��� 20�� �μ��� �μ����� ���Ѵ�.
select dname from dept where deptno = 20;      --RESEARCH

-- ���������� ���ϱ�
select dname from dept where deptno =               --��������
    (select deptno from emp where ename = 'SCOTT'); --��������
    
--join���� ���ϱ�
select dname from dept, emp where dept.deptno = emp.deptno and ename = 'SCOTT';
select dname from dept inner join emp on dept.deptno = emp.deptno where ename = 'SCOTT';
select dname from dept inner join emp using (deptno) where ename = 'SCOTT';
select dname from dept natural join emp where ename = 'SCOTT';


--1. ���� �� �������� : 
-- 1)���������� �˻� ����� 1���� ��ȯ�Ǵ� ����
-- 2)���������� where ���������� �� ������(=, >, >=, <, <=, ! = )�� ��밡��

--Q. ��� ���̺��� ���� �ֱٿ� �Ի��� ������� ����ϴ� SQL�� �ۼ�?
select ename, hiredate from emp where hiredate = (select max(hiredate) from emp);

--Q. ��� ���̺��� �ִ� �޿��� �޴� ������ �ִ�޿� �ݾ��� ����ϴ� SQL�� �ۼ�?
select ename, max(sal) from emp; --�����߻�: �׷��Լ��� �Ϲ��÷� ���� ���X
select ename, sal from emp where sal=
    (select max(sal) from emp);  --KING 5000
    
--Q. ���ӻ��(MGR)�� KING�� ����� ������ �޿��� ����ϴ� SQL�� �ۼ�?
select ename, sal from emp where mgr =                  --��������
    (select empno from emp where ename = 'KING');       --�������� 7839
    
    
--2. ������ ��������
-- 1) ������������ ��ȯ�Ǵ� �˻� ����� 2�� �̻��� ��������
-- 2) ���� ������ where ���������� ������ ������(in, all, any...)�� ����ؾ� �Ѵ�.

-- in ������
-- : ���������� �˻� ��� �߿��� �ϳ��� ��ġ�Ǹ� ���̵ȴ�.
--Q. �޿��� 3000�̻� �޴� ����� �Ҽӵ� �μ��� ������ �μ����� �ٹ��ϴ� �������
--   ������ ����ϴ� SQL�� �ۼ�?

-- �� �μ��� �ִ�޿� �ݾ� ���ϱ�
select deptno, max(sal) from emp group by deptno;
--30	2850
--20	3000
--10	5000
select ename, sal, deptno from emp where deptno in        --��������(10�� 20�� �Ѵ� �˻�����)
    (select distinct(deptno) from emp where sal >= 3000); --������ �������� 10, 20
    
--all ������
-- : ���� ������ �� ������ ���������� �˻� ����� ��� ���� ��ġ�ϸ� ���̵ȴ�.

--Q. 30�� �μ��� �Ҽӵ� ��� �߿��� �޿��� ���� ���� �޴� ������� �� ����
--    �޿��� �޴� ����� �̸��� �޿��� ����ϴ� SQL�� �ۼ�?
--1) ������ ���������� ���ϱ�
select ename, sal from emp where sal >
    (select max(sal) from emp where deptno = 30);         --�������� 2850
    
--2) ������ ���������� ���ϱ�
select ename, sal from emp where sal >all               -- >all: ���������� ����� ��� ������ �ͺ��� ũ��
    (select sal from emp where deptno = 30);            --������ ��������: ����� ������ ����  
    
--any ������
-- : ���������� �� ������ ���������� �˻� ����� �ϳ� �̻��� ��ġ�Ǹ� ���� �ȴ�.

--Q. �μ���ȣ�� 30���� ������� �޿��� ���� ���� �޿�(950)���� ���� �޿��� �޴�
--   ������ �޿��� ����ϴ� SQL�� �ۼ�?
--1) ������ ���������� ���ϱ�
select ename, sal from emp where sal >
    (select min(sal) from emp where deptno = 30);      --�������� 950
--2) ������ ���������� ���ϱ�    
select ename, sal from emp where sal > any             -- >any: ���������� ��� �� �ϳ��̻� ��ġ�ϸ� ��
    (select sal from emp where deptno = 30);          --������ ��������: ����� ������ ���� 
                                                       --  >in�� �����߻� 