--2022.01.27.01 (��)

-- Ʈ�����(Transaction)
--1. ������ �۾�����
--2. �������� �ϰ����� ���� �ϸ鼭, �����͸� ���������� �����ϱ� ���ؼ� ����Ѵ�.

-- TCL(Transaction Control Language)
-- commit : Ʈ������� ����
-- rollback : Ʈ������� ���
-- savepoint : ������ ����(������)�� �����ϴ� ����

--[�ǽ�]
drop table dept01 purge;
create table dept01 as select * from dept; --���纻 ���̺� ����
select * from dept01;

--rollback : Ʈ������� ��� ( ������ ����)
delete from dept01;
rollback;

--commit : Ʈ������� ����
delete from dept01 where deptno = 20;
commit; --Ʈ����� ����
rollback; -- Ʈ������� ����Ǿ��� ������ ������ 20�� ������ ����X

--�ڵ� Ŀ�� : �ڵ����� Ŀ���� ����
--1) �������� ���� : quit, exit, con.close()
--2) DDL(create, alter, rename, drop, truncate), DCL(grant, revoke)
--   ����� ����

--��1.
select * from dept01; --10, 30, 40
delete from dept01 where deptno = 40; --���ο� �ŷ� ���� : 40�� ������ ����

create table dept03 as select * from dept; --�ڵ� Ŀ�� ����(DDL)
rollback; --������ 40�� �����͸� �������� ���Ѵ�.

--��2. DML(delete) : ������ ���� ����
--     DDL(truncate) ������ ���� �Ұ���( �ڵ� Ŀ�� �Ǳ� ������)
select * from dept01; --10, 30

delete from dept01 where deptno = 30; --30�� �μ� ����
rollback; --30�� �μ� ����

truncate table dept01; --where ������ ���� ���� ��� ������ �������ϰ� �ڵ�Ŀ������ ���� �Ұ���
rollback; --���� �ȵ�

-- �ڵ� �ѹ� : �ڵ����� �ѹ��� ����Ǵ� ��
-- : ���������� ����(������ â�� �ٴ� ���, ��ǻ�Ͱ� �ٿ�Ǵ� ���)


-- savepoint : ������ ����(������)�� �����ϴ� ����
--[�ǽ�]
drop table dept01 purge;

--1. dept01 ���̺� ����
create table dept01 as select * from dept;
select * from dept01;

--2. 40�� �μ� ����
delete from dept01 where deptno = 40;

--3. commit ���� : Ʈ����� ����
commit;

--4. 30�� �μ� ����
delete from dept01 where deptno = 30;

--5. c1 ������ ����
savepoint c1;

--6. 20�� �μ� ����
delete from dept01 where deptno = 20;

--7. c2 ������ ����
savepoint c2;

--8. 10�� �μ� ����
delete from dept01 where deptno = 10;

--9. c2 ������ ����
rollback to c2;
select * from dept01;

--10. c1 ������ ����
rollback to c1;
select * from dept01;

--11. ���� Ʈ����� ���� ���ĸ� ����
rollback;
select * from dept01;

----------------------------------------------------------------------------
--���Ἲ ��������
-- : ���̺� �������� �����Ͱ� �Է� �Ǵ°��� ���� �ϱ� ���ؼ� ���̺��� ������ ��
--   �� �÷��� ���ؼ� �����ϴ� �������� ��Ģ�� ���Ѵ�.
-- ex) not null, unique, primary key(�⺻Ű), foreign key(�ܷ�Ű),
--     check, default etc

--1. not null ��������
-- null ���� ������� �ʴ´�.
-- �ݵ�� ���� �Է� �ؾ� �Ѵ�.
--[�ǽ�]
drop table emp02 purge;

create table emp02(
    empno number(4) not null,
    ename varchar2(12) not null,
    job varchar2(12),
    deptno number(2));

--�������ǿ� ������� �ʴ� ������ �Է�
insert into emp02 values(1111, 'ȫ�浿', 'MANAGER', 30);
select * from emp02;

--��������(NOT NULL)�� ���� �Ǳ� ������ ������ �Է� ���� �ʴ´�.
insert into emp02 values(NULL, NULL, 'SALESMAN', 30); --����: not null�� ������ �ɷ��ִ� ���� 
--                                                           �����͸� �ݵ�� �Է��ؾ� �ϱ� ����
insert into emp02(job, deptno)values('SALESMAN', 30); --����: ����: not null�� ������ �ɷ��ִ� ���� 
--                                                           �����͸� �ݵ�� �Է��ؾ� �ϱ� ����

--2. unique ��������
-- ������ ���� �Է��� �� �ִ�.
-- �ߺ��� ���� �Է��� �� ����.
-- null ���� �Է��� �� �ִ�.
drop table emp03 purge;
create table emp03(
    empno number(4) unique,
    ename varchar2(12) not null,
    job varchar2(12),
    deptno number(2));
    
select * from emp03;

--�������ǿ� ������� �ʴ� ������ �Է�
insert into emp03 values(1111, 'ȫ�浿', '������', 10);

--unique �������ǿ� ����
insert into emp03 values(1111, 'ȫ�浿', '������', 20);

--NULL�� �Է� ����, NULL���� �ߺ���� ����
insert into emp03 values(NULL, 'ȫ�浿', '������', 20);
insert into emp03 values(NULL, 'ȫ�浿', '������', 30);

--3. primary key(�⺻Ű) �������� 
--1) primary key = not null + unique
--2) �ݵ�� �ߺ����� �ʴ� ���� �Է� �ؾ��Ѵ�.
--ex) �μ����̺�(DEPT) - deptno(pk)
--    ������̺�(EMP) - empno(pk)

--    �Խ���(board) - ��ȣ(no) pk
--    ȸ������(member) - ���̵�(id) pk

select * from dept;
insert into dept values(10, '���ߺ�', '����'); --unique �������� ����: �ߺ��� ������
insert into dept values(NULL, '���ߺ�', '����'); --NOT NULL �������� ����: �ݵ�� ������ �Է�
--DEPT ���̺��� DEPTNO�÷��� primary key ���������� �����Ǿ� �ֱ� ������
--�ߺ��� ���� NULL���� �Է��� �� ����.

select * from emp;
--emp ���̺��� empno �÷��� primay key �������� �����Ǿ� ����
insert into emp(empno, ename) values(7788, 'ȫ�浿'); --unique �������� ����
insert into emp(empno, ename) values(NULL, 'ȫ�浿'); --NOT NULL �������� ����

drop table emp05 purge;
create table emp05(
    empno number(4) primary key,
    ename varchar2(12) not null,
    job varchar2(12),
    deptno number(2));

select * from emp05;
insert into emp05 values(1111, 'ȫ��ȣ', '������', 20); --�������� ������ �Է�
insert into emp05 values(1111, 'ȫ�浿', '������', 20); --unique �������� ����
insert into emp05 values(NULL, 'ȫ��ȣ', '������', 20); --not null �������� ����

--���� ���Ǹ�(constraint_name)�� �����ؼ� ���̺� ����
drop table emp04 purge;
CREATE TABLE EMP04( 
    EMPNO NUMBER(4) CONSTRAINT EMP04_EMPNO_UK UNIQUE,
    ENAME VARCHAR2(10) CONSTRAINT EMP04_ENAME_NN NOT NULL, 
    JOB VARCHAR2(9),
    DEPTNO NUMBER(2)
    );



