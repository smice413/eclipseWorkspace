--2022.01.26.02 (��)


-- DDL(Data Definition Language) : ������ ���Ǿ�
-- create : ���̺� ����
-- alter : ���̺� ������ ����
-- rename : ���̺� �̸� ����
-- drop : ���̺� ����
-- truncate : ������ ���� (DDL SQL��) *Delete ������ ����(DML SQL��)

-- ���̺� ���
select * from tab;
select * from user_tables;

--1. create
-- : �����ͺ��̽�, ���̺� ����

--create table ���̺��( �÷��� ������ Ÿ��,
--                      �÷��� ������ Ÿ��,
--                       .......); 

-- ����Ŭ ������ Ÿ��
--1) ���� ������
-- number(n) : ���� n�ڸ����� ����
-- number(n1, n2) : n1 - ��ü �ڸ���, n2 - �Ҽ����� �Ҵ�� �ڸ���

--2) ���� ������
-- char() : ���� ���� ������
--          �ִ� 2000byte ���� ���� ����
-- varchar2() : ���� ���� ������
--              �ִ� 4000byte ���� ���� ����
-- long : 2GB ���� ���� ����
--        long ������ ������ �÷��� ����� �������� �ʴ´�.

--3) ��¥ ������
-- date : ��/��/�� ���� ����
-- timestamp : ��/��/��/ ��:��:�� ���� ����


--1) ���̺� ����
--create table ���̺��( �÷��� ������ Ÿ��,
--                      �÷��� ������ Ÿ��,
--                       .......); 
create table emp01( empno number(4),
                    ename varchar2(20),
                    sal number(7,2) );
select * from tab;                    

--2) ���������� ���̺� ����
--   ���纻 ���̺��� ������
--   ��, ���������� ���簡 ���� �ʴ´�.
drop table emp02 purge;     --Ȥ���� emp02���̺��� �ִ� �� ����
create table emp02 as select * from emp; --���纻 ���̺��� ������
select * from tab;
select * from emp02;

--���ϴ� �÷����� ������ ���纻 ���̺� ����
create table emp03 as select empno, ename from emp;
select * from emp03;
--���ϴ� ������ ������ ���纻 ���̺� ����
create table emp04 as select * from emp where deptno = 10;
select * from emp04;
--���̺� ������ ����
create table emp05 as select * from emp where 1=0;-- 1=0 ���ǽ��� �׻� ���� �ʴٴ� �������� �����ʹ� ����X
select * from emp05;

--2. alter
-- : ���̺� ������ ����(�÷��߰�, �÷� ����<�÷���.�ڷ���>, �÷� ����)
-- 1) �÷� �߰�
--create table emp01( empno number(4),
--                    ename varchar2(20),
--                    sal number(7,2) );
alter table emp01 add(job varchar2(10));
desc emp01;

-- 2) �÷� ����
--     i)������ �÷��� �����Ͱ� ���� ���
--       �÷��� ������ Ÿ���� ������ �� �ִ�.
--       �÷��� ũ�⸦ ������ �� �ִ�.
--    ii)������ �÷��� �����Ͱ� �ִ� ���
--       �÷��� ������ Ÿ���� ������ �� ����.
--       �÷��� ũ��� �ø��� ������,
--       ���� ������ ũ�⺸�� ���� ũ��� ������ �� ����.

alter table emp01 modify(job varchar2(30)); --job�� �÷�ũ�⸦ 10->30���� ����
desc emp01;

-- 3) �÷� ����
alter table emp01 drop column job;
alter table emp01 drop(job);
desc emp01;


--3. rename
-- : ���̺� �̸� ����
-- ����: rename old_name to new_name;
--Q. emp01 ���̺��� TEST ���̺������ ���� �غ���?
rename emp01 to test;
select * from tab;

--4. truncate
-- : ���̺��� ��� �����͸� ����
-- ����: truncate table_name;
truncate table emp02;  --emp02 ���̺� �ȿ� �ִ� ������ ��� ����
select * from emp02;

