-- 2022.01.21(��)
select * from sys.tab;
select * from tab;

--dept ���̺� ����
describe dept;
desc dept;

--dept������ �˻� : SQL���� ��, �ҹ��ڸ� �������� �ʴ´�.
select * from dept;
SELECT * FROM DEPT;

--emp ���̺� ����
desc emp;

--emp ���̺� ������ �˻�
select * from emp;

-- ����Ŭ ������ Ÿ��
--1. ���� ������
--   number(n) : number(2) ���� 2�ڸ����� �����϶�� �ǹ�
--   number(n1, n2) : n1�� ��ü �ڸ���
--                    n2�� �Ҽ����� �Ҵ�� �ڸ���

--2. ���� ������
--   char() : ���� ���� ������
--            �ִ� 2000byte���� ���� ������.
--   varchar2() : ���� ���� ������
--                �ִ� 4000byte���� ���� ������.
--   long : 2GB ���� ���� ����.
--          long������ ������ �÷��� �˻���� ���� ����.
--          (����: �Ѱ��� �����ʹ� 2GB���� �����ؼ� �ʹ� �����Ͱ� ũ�� ������)



--3. ��¥ ������
--    date : ��/��/�� ����
--    timestamp: ��/��/��/��/��/�� ����


-- select SQL��
select * from dept;--*�� ��ü �÷��� �˻��ϰڴٴ� �ǹ�

select loc,deptno, dname from dept;--�÷� �� ������� �˻���

select * from emp;

select empno, ename, sal from emp;


--��� ������ : +,-,*,/
select sal + comm from emp;
select sal - 100 from emp;
select sal * 100 from emp;
select sal / 100 from emp;

--Q. ������̺�(EMP)�� �Ҽӵ� ������� ������ ���غ���?
--    ���� = �޿�(SAL) * 12 + Ŀ�̼�(COMM)

select ename,job,sal,sal*12,sal*12+comm from emp;

-- NULL
--1. �������� ���� ���� �ǹ�
--2. NULL ���� ��������� �� �� ����.
--3. NULL ���� ��
--   EX) EMP ���̺� : MGR �÷�
--                   COMM �÷�

--���� �ذ� ��� 
-- NVL(�÷�, ��ȯ�� ��) : NULL ���� �ٸ� ��(0)���� ��ȯ ���ִ� �Լ�
-- ex) NVL(COMM, 0)

select ename, job, sal, comm, sal*12, sal*12+nvl(comm, 0) from emp;

--��Ī �ο��ϱ� : as "��Ī��"
--��, ���� ���� ��� ""�� �ݵ�� �ο��ؾ��Ѵ�.
select ename, sal*12+nvl(comm, 0) as "Annsal"from emp;
select ename, sal*12+nvl(comm, 0) "Annsal"from emp; --as ��������
select ename, sal*12+nvl(comm, 0) Annsal from emp;--""�� ���� �����ϰ� as�� �Բ� ���� �����ϴ�

select ename, sal*12+nvl(comm, 0) as "����"from emp;
select ename, sal*12+nvl(comm, 0) as ���� from emp; --""���� ����
select ename, sal*12+nvl(comm, 0) ����from emp; --as ���� ����

--Concatenation ������ : ||
--: �÷��� ���ڿ��� ������ �� �����.
select ename || ' is a ' || job from emp;

--distinct : �ߺ����� �����ϰ� 1���� ���
select deptno from emp;

select distinct deptno from emp; --3���� �μ���ȣ ��� : 10, 20, 30

--Q. EMP ���̺��� �� ������� JOB�� 1���� ����ϴ� SQL���� �ۼ��ϼ���
select job from emp;
select distinct job from emp;--�ߺ��Ǵ� job�� �����ϰ� job�� ������ 5���� �ִ����� �� �� �ִ�.


--count(�÷���): ������ ���� ���ϱ�
select count(*)from dept; --4��
select count(*)from emp; --emp������ (*)�� �� �������ϴ� ��, 14��
select count(job)from emp; --14��
--Q. EMP ���̺��� �ߺ��� ������ JOB�� ������ ���ϴ� SQL���� �ۼ��ϼ���.
select count(distinct job) from emp; --5��

