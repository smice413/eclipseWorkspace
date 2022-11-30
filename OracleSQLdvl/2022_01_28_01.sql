--2022.01.28.01 (��)

--4. foreign key (�ܷ�Ű)
-- DEPT(�θ����̺�) - deptno(pk) : 10, 20, 30, 40
-- EMP(�ڽ����̺�) - deptno(fk) : 10, 20, 30
--fk ���������� �θ����̺�� �ڽ����̺��� �ʿ��ϴ�. ������ �� �ִ� �θ�Ű�� �־�� �ϸ�,
--�ڽ��� �θ�Ű���� �����Ͽ� ������ �����ϰ� �ȴ�. �θ�Ű���� ������ �� ���� ������ �ڽĵ� ������ ������ �� ����.

--1) ������̺�(EMP)�� deptno �÷��� foreign key ���������� �����Ǿ� �ִ�.
--2) foreign key ���������� ������ �ִ� �ǹ̴� �θ����̺�(DEPT)��
--   �θ�Ű(deptno)�� ���� ������ �� �ִ�.(10, 20, 30, 40�� �μ���ȣ�� ������ �� �ִ�.)
--3) �θ�Ű�� �Ǳ� ���� ������ primary key�� unique ������������ �����Ǿ�
--   �־�� �Ѵ�.

--Q. ������̺�(EMP)�� ���ο� ��������� ��� �غ���?
-- �ܷ�Ű�� �θ�Ű(DEPT - deptno)�ȿ� �ִ� ��(10,20,30,40)�� ������ �� �ִ�.
insert into  emp(empno, deptno) values(1111, 50); --�������� ����

--[�ǽ�]
drop table emp06 purge;
create table emp06(
    empno number(4) primary key,
    ename varchar2(10) not null,
    job varchar2(10),
    deptno number(2) references dept(deptno) );
    
select * from emp06;
insert into emp06 values(1111, 'ȫ�浿', '������', 10);
insert into emp06 values(1112, 'ȫ�浿', '������', 20);
insert into emp06 values(1113, 'ȫ�浿', '������', 30);
insert into emp06 values(1114, 'ȫ�浿', '������', 40);
insert into emp06 values(1115, 'ȫ�浿', '������', 50); --�������� ����

--5. check ��������
-- : �����Ͱ� �Էµ� �� Ư�� ������ �����ϴ� �����͸� �Էµǵ��� ����� �ִ� ��������
create table emp07(
    empno number(4) primary key,
    ename varchar2(10) not null,
    sal number(7,2) check(sal between 500 and 5000), --sal: 500~5000
    gender varchar2(1) check(gender in ('M','F')) );--gender: 'M' or 'F'
    
select * from emp07;
insert into emp07 values(1111, 'ȫ�浿', 3000,'M'); --�������� ������ �Է�
insert into emp07 values(1112, 'ȫ�浿', 8000,'M'); --check �������� ����
insert into emp07 values(1113, 'ȫ�浿', 5000,'m'); --check �������� ����

--5. default ��������
--default ���������� ������ �÷��� ���� �Էµ��� ������ default�� ������ ���� �ڵ����� �Էµȴ�.

drop table dept01 purge;
create table dept01(
    deptno number(2) primary key,
    dname varchar2(14),
    loc varchar2(13) default 'SEOUL');

select * from dept01;
insert into dept01 values(10, 'ACCOUNTING' , 'NEW YORK');
insert into dept01 (deptno, dname) values(20, 'RESEARCH'); 
--LOC���� ���� �Է����� �ʾұ� ������ default ���� SEOUL�� �ڵ����� �Էµ�.

---------------------------------------------------------------------------------------
--���� ���� ���� ���
--1. �÷����� ������� �������� ����
--2. ���̺��� ������� �������� ����

--1. �÷����� ������� �������� ����
drop table emp01 purge;

create  table  emp01(
	empno  number(4)  primary  key,
	ename  varchar2(15)  not null,
	job  varchar2(10)  unique,
 	deptno  number(4)  references  dept(deptno)  );
    
--2. ���̺��� ������� �������� ����   
drop table emp02 purge;

