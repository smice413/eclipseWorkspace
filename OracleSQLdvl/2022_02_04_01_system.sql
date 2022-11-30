--22.02.04.01 (��)


--���Ǿ�(synonym)

--1. ����� ���Ǿ�
--  : ��ü�� ���� ���� ������ �ο����� ����ڰ� ������ ���Ǿ�� �ش�
--    ����ڸ� ����� �� �ִ�.

--2. ���� ���Ǿ�
--  : DBA ������ ���� ����ڸ� ������ �� ������, ������ ����� �� �ִ�.

-- ���� ���Ǿ��� ��
--sys.dual --> dual              select 10+20 from dual;
--sys.tab  --> tab               select * from tab;
--sys.seq  --> seq               select * from seq;

---------------------------------------------------------------------------------------
--����� ���Ǿ� ����
--1. system �������� ������ ���̺� ����
conn system/oracle
create table systbl(ename varchar2(20));

--2. ������ ���̺� ������ �߰�
conn system/oracle
insert into systbl values('�ż�ȣ');
insert into systbl values('ȫ�浿');

select * from systbl;

--3. scott �������� systbl ���̺� ���� select ��ü������ �ο�
conn system/oracle
grant select on systbl to scott;

--4. scott �������� ������ �˻�
conn scott/tiger
select * from systbl; --�����߻�
select * from system.systbl;  --�˻� ������

--5. scott �������� ���Ǿ ������ �� �ִ� ������ �ο��Ѵ�.
conn system/oracle
grant create synonym to scott;

--6. scott  �������� ���� �� ����� ���Ǿ� ���� : system.systbl --> systbl
conn scott/tiger
create synonym systbl for system.systbl;

--7. ���Ǿ� ��� Ȯ��
conn scott/tiger
select * from user_synonyms;

--8. ���Ǿ �̿��ؼ� �˻�
conn scott/tiger
select * from system.systbl;
select * from systbl;   --���Ǿ �����߱� ������ �˻� ����(����� ���Ǿ�)

--9. ���Ǿ� ����
conn scott/tiger
--���� : drop synonym synonym_name;
drop synonym systbl;

------------------------------------------------------------------------------------
--���� ���Ǿ�
--1. DBA �������� �����ؼ� ���� ���Ǿ ������ �� �ִ�.
--2. ���� ���Ǿ ���鶧�� public�� �ٿ��� ������ �� �ִ�.

-- ���� ���Ǿ� ����
conn system/oracle
create public synonym pubdept for scott.dept;

-- ���� ���Ǿ� ���
select * from dba_synonyms;

-- ���� ���Ǿ� ����
conn system/oracle
drop public synonym pubdept;