-------------------------------------------------------------------------------

--where ������: �� ������( =, >, >=, <, <=, !=,^=,<> )

--1. ���� ������ �˻�
--Q. ��� ���̺�(emp)���� �޿��� 3000 �̻� �޴� ����� �˻��ϴ� SQL���� �ۼ��ϼ���?
select * from emp where sal >= 3000;
--Q. �޿��� 3000�� ����� �˻�?
select * from emp where sal = 3000;
--Q. �޿��� 3000�� �ƴ� ����� �˻�?
select * from emp where sal != 3000; --12���� ��� �˻���
select * from emp where sal ^= 3000; --���� ���
select * from emp where sal <> 3000; --���� ���
--Q. �޿��� 1500 ������ ����� �����ȣ, �����, �޿��� ����ϴ� SQL�� �ۼ�
select empno, ename, sal from emp where sal <= 1500;

--2. ���� ������ �˻�
--1) ���� �����ʹ� ��, �ҹ��ڸ� �����Ѵ�.
--2) ���� �����͸� �˻� �� ���� ���ڿ� ��.�쿡 �ܵ���ǥ(')�� �پ�� �Ѵ�.

--Q. ������̺��� ������� FORD�� ����� ������ �˻��ϴ� SQL�� �ۼ�?
select * from emp where ename = 'ford'; --�˻� ��� ����: �빮�� �̸� �����͸� �ҹ��ڷ� �˻��߱� ������ 
select * from emp where ename = FORD; --���� �߻�: �ܵ���ǥ ����
select * from emp where ename = "FORD" --���� �߻�: �ֵ���ǥ �ȵ�
select * from emp where ename = 'FORD'; --����

--Q. SCOTT ����� �����ȣ, �����, �޿��� ����ϴ� SQL�� �ۼ�?
select empno, ename, sal from emp where ename = 'SCOTT';

--3. ��¥ ������ �˻�
--1) ��¥ �����͸� �˻��� �� ��¥ ��.�쿡 �ܵ���ǥ(��)�� �ٿ�����
--2) ��¥ �����͸� ���� �� �� �����ڸ� ����Ѵ�.

--Q. 1982�� 1�� 1�� ���Ŀ� �Ի��� ����� �˻��ϴ� SQL�� �ۼ�
select * from emp where hiredate >= 82/01/01; --�����߻�: �ܵ���ǥ ����
select * from emp where hiredate >= '82/01/01';-- ����
select * from emp where hiredate >= '1982/01/01'; --����

select * from emp where hiredate >= '82/01/01'
 order by hiredate asc;-- �Ի����� �������� ����


-----------------------------------------------------------------------------------------
--�� ������ : and, or, not
--1. and ������ : �� ���ǽ��� ��� �����ϴ� �����͸� �˻�
--Q. ������̺��� �μ���ȣ�� 10���̰�, JOB�� MANAGER�� ����� �˻��ϴ� SQL�� �ۼ�
select * from emp where deptno=10 and job='MANAGER';

--2. or ������ : �� ���ǽ� �߿��� �Ѱ����� �����ص� �˻�
--Q. ������̺��� �μ���ȣ�� 10�̰ų�, JOB�� MANAGER�� ����� �˻��ϴ� SQL�� �ۼ�
select * from emp where deptno=10 or job='MANAGER';

--3. not ������ : ������ �ݴ�� �ٲ��ִ� ����
--Q. �μ���ȣ�� 10���� �ƴ� ����� �˻��ϴ� SQL�� �ۼ�
select * from emp where not deptno=10; --��������
select * from emp where deptno!=10; --�񱳿�����
select * from emp where deptno^=10; --�񱳿�����
select * from emp where deptno<>10; --�񱳿�����

--Q1. �޿��� 2000���� 3000 ������ �޿��� �޴� ����� �˻��ϴ� SQL�� �ۼ��ϼ���?
select * from emp where sal>=2000 and sal<=3000;

