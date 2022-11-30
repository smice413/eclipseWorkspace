--22.02.07.01 (��)

----------------------------------------------------------------------------------
--�ڹ� ���α׷����� ���ν��� ����
--��1.
--1. ���ν��� ����
create or replace procedure del_all
is
begin
    delete from emp01;
end;

--2. emp01 ���̺� ����
drop table emp01 purge;
create table emp01 as select * from emp;
select * from emp01;


--��2.
--1. ���ν��� ����
create or replace procedure 
	del_ename(vename in emp01.ename%TYPE)
is
begin
     delete from emp01 where ename=vename;
end;

--2. ���ν��� ��� Ȯ��
select * from user_source;

--3. emp01���̺� ����
insert into emp01 select * from emp;
select * from emp01;

--��3.
--1. ���ν��� ����
create or replace procedure sel_customer
( vname in customer.name%TYPE,
  vemail out customer.email%TYPE,
  vtel out customer.tel%TYPE)

is
begin
	select email, tel into vemail, vtel from customer
	where name = vname;
end;

--2. ���� ���ν��� ��� Ȯ��
select * from user_source;

--3. ���ε� ���� ����
variable var_email varchar2(20);
variable var_tel varchar2(20);

--4. ���ν��� ����
execute sel_customer('ȫ�浿', :var_email, :var_tel);
execute sel_customer('�ű浿', :var_email, :var_tel);

print var_email;
print var_tel;

---------------------------------------------------------------------------------------
-- ���� �Լ�
-- : ���� �Լ��� ���� ���ν����� ������ ����� ����������, �ݵ�� ���� ����� �����ִ�
--   ������ �Ѵٴ� ������ ���̰� �ִ�. ���ν����� �������� �ʴ� �͵� �����ϱ� ����

--Q1. ��� ���̺��� Ư�� ����� �޿��� 200% �λ��� ����� �����ִ� ���� �Լ�����
--1. ���� �Լ� ����
create or replace function cal_bonus(
        vempno in emp.empno%type)
    return number     -- ������ ���� �ڷ���
is
    vsal number(7,2); -- local ���� (����ο��� ����� ����)
begin
    select sal into vsal from emp where empno = vempno;
    return vsal * 2;
end;

--2. ���� �Լ� ��� Ȯ��
select * from user_source;


--3. ���ε� ���� ����
variable var_res number;

--4. �����Լ� ����
execute : var_res := cal_bonus(7788);
execute : var_res := cal_bonus(7900);
print var_res;

-- ���� �Լ��� SQL���� �����ؼ� ����
select sal, cal_bonus(7788) from emp where empno = 7788;
select sal, cal_bonus(7900) from emp where empno = 7900;

--Q2. ������� �����Լ��� �Ű������� �����Ͽ� �ش� ����� ������ ���ؿ���
--    �����Լ� ����
--1. ���� �Լ� ����
create or replace function job_emp(vename in emp.ename%type)
    return varchar2    --������ ���� �ڷ��� 
is
    vjob emp.job%type; --���� ����
begin
    select job into vjob from emp where ename = vename;
    return vjob;
end;

--2. ���� �Լ� ��� Ȯ��
select * from user_source;

--3. ���ε� ���� ����
variable var_job varchar2(10);

--4. ���� �Լ� ����
execute :var_job := job_emp('SCOTT');
print var_job;

-- ���� �Լ��� SQL���� �����ؼ� ����
select ename, job_emp('SCOTT') from emp where ename = 'SCOTT';

--------------------------------------------------------------------------------------
--Ŀ��(cursor)
-- : 2�� �̻��� �����͸� ó���Ҷ� Ŀ���� �����.
-- �ݺ����� �����ؼ� ó���Ѵ�.Ŀ���� �����͸� 1���� �������� ������ ��

--Q1. �μ� ���̺��� ��� �����͸� ����ϱ� ���� PL/SQL�� �ۼ��ϼ���.
--1. ���� ���ν��� ����
set SERVEROUTPUT ON
create or replace procedure cursor_sample01
is
    vdept dept%rowtype;             --���� ����
    
    cursor c1                       --Ŀ�� ����
    is
    select * from dept;             --Ŀ�� ���� ���� ����
