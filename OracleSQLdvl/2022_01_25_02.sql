--2022.01.25.02(ȭ)

--����(join)
-- : 2�� �̻��� ���̺��� �����ؼ� ������ ���ؿ��� ��.

--Q. SCOTT ���(EMP ���̺� �ִ�)�� �Ҽӵ� �μ���(DEPT ���̺�)�� ����ϴ� SQL�� �ۼ�?
--1. ������̺�(EMP)���� SCOTT����� �μ���ȣ�� ���Ѵ�.
select deptno from emp where ename='SCOTT'; --20
--2. �μ����̺�(DEPT)���� 20�� �μ��� �μ����� ���Ѵ�.
select dname from dept where deptno = 20;   --RESEARCH

--CROSS JOIN
select * from dept, emp;   --4* 14 = 56�� ������ �˻�
select * from emp, dept;   --14* 4 = 56�� ������ �˻�


--CROSS JOIN
--1.� ����(Equi Join)
--2.�� ����(Non-Equi Join)
--3.��ü����(Self Join)
--4.�ܺ�����(Outer Join)

--1.� ����(Equi Join)
-- : �� ���̺� ������ �÷��� �������� ����
select * from dept, emp where dept.deptno = emp.deptno;

--Q. SCOTT ���(EMP ���̺� �ִ�)�� �Ҽӵ� �μ���(DEPT ���̺�)�� ����ϴ� SQL�� �ۼ�?(join�̿�)
select ename, dname from dept, emp 
    where dept.deptno = emp.deptno and ename = 'SCOTT';

--�����÷�(deptno)�� ���̺�.�����÷��� �������� ����ؾ� �Ѵ�.
--�����÷��� �ƴ� �÷����� �տ� ���̺���� ���� ����.
select deptno, ename, dname from dept, emp      --�������� �÷��� deptno�� �׳� ��� ������ �����߻�
    where dept.deptno = emp.deptno and ename = 'SCOTT'; --���� dept.deptno �Ǵ� emp.deptno�� �����
    
select dept.deptno, emp.ename, dept.dname from dept, emp --��Ģ��� ���̺���� �տ� ��� �ٿ��� �����.     
    where dept.deptno = emp.deptno and emp.ename = 'SCOTT';
    
--���̺� ��Ī �ο��ϱ�
--1. ���̺� ���� ��Ī�� �ο��� ���� ���ʹ� ���̺���� ����� �� ����
--   ��Ī�� ����ؾ� �Ѵ�.
--2. ��Ī���� ��.�ҹ��� �������� �ʴ´�.
--3. �����÷�(deptno)�� ��Ī��.�����÷��� �������� ����ؾ� �Ѵ�. ex)D.deptno
--4. �����÷��� �ƴ� �÷����� �տ� ��Ī���� ������ �� �ִ�.

select D.deptno, E.ename, D.dname from dept D, emp E
    where D.deptno = E.deptno and E.ename = 'SCOTT';
    
--�����߻� : ��Ī�� �ο��� ���� ���ʹ� ���̺���� ����� �� ����.    
select dept.deptno, e.ename, d.dname from dept D, emp E
    where d.deptno = E.deptno and E.ename = 'SCOTT';       
    
    
--��Ī���� ��.�ҹ��� �������� �ʴ´�.    
select d.deptno, e.ename, d.dname from dept D, emp E
    where d.deptno = E.deptno and E.ename = 'SCOTT';

--�Ϲ� �÷��� �տ� ��Ī���� ������ �� �ִ�.
select d.deptno, ename, dname from dept D, emp E
    where d.deptno = E.deptno and E.ename = 'SCOTT';
    
--2. �� ����
-- : �� ���̺� ������ �÷����� �ٸ� ������ ����Ͽ� ����

--Q. ������̺� �ִ� �� ������� �޿��� �� ��������� ����ϴ� SQL�� �ۼ�?
-- EMP(SAL) - SALGRADE(GRADE)

select ename, sal, grade from emp, salgrade
    where sal >= losal and sal <= hisal;

