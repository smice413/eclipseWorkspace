--2022.01.25.01 (ȭ)

--4. ����ȯ �Լ�: to_char(), to_date(), to_number()

--1. to_char() :��¥��, ������ �����͸� ���������� ��ȯ�����ִ� �Լ�
--   to_char(��¥ ������, '�������')

--1) ��¥�� �����͸� ���������� ��ȯ
--Q. ���� �ý����� ��¥�� ��, ��, ��, ��, ��, ��, ���Ϸ� ���
select sysdate from dual;   --22/01/25

select sysdate, to_char(sysdate, 'yyyy-mm-dd am hh:mi:ss day') from dual;
select sysdate, to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss dy') from dual;

--Q. ��� ���̺��� �� ������� �Ի����� ��, ��, ��, ��, ��, ��, ������ ����ϴ� SQL�� �ۼ�?
select hiredate, to_char(hiredate, 'yyyy-mm-dd hh24:mi:ss day') from emp;

--2) ������ �����͸� ���������� ��ȯ
-- to_char(���� ������, '���б�ȣ')
--Q. ���� 1230000�� 3�ڸ��� �޸��� �����ؼ� ���
select 1230000 from dual;

--0���� �ڸ����� �����ϸ�, �������� ���̰� 9�ڸ��� ���� ������ 0���� ä���.
select 1230000, to_char(1230000, '000,000,000') from dual; --  001,230,000

--9�� �ڸ����� �����ϸ�, �������� ���̰� 9�ڸ��� ���� �ʾƵ� 9�� ä����X
select 1230000, to_char(1230000, '999,999,999') from dual; --  1,230,000

--Q. ������̺��� �� ������� �޿��� 3�ڸ��� �޸�(,)�� �����ؼ� ����ϴ� SQL�� �ۼ�?
select ename, sal, to_char(sal, '9,999') from emp;
select ename, sal, to_char(sal, 'L9,999') from emp;
select ename, sal, to_char(sal, '9,999L') from emp;

--2. to_date() : ���ڸ� ��¥������ ��ȯ ���ִ� �Լ�
-- to_date( '����', '��¥ format')
--Q. 2022�� 1�� 1�� ���� ������� ����� �ϼ��� ���ϴ� SQL�� �ۼ�?
select sysdate-'2022/01/01' from dual; --�����߻�: ���� ��¥���� �ƴϰ� �������̱� ������ ��ȯ�ؾ���

select sysdate-to_date('2022/01/01', 'yyyy/mm/dd') from dual; --24.43568287037037037037
select round(sysdate-to_date('2022/01/01', 'yyyy/mm/dd')) from dual;--24

--Q. 2022�� 12�� 25�� ũ������������ ���� �ϼ��� ���ϴ� SQL�� �ۼ�?
select round(to_date('2022/12/25', 'yyyy/mm/dd')-sysdate) from dual;--334

--3. to_number() : �������� ���������� ��ȯ ���ִ� �Լ�
--   to_number('���� ������', '���б�ȣ')
select '20,000' - '10,000' from dual; --���� �߻�: �������̱� ������ ������� ����
select to_number('20,000','99,999') - to_number('10,000','99,999') from dual;--���������� ����ȯ

---------------------------------------------------------------------------------------------
--nvl() : null���� �ٸ� ������ ��ȯ���ִ� �Լ�
--1. null ���� �������� ���� ���� �ǹ�
--2. null ���� �������(+,-,*,/)�� ���� �ʴ´�.

--Q. ��� ���̺� �ִ� �� ������� ������ ����ϴ� SQL�� �ۼ�?
-- ���� = �޿�(SAL)*12 + COMM
-- nvl(comm, 0) : comm�� null���� �����͸� 0���� ��ȯ
select ename, sal*12 + nvl(comm, 0) as "����" from emp;
----------------------------------------------------------------------------------------------