--Q2. Ŀ�̼��� 300�̰ų� 500�̰ų� 1400�� ����� �˻��ϴ� SQL�� �ۼ��ϼ���?
select * from emp where comm=300 or comm=500 or comm=1400;

--Q3. �����ȣ�� 7521�̰ų� 7654�̰ų� 7844�� ����� �˻��ϴ� SQL�� �ۼ��ϼ���?
select * from emp where empno=7521 or empno=7654 or empno=7844;

--between and ������
-- : where �÷��� between ������ and ū��
--Q1. �޿��� 2000���� 3000 ������ �޿��� �޴� ����� �˻��ϴ� SQL�� �ۼ��ϼ���?
select * from emp where sal>=2000 and sal<=3000; --and �����ڷ� �ۼ� 
select * from emp where sal between 2000 and 3000;--between and �����ڷ� �ۼ�

--Q2. �޿��� 2000�̸��̰ų� 3000 �ʰ��� ����� �˻��ϴ� SQL�� �ۼ�?
select * from emp where sal<2000 or sal>3000;
select * from emp where not between 2000 and 3000;

--Q3. 1987�⵵�� �Ի��� ����� �˻��ϴ� SQL���� �ۼ�?
select * from emp where hiredate >= '87/01/01' and hiredate <='87/12/31';
select * from emp where hiredate between '87/01/01' and '87/12/31';

--in ������
-- : where �÷��� in (������1, ������2, ...)
--Q. Ŀ�̼��� 300�̰ų� 500�̰ų� 1400�� ����� �˻��ϴ� SQL�� �ۼ��ϼ���?
select * from emp where comm=300 or comm=500 or comm=1400;
select * from emp where comm in (300,500,1400);

--Q. Ŀ�̼��� 300, 500, 1400�� �ƴ� ����� �̻��ϴ� SQL�� �ۼ�?
select * from emp where comm!=300 and comm!=500 and comm!=1400;

select * from emp where comm not in (300,500,1400); --���� not�� �ٿ��ٰ� �ؼ� oró�� �������� �ǳ�?

--Q. �����ȣ�� 7521�̰ų� 7844�� ����� �˻��ϴ� SQL�� �ۼ�?
select * from emp where empno=7521 or empno=7844;

select * from emp where empno in(7521, 7844);

-- like �����ڿ� ���ϵ� ī�� : �˻������ ������ �� �����.
-- : where �÷��� like pattern

-- ���ϵ� ī��(pattern�� ����� ����)
-- 1. % : ���ڰ� ���ų�, �ϳ� �̻��� ���ڿ� � ���� �͵� ������ٴ� �ǹ�.
-- 2. _ : �ϳ��� ���ڿ� � ���� �͵� �������.

--Q. ������̺��� ������� �빮�� F�� �����ϴ� ����� �˻��ϴ� SQL�� �ۼ�?
select *from emp where ename = 'FORD'; --FORD ����� �˻�

select *from emp where ename like 'F%';

--Q. ������̺��� ������� N���� ������ ����� �˻��ϴ� SQL�� �ۼ�?
select * from emp where ename like '%N';

--Q. ������̺��� ������� A�� �����ϴ� ����� �˻��ϴ� SQL�� �ۼ�?
select * from emp where ename like '%A%';

--�����(_) ���ϵ� ī��
-- : �ϳ��� ���ڿ� � ���� �͵� �������.
--Q. ��� �̸��� �ι�° ���ڰ� A�� ����� �˻��ϴ� SQL�� �ۼ�?
select * from emp where ename like '_A%'; --ù��° ���ڴ� � ���� �͵� ������� �ι�° ����A �� �ڷ� ���ų� ����� �͵��Ǵ� %����

--Q. ��� �̸��� ����° ���ڰ� A�� ����� �˻��ϴ� SQL�� �ۼ�?
select * from emp where ename like '__A%';--����� 2������

--Q. ��� �̸��� ������ 2��° ���ڰ� E�� ����� �˻��ϴ� SQL�� �ۼ�?
select * from emp where ename like '%E_';

--Q. ����� A�� ���ԵǾ� ���� ���� ����� �˻��ϴ� SQL�� �ۼ�?
select * from emp where ename not like '%A%';
