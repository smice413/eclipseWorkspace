--22.02.03.02 (��)

--�����ͺ��̽� ������ ���� ����
--1. �ý��� ����
--2. ��ü ����

--�ý��� ����: �����ͺ��̽� ������(DBA)�� ������ �ִ� ����
-- ex) create user, drop user ...

--�ý��� �����ڰ� �Ϲ� ����ڿ��� �ο��ϴ� ����
-- ex) create session : ������ ���̽� ���� ����
--     create table : ���̺��� ������ �� �ִ� ����
--     create view : �並 ������ �� �ִ� ����
--     create sequence : �������� ������ �� �ִ� ����
--     create procedure : ���ν����� ������ �� �ִ� ����

-- ���ο� ���� ����: user01/tiger
create user user01 identified by tiger;

-- ������ ���� ��� Ȯ��
select * from dba_users;

-- user01 �������� �����ͺ��̽� ���� ���� �ο�: create session
grant create session to user01;
grant create session, create table to user01;

-- with admin option
-- : grant ������� ������ �ο� ���� �� with admin option�� �ٿ��� ������
--   �ο��Ǹ�, ������ �ο� ���� �Ϲ� ������ �ڱⰡ �ο� ���� ������ ��3�� ��������
--   ��ο��� �� �ִ�.
--1. ���ο� ���� ���� : user02/tiger
create user user02 identified by tiger;

--2. �����ͺ��̽� ���� ���� �ο� : create session
grant create session to user02 with admin option;

--3. ��3�� ���� ���� : user03/tiger
create user user03 identified by tiger;

--4. user01 �������� ���� �� user03�������� create session ���� �ο�
SQL> conn user01/tiger
SQL> grant create session to user03; --���� �߻�: user01�� with admin option�� ���� ������

--5. user02 �������� ���� �� user03�������� create session ���� �ο�
SQL> conn user02/tiger
SQL> grant create session to user03; --���� �ο� ����

--6. user03 ������ user02 �������� ���� create session ������ �ο� �޾ұ�
--   ������ �����ͺ��̽� ������ �����ϴ�.
SQL> conn user03/tiger
SQL> show user;

---------------------------------------------------------------------------------------
--��(ROLE) : �������� ������ ���� ���� ��.

--����Ŭ���� �⺻������ �����Ǵ� ��
--ex) connect(8���� ����), resource(20���� ����), dba(130���� ����)

--1. ���ο� ���� ���� : user04/tiger
create user user04 identified by tiger;

--2. ������ ���� Ȯ��
select * from dba_users;

--3. user04 �������� role �ο� : connect, resource 2���� �Ѻο�
grant connect, resource to user04;

--4. user04 �������� ���� �� ���̺� ����
conn user04/tiger
create table member(id varchar2(20), passwd varchar2(20));

----------------------------------------------------------------------------------
--����� ���� �� : �ѿ� �ý��� ������ �ο�
--1. �� ����
create role mrole;

--2. ������ �ѿ� �ý��� ���� �߰�
grant create session, create table, create view to mrole;

--3. mrole�� �����ϱ� ���� ���� ���� : user05/tiger
create user user05 identified by tiger;

--4. user05 �������� mrole�� �ο��Ѵ�.
grant mrole to user05;

--5. user05 �������� ����
conn user05/tiger

-------------------------------------------------------------------------------------
-- ����� ���� �� ���� : �ѿ� ��ü���� �ο�
--1. �� ����
conn system/oracle
create role mrole02;

--2. ������ �ѿ� ��ü ������ �ο�
conn scott/tiger
grant select on emp to mrole02;

--3. user05 �������� mrole02�� �ο��Ѵ�.
conn system/oracle
grant mrole02 to user05;

--4. user05 �������� ���� �� �˻�
conn user05/tiger
select * from scott.emp;

--�� ȸ��(���� ���)
-- ���� : revoke ���̸� from ����ڸ�;
conn system/oracle
revoke mrole from user05;
revoke mrole02 from user05;

--�� ����
conn system/oracle
drop role mrole;
drop role mrole02;

----------------------------------------------------------------------------------
--����Ʈ ���� �����Ͽ� ���� ����ڿ��� �ο��ϱ�
--����Ʈ �� = �ý��� ���� + ��ü ����

--1. ����Ʈ ��
conn system/oracle
create role def_role;

--2. ������ ��(def_role)�� �ý��� ���� �߰�
conn system/oracle
grant create session, create table to def_role;

--3. ������ ��(def_role)�� ��ü ���� �߰�
conn scott/tiger
grant select on emp to def_role;
grant update on emp to def_role;
grant delete on emp to def_role;

--4. role�� �����ϱ� ���� �Ϲ� ���� ����
conn system/oracle
create user usera1 identified by tiger;
create user usera2 identified by tiger;
create user usera3 identified by tiger;

--5. def_role �� ������ �������� �ο�
conn system/oracle
grant def_role to usera1;
grant def_role to usera2;
grant def_role to usera3;

--6. usera1 �������� ������ �˻�
conn usera1/tiger
select * from scott.emp;
