--22.02.03.01 (��)

-- ������(sequence)
-- : ���̺� ���ڸ� �ڵ����� �������Ѽ� ó�����ִ� ����

-- ������ ����
create sequence dept_deptno_seq 
start with 10               --������ ��ȣ��
increment by 10;             --����ġ


-- ������ ���
select * from seq;
select * from user_sequences;

--currval : ������ ���簪�� ��ȯ
--nextval : ������ �������� ��ȯ

select dept_deptno_seq.nextval from dual; --10, 20, 30 ..
select dept_deptno_seq.currval from dual; --10, 20 ���� ��

--��1. �������� ���̺��� �⺻Ű�� �����ϱ�
drop table emp01 purge;
create table emp01(
    empno number(4) primary key,
    ename varchar2(10),
    hiredate date);
    
create sequence emp01_empno_seq; --1���� 1�� �����Ǵ� ������ ����

select * from tab; --���̺� ��� Ȯ��
select * from seq; --������ ��� Ȯ��

--������ �Է�
insert into emp01 values(emp01_empno_seq.nextval, 'ȫ�浿', sysdate);

select * from emp01;

--��2.
--���̺� ����
create table dept_example(
    deptno number(4) primary key,
    dname varchar2(15),
    loc varchar2(15) );
    
-- ������ ����
create sequence dept_example_seq
start with 10
increment by 10;

-- ������ �Է�
insert into dept_example values(dept_example_seq.nextval, '�λ��', '����');
insert into dept_example values(dept_example_seq.nextval, '�渮��', '����');
insert into dept_example values(dept_example_seq.nextval, '�ѹ���', '����');
insert into dept_example values(dept_example_seq.nextval, '�����', '��õ');

select * from dept_example;

-- ������ ����
-- drop sequence ������ �̸�;
drop sequence dept_example_seq;

select * from seq;

-- ������ ����
drop sequence dept_deptno_seq;

create sequence dept_deptno_seq
start with 10       --���۰�
increment by 10     --������
maxvalue 30;        --�ִ밪

-- ������ ���
select * from seq;
select * from user_sequences;

-- ������ ������ ���ؿ���
select dept_deptno_seq.nextval from dual;     --10 ���ؿ�
select dept_deptno_seq.nextval from dual;     --20 ���ؿ�
select dept_deptno_seq.nextval from dual;     --30 ���ؿ�
select dept_deptno_seq.nextval from dual;     --����: �ִ밪�� 30�ε� nocycle�̱� ������ �ݺ����� �����߻�

-- ������ ���� : maxvalue: 30 --> maxvalue: 1000000
alter sequence dept_deptno_seq maxvalue 1000000;

-- ������ ������ ���ؿ���
select dept_deptno_seq.nextval from dual;     --40 ���ؿ�
select dept_deptno_seq.nextval from dual;     --50 ���ؿ�

------------------------------------------------------------------------------------
-- �ε���(index) : ���� �˻��� �ϱ� ���ؼ� ���Ǵ� ��ü

-- �ε��� ��� Ȯ��
select * from user_indexes;

-- �⺻Ű(primary key)�� ������ �÷��� �ڵ����� ���� �ε����� �����ȴ�.

--[�ǽ�]
--�ε��� �ǽ�(�ε��� ��� ��.���� ���� �˻� �ӵ� ��)
--1. ���̺� ����
drop table emp01 purge;

--���纻 ���̺� ���� : ���� ������ ������� �ʴ´�.
create table emp01 as select * from emp;

--2. emp01 ���̺� ������ �Է� : 1400�� ������
insert into emp01 select * from emp01; 

--3. �˻��� ������ �Է�
insert into emp01(empno, ename) values(1111, 'shin');

--4. �ð� ���� Ÿ�̸� ��
set timing on

--5. �˻��� �����ͷ� �˻��ð��� ���� : �ε����� �������� ���� ���
select * from emp01 where ename = 'shin';  --3.114�� �ҿ�

--6. �ε��� ���� : ename �÷��� �ε����� �����
create index idx_emp01_ename on emp01(ename);

--�ε��� ���
select * from user_indexes;

--7. �˻��� �����ͷ� �˻��ð��� ���� : �ε����� ������ ���
select * from emp01 where ename = 'shin';  --0.012�� �ҿ�

-- �ε��� ����
--���� : drop index index_name;
drop index idx_emp01_ename;


-- �ε��� ����
-- ���� �ε��� : �ߺ��� �����Ͱ� ���� �÷��� ������ �� �ִ� �ε���
-- ����� �ε��� : �ߺ��� �����Ͱ� �ִ� �÷��� ������ �� �ִ� �ε���

--1. ���̺� ����
drop table dept01 purge;
create table dept01 as select * from dept where 1=0; --���̺� ������ ����

--2. ������ �Է� : loc�÷��� �ߺ� �����͸� �Է�
insert into dept01 values(10, '�λ��', '����');
insert into dept01 values(20, '�ѹ���', '����');
insert into dept01 values(30, '������', '����');
select * from dept01;

--3. ���� �ε��� ���� : deptno �÷��� ���� �ε��� ����
create unique index idx_dept01_deptno on dept01(deptno);

select * from user_indexes;

--���� �ε����� ������ deptno �÷��� �ߺ������͸� �Է� �غ���?
--deptno �÷��� ���� �ε����� ������ ���Ŀ� �ߺ��� �����͸� �Է��� �� ����.
insert into dept01 values(30, '������', '����'); --����

--4. �ε��� ��� Ȯ��
select * from user_indexes;

--5. ����� �ε��� : loc �÷��� ����, ����� �ε����� ���� �غ���
create unique index idx_dept01_loc on dept01(loc); --����: loc�÷��� �ߺ������Ͱ� �ֱ� ����

create index idx_dept01_loc on dept01(loc); --����� �ε��� ����

--6. ���� �ε��� : 2�� �̻��� �÷����� ������� �ε���
create index idx_dept01_com on dept01(deptno, dname);

--7. �Լ� ��� �ε��� : �����̳� �Լ��� �����Ͽ� ���� �ε���
create index idx_emp01_annsal on emp(sal*12);