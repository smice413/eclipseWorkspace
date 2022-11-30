--2022.01.24(��)
select * from emp;
--null �� �˻�
--EMP ���̺�: MGR�÷�, COMM�÷�


--Q. MGR �÷��� null���� �����͸� �˻�?
select ename, job, mgr from emp where mgr = null; --�˻��ȵ�
select ename, job, mgr from emp where mgr = '';   --�˻��ȵ�

select ename, job, mgr from emp where mgr is null;--����


--Q. MGR �÷��� null���� �ƴ� �����͸� �˻�?
select ename, job, mgr from emp where mgr is not null;--����

--Q.COMM �÷��� null���� �����͸� �˻�?
select ename, job, mgr from emp where comm = null; --�˻��ȵ�
select ename, job, mgr from emp where comm = '';   --�˻��ȵ�
select ename, job, mgr from emp where comm is null;--����

--Q.COMM �÷��� null���� �ƴ� �����͸� �˻�?
select ename, job, mgr from emp where comm is not null; --����



---------------------------------------------------------------------------------------
--���� : order by �÷��� ���Ĺ��(asc or desc)
--���Ĺ��: ��������(ascending), ��������(descending)

--         ��������                                       ��������
---------------------------------------------------------------------------
--����: ���� ���ں��� ū���ڼ����� ����(1,2,3,...)ū���ں��� ���� ���� ������ ����
--����: ������ ����(a,b,c..)                       �������� ����(z,y,x..)
--��¥: ������¥ ������ ����                        ������¥ ������ ����
--NULL: NULL���� ���� �������� ���                 NULL���� ���� ���� ���

--1. ���� ������ ���� 
--Q. ��� ���̺��� �޿��� �������� �������� ����: ���� ���ں��� ū���� ������ ����
select ename, sal from emp order by sal asc;

--���Ĺ��(asc, desc)�� �����Ǹ�, �⺻ ���� ����� ���������̴�.
select ename, sal from emp order by sal; --���Ĺ��(asc) ����

--Q. ��� ���̺��� �޿��� �������� �������� ����: ū���ں��� �������� ������ ����
select ename, sal from emp order by sal desc;

--2. ���� ������ ����
--Q. ��� ���̺��� ������� �������� �������� ���� : ������ ����
select ename from emp order by ename asc;
select ename from emp order by ename; --���Ĺ��(asc)����
--Q. ��� ���̺��� ������� �������� �������� ���� : �������� ����
select ename from emp order by ename desc;

--3. ��¥ ������ ����
--Q. ��� ���̺��� �Ի����� �������� �������� ���� : ������¥ ������ ����
select hiredate from emp order by hiredate asc;

--Q. ��� ���̺��� �Ի����� �������� �������� ���� : ������¥ ������ ����
select hiredate from emp order by hiredate desc;

--4. NULL ����
--1) �������� ���� : NULL ���� ���� �������� ���
--2) �������� ���� : NULL ���� ���� ���� ���
--Q. MGR �÷��� �������� �������� ����
select mgr from emp order by mgr asc; --NULL���� ���� �������� ���

--Q. MGR �÷��� �������� �������� ����
select mgr from emp order by mgr desc; --NULL���� ���� ���� ���

--Q. COMM �÷��� �������� �������� ����
select comm from emp order by comm asc; --NULL���� ���� �������� ���

--Q. COMM �÷��� �������� �������� ����
select comm from emp order by comm desc; --NULL���� ���� ���� ���

--������ �����ϱ�
--1. �ѹ� ���������� ������ ����� ������ �����Ͱ� ���� ��쿡�� �ѹ� ��
--   ������ �ؾ� �Ѵ�.
--2. �ι�° ���� ������ �ѹ� ���������� ������ ����� ���� �����͸� �ι�°
--   ���� ������ ���� �޴´�.
--3. ��� �Խ����� ����� ��쿡 �ַ� ����Ѵ�.

--Q. ��� ���̺��� �޿��� �������� �������� ������ �Ѵ�. �̶� ������ �޿���
--   �޴� ������� ������� �������� �������� �����ؼ� ����ϴ� SQL�� �ۼ�?
select ename, sal from emp order by sal desc;--3000(2��), 1250(2��)
--������ �޿��� �޴� FORD�� SCOTT�� ���������̰� WARD�� MARTIN�� ������������ ��µǾ���.
select ename, sal from emp order by sal desc, ename asc;

--���� ����
--Q1. ��� ���̺��� �Ի����� �������� ������������ �����Ͽ� ����ϵ�, �����ȣ
--    �����, ����, �Ի��� �÷��� ����ϴ� SQL���� �ۼ�?
select empno, ename, job, hiredate from emp order by hiredate asc;

--Q2. ��� ���̺��� �����ȣ�� �������� ������������ �����Ͽ� �����ȣ��
--    ����� �÷��� ����ϴ� SQL���� �ۼ�?
select empno, ename from emp order by empno desc;

--Q3. �μ���ȣ�� ���� ������� ����ϵ�, ������ �μ����� ����� ����� ��쿡��
--    �ֱٿ� �Ի��� ������� �����ȣ , �Ի���, �����, �޿������� ����ϴ�
--    SQL�� �ۼ�?
select empno, hiredate, ename, sal, deptno from emp order by deptno asc, hiredate desc;