--decode() :swich~case ������ ����
--decode(�÷���, ��1, ���1,
--              ��2, ���2,
--              ��3, ���3,
--              ..........)

--Q.������̺��� �μ���ȣ(deptno)�� �μ������� �ٲ㼭 ����ϴ� SQL�� �ۼ�?
select ename, deptno, decode(deptno, 10, 'ACCOUNTING', 
                                     20, 'RESEARCH',
                                     30, 'SALES',
                                     40, 'OPERATIONS') as dname from emp;
                                     
---------------------------------------------------------------------------------------------
--case() : if~else if ���� ����
--case when ����1 then ���1
--     when ����1 then ���1
--     else ���3
--end

--Q. ������̺��� �μ���ȣ(deptno)�� �μ������� �ٲ㼭 ����ϴ� SQL�� �ۼ�?
select ename, deptno, case when deptno=10 then 'ACCOUNTING'
                           when deptno=20 then 'RESEARCH'
                           when deptno=30 then 'SALES'
                           when deptno=40 then 'OPERATIONS'
                      end as dname from emp;
                      
---------------------------------------------------------------------------------------------
--�׷��Լ�: �ϳ� �̻��� �����͸� �׷����� ��� ������ �����ϰ�
--         �ϳ��� ����� ó�����ִ� �Լ�
-- sum(): ���� �����ִ� �Լ�
select sum(sal) from emp;       --�޿��� ��
select sum(comm) from emp;      --comm�� ��, null���� ���ܵ�
select sum(ename) from emp;     --���� �߻�: ���ڵ������̱� ����

select sum(sal), sum(comm) from emp; --�׷��Լ������� ���� ��밡��
select sal, sum(sal) from emp;       --�Ϲ��÷�(14�� ���)�� �׷��Լ�(1�� ���)�� ���� ���Ұ���

select sum(sal) from emp where deptno = 10; --10�� �μ� �޿� ���� 8750
select sum(sal) from emp where deptno = 20; --20�� �μ� �޿� ���� 10875
select sum(sal) from emp where deptno = 30; --30�� �μ� �޿� ���� 9400
select sum(sal) from emp where deptno = 40; --40�� �μ� �޿� ���� null

--avg(): ��հ��� �����ִ� �Լ�
select avg(sal) from emp;
select avg(sal), avg(comm) from emp;
select sum(sal), avg(sal) from emp where deptno = 10; --�׷��Լ����� ��밡��

--max(): �ִ밪�� �����ִ� �Լ�
select max(sal) from emp; --5000
select ename, max(sal) from emp; --���� �߻�: �Ϲ��÷��� �׷��Լ� ��� ��� ����(�������� ����ؾ���)
select max(sal) from emp where deptno = 10; --5000
select max(sal) from emp where deptno = 20; --3000
select max(sal) from emp where deptno = 30; --2850

--Q. ������̺��� ���� �ֱٿ� �Ի��� �Ի����� ����ϴ� SQL�� �ۼ�?
select max(hiredate) from emp; --87/07/13


--      Q1. ��� ���̺�(EMP)���� ���� �ֱٿ� �Ի��� ������� ��� 
--	         �ϴ� SQL���� �ۼ� �ϼ���?
--
--      Q2. ��� ���̺�(EMP)���� �ִ� �޿��� �޴� ������ �ִ�޿�
--           �ݾ��� ����ϴ� SQL���� �ۼ� �ϼ���?

--  �������� ����ؾ���    
     Ans1. SQL> select ename, hiredate from emp where hiredate=
		(select max(hiredate) from emp); 

     Ans2. SQL> select ename, sal from emp where sal=
		(select max(sal) from emp);
        
--min(): �ּҰ��� �����ִ� �Լ�
select min(sal) from emp;                       --800
select min(sal) from emp where deptno = 10;     --1300
select min(sal) from emp where deptno = 20;     --800
select min(sal) from emp where deptno = 30;     --950