select ename, sal, grade from emp, salgrade
    where sal between losal and hisal;

select e.ename, e.sal, grade from emp e, salgrade s
    where sal between losal and hisal;   
    
--3. ��ü����(Self Join)
-- : �Ѱ��� ���̺� ������ �÷��� �÷� ������ ���踦 �̿��ؼ� ����
--Q. ��ü����(Self Join)�� �̿��ؼ� ��� ���̺��� �� ������� ������
--   �Ŵ���(=���ӻ��)�� ����ϴ� SQL�� �ۼ�?
--   EMP(EMPNO) - EMP(MGR) //�����ȣ�� ���ӻ�� ��ȣ ����

select employee.ename || '�� �Ŵ�����' || manager.ename
    from emp employee, emp manager --���� ���̺������� cross join�Ͽ� ��Ī�� �޸� �ο���
    where employee.mgr = manager.empno;
--13���� �˻� ����� ��µȴ�.
--KING ����� ���ӻ���� ���� ������ ��µ��� �ʴ´�.

--4. �ܺ�����(Outer Join)
-- : ���� ������ �������� �ʴ� �����͸� ������ִ� ����
-- 1) ���̺��� ������ �� ��� ������ ���̺��� �����Ͱ� ����������,
--    �ٸ� ���̺��� �����Ͱ� �������� �ʴ� ��쿡, �� �����Ͱ� ��µ��� �ʴ�
--    ������ �ذ��ϱ� ���ؼ� ���Ǵ� ����
-- 2) ������ ������ ���� (+)�� �߰��Ѵ�.

--Q1. ���� ��ü����(Self Join)�� ���, KING����� ���ӻ���� ���� ������
--   ��µ��� �ʾҴµ�, KING ����� �ܺ������� �̿��ؼ� ��� �ϼ���.
select employee.ename || '�� �Ŵ�����' || manager.ename
    from emp employee, emp manager --���� ���̺������� cross join�Ͽ� ��Ī�� �޸� �ο���
    where employee.mgr = manager.empno(+); --(+)�߰� �Ͽ� �ܺ�����//manager�� ������ �����߱� ������
                                           -- maneger ��ġ�� (+)�� �ٿ�����
                                           
--Q2. �μ����̺�(DEPT)�� 40�� �μ��� ������ ������̺�(EMP)�� �μ���ȣ����
--    ��Ÿ���� ������, 40�� �μ��� �μ����� ����ϴ� SQL �ۼ�?
--  1) DEPT - EMP � ���� : 40�� �μ��� ��¾ȵ�
select ename, d.deptno, dname from dept d, emp e
    where d.deptno = e.deptno order by deptno asc; --40�� �μ� ��� �ȵ�
--  2) �ܺ�����: ��µ��� �ʴ� 40�� �μ��� ������ִ� ����
select ename, d.deptno, dname from dept d, emp e
    where d.deptno = e.deptno(+) order by deptno asc; --40�� �μ� ���

---------------------------------------------------------------------------------------------
--ANSI JOIN
-- : ANSI(�̱� ǥ�� ��ȸ) ǥ�ؾȿ� ���� ������� JOIN ���

--ANSI CROSS JOIN
select * from dept cross join emp; -- 4 * 14 = 56�� ������ �˻�
select * from emp cross join dept; -- 14 * 4 = 56�� ������ �˻�

--ANSI INNER JOIN : � ���ΰ� ���� �ǹ̸� ������ �ִ� ����
--Q. SCOTT ����� �Ҽӵ� �μ����� ����ϴ� SQL�� �ۼ�?
select ename, dname from dept inner join emp
   on dept.deptno = emp.deptno where ename = 'SCOTT';
   
--using�� �̿��ؼ� ����
select ename, dname from dept inner join emp
   using (deptno) where ename = 'SCOTT';

--ANSI NATURAL JOIN
-- : DEPT�� EMP ���̺� ������ ���� �÷��� ���ٴ� �ǹ̸� ������ ����.
select ename, dname from dept natural join emp where ename='SCOTT';