begin
    DBMS_OUTPUT.PUT_LINE('�μ���ȣ / �μ��� / ������');
    DBMS_OUTPUT.PUT_LINE('-----------------------');
    
    open c1;                        --Ŀ�� ����
        loop
            fetch c1 into vdept.deptno, vdept.dname, vdept.loc; --����
            exit when c1%notfound;  --notfonud: Ŀ���� ������ �����Ͱ� ������ true�� �Ǿ� loop�� ����
    DBMS_OUTPUT.put_line(vdept.deptno||'/'||vdept.dname||'/'||vdept.loc);
        end loop;
    close c1;                       --Ŀ�� �ݱ�    
end;

--2. ���ν��� ��� Ȯ��
select * from user_source;

--3. ���ν��� ����
execute cursor_sample01;

--Q2. �μ� ���̺��� ��� ������ ����ϱ� : For Loop������ ó��
-- 1. open ~ fetch ~ close ���� ó���� �� �ִ�.
-- 2. for loop���� ����ϰ� �Ǹ� �� �ݺ�������, cursor ����, �� ����
--    ����(fetch)�ϰ�, close�� Ŀ���� �ݴ� �۾��� �ڵ����� ó�����ش�.

--1. ���� ���ν��� ����
create or replace procedure cursor_sample02
is
    vdept dept%rowtype;         --���ú���
    
    cursor c1                   --Ŀ������
    is 
    select * from dept;
begin
    DBMS_OUTPUT.PUT_LINE('�μ���ȣ / �μ��� / ������');
    DBMS_OUTPUT.PUT_LINE('-----------------------');
    
    for vdept in c1 loop
        exit when c1%notfound;  --notfonud: Ŀ���� ������ �����Ͱ� ������ true�� �Ǿ� loop�� ����
    DBMS_OUTPUT.put_line(vdept.deptno||'/'||vdept.dname||'/'||vdept.loc);
    end loop;

end;

--2. ���ν��� ��� Ȯ��
select * from user_source;

--3. ���ν��� ����
execute cursor_sample02;

--Q3. �μ���ȣ�� �����Ͽ� �ش� �μ��� �Ҽӵ� ����� ������ ����ϴ� ���ν�����
--    Ŀ���� �̿��ؼ� ó���ϼ���?
--1. ���� ���ν��� ����
create or replace procedure info_emp(vdeptno in emp.deptno%type)
is
    vemp emp%rowtype;       --���ú���
    
    cursor c1
    is
    select * from emp where deptno = vdeptno;
begin
    DBMS_OUTPUT.PUT_LINE('�μ���ȣ / �����ȣ / ����� / ���� / �޿�');
    DBMS_OUTPUT.PUT_LINE('-------------------------------------');
    for vemp in c1 loop
        exit when c1%notfound;
    DBMS_OUTPUT.put_line(vemp.deptno||'/'||vemp.empno||'/'||vemp.ename||'/'||vemp.job||'/'||vemp.sal);
        
    end loop;
end;

--2. ���ν��� ��� Ȯ��
select * from user_source;

--3. ���ν��� ����
execute info_emp(10);
execute info_emp(20);
execute info_emp(30);
execute info_emp(40); --40�� �μ��� ���� ������ ���� �ȳ���

-------------------------------------------------------------------------------
-- ��Ű��(package) = ���� �Լ� + ���� ���ν���

--1. ��Ű�� ��� ����
create or replace package exam_pack
is
    function cal_bonus(vempno in emp.empno%type) --���� �Լ�
        return number;
    procedure cursor_sample02;                   --���� ���ν���
end;

--2. ��Ű�� �ٵ� ����
create or replace package body exam_pack
is
    --���� �Լ� : cal_bonus()
    function cal_bonus(vempno in emp.empno%type)
        return number     -- ������ ���� �ڷ���
    is
        vsal number(7,2); -- local ���� (����ο��� ����� ����)
    begin
        select sal into vsal from emp where empno = vempno;
        return vsal * 2;
    end;
    
    --���� ���ν��� : cursor_sample02
    procedure cursor_sample02
    is
        vdept dept%rowtype;         --���ú���
    
        cursor c1                   --Ŀ������
        is 
        select * from dept;
    begin
        DBMS_OUTPUT.PUT_LINE('�μ���ȣ / �μ��� / ������');
        DBMS_OUTPUT.PUT_LINE('-----------------------');
    
        for vdept in c1 loop
            exit when c1%notfound;  --notfonud: Ŀ���� ������ �����Ͱ� ������ true�� �Ǿ� loop�� ����
        DBMS_OUTPUT.put_line(vdept.deptno||'/'||vdept.dname||'/'||vdept.loc);
        end loop;
    end;