--5. drop
-- : ���̺� ����
-- ����: drop table table_name; (oracle ���� 10g���ʹ� �����ȵǰ� �ӽ����̺�� ��ü��)
--      drop table table_name purge; (purge�� �־�� �����ϰ� ������)

drop table test;     --�ӽ����̺�� ��ü(������� ����)
select * from tab;

-- �ӽ� ���̺� ����
purge recyclebin;

------------------------------------------------------------------------------------------
--* ����Ŭ�� ��ü
--  ���̺�, ��, ������, �ε���, ���Ǿ�, ���ν���, Ʈ����
--
--//�̷� ��ü ������ �˻��Ҷ� ������ ��ųʸ� �並 ���� �˻���
--//������ ��ųʸ��� �ý��� ���̺��̱� ������ �Ϲ������� ���� �ȵǼ� ��ųʸ� �並 �̿���
--
--* ������ ��ųʸ��� ������ ��ųʸ� ��
--  ������ ��ųʸ��� ���ؼ� ���ٰ�����
--
--  - ������ ��ųʸ� �� : user_xxxx
--     (���� ���̺�)      all_xxxx
--		                dba_xxxx
--
--  - ������ ��ųʸ�(�ý��� ���̺�) : 

--SCOTT ���� ������ ���̺� ��ü�� ���� ������ ��ȸ
select * from tab;              --tab : ���� ���Ǿ�
select * from sys.tab;              

select * from user_tables;

-- �ڱ� ���� ����(SCOTT ����) �Ǵ� ������ �ο� ���� ��ü � ���� ������ ��ȸ
select * from all_tables;

-- DBA ����(sys �Ǵ� system ����)�� ��� ������
select * from dba_tables; --���� : ���� SCOTT������ ����Ǿ� �ֱ� ����

-- ����Ŭ �ý����� ���� ���� �˻�
select * from dba_users;  --���� : system �������� �˻��ؾ���

------------------------------------------------------------------------------------
--DML(Data Manipulation Language, ������ ���۾�)
-- : insert, update, delete

--1. insert : ������ �Է�
-- 1)����
--   insert into ���̺��(�÷�1, �÷�2, ...)values(������1, ������2, ...);
--   insert into ���̺�� values(������1, ������2,....); �����͸� �÷�������� �����

--[�ǽ�]
drop table dept01 purge; --�̹� �ִ� dept01 ���̺� ����

--����ִ� dept01 ���纻 ���̺� ����
create table dept01 as select * from dept where 1=0; --���̺� ������ �����. ������X
select * from dept01;
--����1)
insert into dept01(deptno, dname, loc) values(10, 'ACCOUNTING', 'NEW YORK');
--����2)
insert into dept01 values(20, 'RESEARCH', 'DALLAS');
insert into dept01 values(30, '������', '����');

--NULL�� �Է�
insert into dept01(deptno, dname) values(40, '���ߺ�'); --�Ͻ��� : Į���� �Է�X
insert into dept01 values(50, '��ȹ��', NULL);          --����� : ���� NULL�� �Է�

--2) ���������� ������ �Է�
drop table dept02 purge;
-- dept02 ���̺� ����
create table dept02 as select * from dept where 1=0; --���̺� ������ ����
select * from dept02;
--���������� ������ �Է�
insert into dept02 select * from dept; --as�� ���纻 ���̺� ������ �� ������ insert�� as����
insert into dept02 select * from dept02; --�ڽ��� �����͸� �״�� �����鼭 �����Ͱ��� �������� �þ��.

--3) insert all: ���� ���̺� ������ �Է�
-- 2���� ���̺� ����
create table emp_hir as select empno, ename, hiredate from emp where 1=0;
create table emp_mgr as select empno, ename, mgr from emp where 1=0;
-- insert all ��ɹ����� ���� ���̺� ������ �Է�
insert all 
            into emp_hir values(empno, ename, hiredate)
            into emp_mgr values(empno, ename, mgr)
            select empno, ename, hiredate, mgr from emp
            where deptno = 20;
            
select * from emp_hir;
select * from emp_mgr;


--2. update : ������ ����
--����: update ���̺�� set �÷�1 = ������ ��1,
--                        �÷�2 = ������ ��2
--                        where ������;