create table emp02(
    empno number(4),
    ename varchar2(15) not null,
    job varchar2(10),
    deptno number(4),
    primary key(empno),
    unique(job),
    foreign key(deptno) references dept(deptno) );
    
-- ���� ������ �����Ҷ� ���̺� ���� ��ĸ� ������ ���
--1. �⺻Ű�� ����Ű�� ����ϴ� ���
--   2�� �̻��� �÷��� �⺻Ű�� �����ϴ� ���
--2. alter table�� ���� ������ �߰��� ��
    

--1. 2�� �̻��� �÷��� �⺻Ű�� �����ϴ� ���
drop table member01 purge; 

--1) �÷����� ������� 2���� �÷��� primary key�� ����
create table member01(
    id varchar2(20) primary key,
    passwd varchar2(20) primary key); --���̺� �����ȵ�
    
--2) ���̺��� ������� 2���� �÷��� primary key�� ����
create table member01(
    id varchar2(20),
    passwd varchar2(20),
    primary key(id, passwd));
    
--2. alter table�� ���� ������ �߰��� ���
drop table emp01 purge;

--���������� ���� ���̺� ����
create table emp01(
    empno number(4),
    ename varchar2(15),
    job varchar2(10),
    deptno number(2) );
    
--primary key �������� �߰� : empno
alter table emp01 add primary key(empno);

--not null �������� �߰� : ename
alter table emp01 modify ename not null;

--unique �������� �߰� : job
alter table emp01 add unique(job);

--foreign key �������� �߰� : deptno
alter table emp01 add foreign key(deptno) references dept(deptno);

--�������� ����
-- ����: alter table ���̺�� drop constraint constraint_name;

--primary key �������� ����
alter table emp01 drop constraint SYS_C007046;
alter table emp01 drop primary key;

--not null �������� ����
alter table emp01 drop constraint SYS_C007047;

--unique �������� ����
alter table emp01 drop constraint SYS_C007048;
alter table emp01 drop unique(job);

--foreign key �������� ����
alter table emp01 drop constraint SYS_C007049;

--���� ������ Ȱ��ȭ / ��Ȱ��ȭ
--1. �θ� ���̺� ����
drop table dept01 purge;
create table dept01(
    deptno number(2) primary key,
    dname varchar2(14),
    loc varchar2(13) );
    
insert into dept01 values(10, 'ACCOUNTING', 'NEW YORK');
select * from dept01;

--2. �ڽ� ���̺� ����
drop table emp01 purge;
create table emp01(
    empno number(4) primary key,
    ename varchar2(10) not null,
    job varchar2(10) unique,
    deptno number(2) references dept01(deptno) );
    
insert into emp01 values(1111, 'ȫ�浿', '������', 10);    
select * from emp01;

--3. �θ� ���̺��� ������ ����
delete from dept01; --�ڽ����̺�(emp01)���� �����ϰ� �ֱ� ������ ���� �ȵ�.

--�θ����̺�(DEPT01) �����͸� �����ϱ� ���ؼ��� �ڽ����̺�(EMP01)�� foreign key ����������
--��Ȱ��ȭ ��Ű��, �θ����̺��� �����͸� ������ �� �ִ�.

--�ڽ����̺�(EMP01)�� foreign key ���������� ��Ȱ��ȭ ���Ѻ���?
--alter table ���̺�� disable constraint constraint_name;
alter table emp01 disable constraint SYS_C007055;

--cf. foreign key ���������� Ȱ��ȭ
alter table emp01 enable constraint SYS_C007055;

-- cascade �ɼ� 
--1. cascade �ɼ��� �ٿ��� �θ����̺�(DEPT01)�� ���������� ��Ȱ��ȭ ��Ű��, 
--   �����ϰ� �ִ� �ڽ����̺�(EMP01)�� foreign key �������ǵ� ���� ��Ȱ��ȭ �ȴ�. 
alter table dept01 disable constraint SYS_C007051 cascade;

--2. cascade �ɼ��� �ٿ��� �θ� ���̺�(DEPT01)�� primary key ����������
--   �����ϸ�, �����ϰ� �ִ� �ڽ� ���̺�(EMP01)�� foreign key �������ǵ�
--   ���� ���� ���ش�.
alter table dept01 drop primary key cascade;