end;

--3. ���� ���ν��� ���� : cursor_sample02
execute exam_pack.cursor_sample02;

--4. ���� �Լ� ���� : cal_bonus()
--���ε� ���� ����
variable var_res number;
execute :var_res := exam_pack.cal_bonus(7788);
print var_res;

--SQL������ �����Լ� ����
select ename, exam_pack.cal_bonus(7788) from emp where empno = 7788;

----------------------------------------------------------------------------------
--Ʈ����(trigger)

--Q1. ��� ���̺��� ����� ��ϵǸ�, "���Ի���� �Ի��߽��ϴ�."�� ����ϴ�
--    Ʈ���Ÿ� ���� �ϼ���?
--1. emp01 ���̺� ����
drop table emp01 purge;
create table emp01(
    empno number(4) primary key,    --�θ�Ű
    ename varchar(20),
    job varchar(20) );
select * from tab;

--2. Ʈ���� ����

create or replace trigger trg_01
    after insert on emp01           --�̺�Ʈ �߻�
begin 
    DBMS_OUTPUT.PUT_LINE('���Ի���� �Ի��߽��ϴ�.');
end;

--3. Ʈ���� ��� Ȯ��
select * from user_triggers;

--4. �̺�Ʈ �߻� : emp01 ���̺� ������ �Է�
set SERVEROUTPUT ON
insert into emp01 values(1111, 'ȫ�浿', '������');



--Q2. ������̺�(EMP01)�� ���Ի���� ����ϸ�, �޿� ���̺�(SAL01)�� �޿� ������
--    �ڵ����� �߰����ִ� Ʈ���Ÿ� ���� �ϼ���?
--1. ��� ���̺� ����: EMP01
delete from emp01;
commit;

--2. �޿� ���̺� ���� : SAL01
create table sal01(
    salno number(4) primary key,                --�⺻Ű
    sal number(7,2),
    empno number(4) references emp01(empno) );  --�ܷ�Ű(foreign key)
    
    
select * from tab;

--3. ������ ����
create sequence sal01_salno_seq;                --1���� 1�� �����Ǵ� ������ ������

--4. Ʈ���� ����
create or replace trigger trg_02
    after insert on emp01                       --�̺�Ʈ �߻�
    for each row                                --�෹�� Ʈ����
begin
    insert into sal01 values(sal01_salno_seq.nextval, 100, :new.empno); 
    --:new.empno�� �ӽ����̺������ �θ� ���̺��� �θ�Ű(primary key) empno���� �޾ƿ�
end;

--5. Ʈ���� ��� Ȯ��
select * from user_triggers;

--6. �̺�Ʈ �߻�
insert into emp01 values(1111, 'ȫ�浿', '������');
insert into emp01 values(1112, '�ű浿', '������');
insert into emp01 values(1113, '���浿', '������');

--7. ������ Ȯ��
select * from emp01;
select * from sal01;

--Q3. ȸ�������� �����Ǹ�, �޿� ������ �ڵ����� �����ϴ� Ʈ���Ÿ� �����ϼ���.
delete from emp01 where empno = 1111;  --���� �ȵ�: �ڽ��� �θ� �����ϰ� �ֱ� ������
                                            --     ���� foreign key�������� ������ on delete cascade �ɼ� �����
                                            --     �׷��� Ʈ���� �����ϸ� ��������
--1. Ʈ���� ����
create or replace trigger trg_03
    after delete on emp01               --�̺�Ʈ �߻�
    for each row
begin
    delete from sal01 where empno = :old.empno;
end;

--2. Ʈ���� ��� Ȯ��
select * from user_triggers;

--3. �̺�Ʈ �߻�
-- : ��� ���̺�(emp01)�� �����ȣ 1111�� ����� ����(Ż��)�ϸ� ����������
--   �޿� ���̺�(sal01)�� �޿� ������ ���� �����ȴ�.
delete from emp01 where empno = 1111;
delete from emp01 where empno = 1112;
delete from emp01 where empno = 1113;

--4. ��� Ȯ��
select * from emp01;
select * from sal01;