--Q. ��� ���̺��� ���� ���� �Ի��� �Ի����� ���ϴ� SQL�� �ۼ�?
select min(hiredate) from emp;           --80/12/17

select min(ename) from emp;              --ADAMS
select ename from emp order by ename asc;-- �������� ����(������ ����)

select max(ename) from emp;              --WARD
select max(ename) from emp order by ename desc;--�������� ����(�������� ����)

select sum(sal), avg(sal), max(sal), min(sal) from emp;

--count(): �� ������ ������ �����ִ� �Լ�
select count(sal) from emp; --14
select count(mgr) from emp; --13 null���� ������ ���� �ȵ�
select count(comm) from emp; --4 null���� ������ ���� �ȵ�
select count(empno) from emp;--14 : empno�÷��� primary key(��������)�� �����Ǿ��ִ�.
                             --     ���� �ݵ�� �ߺ����� ���� �����Ͱ� �� �ִ�.
select count(*) from emp; --14                             

--Q. ������̺��� job ����
select count(job) from emp; --14: �ߺ� �����͵� ������ �����Ѵ�.
select distinct job from emp; --�ߺ��� ������ job��� ���
select count(distinct job) from emp; --5: �ߺ��� ������ job���� ���

--Q. ���� �ֱٿ� �Ի��� ����� �Ի��ϰ� ���� ���� �Ի��� ����� �Ի����� ���ϴ� SQL�� �ۼ�?
select max(hiredate) �ֱ��Ի�, min(hiredate) �����Ի� from emp;

--Q. 30�� �μ� �Ҽ� ��� �߿��� Ŀ�̼��� �޴� ������� ���ϴ� SQL�� �ۼ�?
select count(comm) from emp where deptno = 30; --4

-----------------------------------------------------------------------------------------
--group by �� 
--:  Ư�� �÷��� �������� ���̺� �����ϴ� �����͸� �׷����� �����Ͽ� ó���ϴ� ����

--Q. �� �μ�(10,20,30)�� �޿��� ��, ��ձ޿�, �ִ�޿�, �ּұ޿��� ���ϴ� SQL�� �ۼ�?
select sum(sal), avg(sal), max(sal), min(sal) from emp where deptno = 10;
select sum(sal), avg(sal), max(sal), min(sal) from emp where deptno = 20;
select sum(sal), avg(sal), max(sal), min(sal) from emp where deptno = 30;
--3���� ��� ����� �� �ִ� ���� group by�� ���� 1�ٷ� ó����
select deptno, sum(sal),avg(sal), max(sal), min(sal) from emp
    group by deptno;
    
--Q. JOB�÷��� �������� �޿��� ��, ��ձ޿�, �ִ�޿�, �ּұ޿��� ���ϴ� SQL�� �ۼ�?
select job, sum(sal), avg(sal), max(sal), min(sal) from emp
    group by job;
    
--Q. �� �μ�(10,20,30)�� ������� Ŀ�̼��� �޴� ����� ���� ���ϴ� SQL�� �ۼ�?
select deptno, count(*) �����, count(comm) Ŀ�̼� from emp
    group by deptno order by deptno asc;
    
--having ������
--: group by ���� ���Ǵ� ��쿡 ������ ������ ���ϱ� ���ؼ��� where������
--  ��ſ� having �������� ����ؾ� �Ѵ�.

--Q. �� �μ��� ��ձ޿� �ݾ��� 2000 �̻��� �μ��� ����ϴ� SQL�� �ۼ�?
select deptno, avg(sal) from emp group by deptno;

select deptno, avg(sal) from emp group by deptno
    where avg(sal) >= 2000;     --�����߻�
    
select deptno, avg(sal) from emp group by deptno
    having avg(sal) >= 2000;    --�������
    
--Q. �� �μ��� �ִ�޿� �ݾ��� 2900 �̻��� �μ��� ����ϴ� SQL�� �ۼ�?
select deptno, max(sal) from emp group by deptno
    having max(sal) >=2900;