--[�ǽ�]
drop table emp01 purge;

--���纻 ���̺� ����
create table emp01 as select * from emp;
select * from emp01;

--1) ��� ������ ���� : where������ ���� ���� �ȴ�.
--Q. ��� ������� �μ���ȣ�� 30������ ����
update emp01 set deptno = 30;

--Q. ��� ������� �޿��� 10% �λ�
update emp01 set sal = sal * 1.1;

--Q. ��� ������� �Ի����� ���� ��¥�� ����
update emp01 set hiredate = sysdate;

--2) Ư�� �����͸� ���� : where ������ ���
drop table emp02 purge;
create table emp02 as select * from emp; --���纻 ���̺� ����
select * from emp02;

--Q. �޿��� 3000 �̻��� ����� �޿��� 10%  �λ�
update emp02 set sal = sal * 1.1 where sal >= 3000;

--Q. 1987�⵵�� �Ի��� ����� �Ի����� ���� ��¥�� ����
update emp02 set hiredate = sysdate where substr(hiredate,1,2)='87';

--Q. SCOTT ����� �Ի����� ���� ��¥�� �����ϰ�, �޿��� 50���� Ŀ�̼��� 4000���� ����
update emp02 set hiredate = sysdate, sal = 50, comm = 4000 where ename = 'SCOTT';


--3) ���������� �̿��� ������ ����
--Q. 20�� �μ��� ������(DALLAS)�� 40�� �μ��� ������(BOSTON)���� ����
drop table dept01 purge;
create table dept01 as select * from dept; --���纻 ���̺� ����
select * from dept01;

update dept01 set loc = (select loc from dept01 where deptno = 40)
    where deptno = 20;
    
--3. delete : ������ ����
-- ����: delete from ���̺�� where ������;
--1) ��� ������ ���� : where �������� ������� �ʴ´�.
select * from dept01;
delete from dept01;
rollback;           --Ʈ������� ��� : delete�� ������ �����͸� �����Ѵ�.

--2) ������ �����ϴ� ������ ���� : where �������� ���
delete from dept01 where deptno = 30;

--3) ���������� �̿��� ������ ����
--Q. ������̺�(emp02)���� �μ����� SALES �μ��� ����� ����?
create table emp02 as select * from emp;
select * from emp02;

delete from emp02 where deptno = 
    (select deptno from dept where dname = 'SALES');
    
-------------------------------------------------------------------------------------------   
--* ���̺� ������ ������ �� ���̺��� MERGE ����
--
--  MERGE : ������ ���� 2���� ���̺��� �ϳ��� ���̺�� ��ġ�� ���.
--  MERGE����� �����Ҷ� ������ �����ϴ� ��(ROW)�� ������ ���ο�     
--  ������ UPDATE�ǰ�, �������� ������ ���ο� ��(ROW)���� �߰��ȴ�.

drop table emp01 purge;
drop table emp02 purge;
select * from emp01;
select * from emp02;


1. create table emp01 as select * from emp;    --14�� ������, ���̺� ������ ����

2. create table emp02 as select * from emp where job='MANAGER'; --3�� ������, ���̺� ������ ����

3. update emp02 set job='Test'; --job�� MANAGER���� Test�� �ٲ�

4. insert into emp02 values(8000, 'ahn', 'top', 7566, '2018/02/22',1200, 10, 20);

5. select * from emp02; --(Ȯ��)

6. merge into emp01
	using emp02
	on(emp01.empno = emp02.empno)
	when matched then
	     update set emp01.ename = emp02.ename,
			emp01.job = emp02.job,
			emp01.mgr = emp02.mgr,
			emp01.hiredate = emp02.hiredate,
			emp01.sal = emp02.sal,
			emp01.comm = emp02.comm,
			emp01.deptno = emp02.deptno
	when not matched then
	     insert values(emp02.empno, emp02.ename, emp02.job, 		         	         
		          emp02.mgr,emp02.hiredate, 
		         emp02.sal, emp02.comm,emp02.deptno);

7. select * from emp01; (�պ��� ��� Ȯ��)
