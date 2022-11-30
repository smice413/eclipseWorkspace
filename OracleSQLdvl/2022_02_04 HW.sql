--22.02.04 HW(��)

--------------------------------------------------------------------------------
--Q. ��� ���̺��� ������� �˻��Ͽ� ����� ������ ���ؿ��� ���� ���ν�����
--   ���� �ϼ���?
--���ν��� ����
create or replace procedure job_ename(
            vename in emp.ename%type,
            vjob out emp.job%type)
is
begin
    select job into vjob from emp
        where ename = vename;
end;
--���ν��� ��� Ȯ��
select * from user_source;

--���ε� ���� ����
variable var_job varchar2(14);

--���ν��� ����
execute job_ename('SCOTT', :var_job);
print var_job;



--���
--����.
--��� ���̺��� ������� �˻��Ͽ� ����� ������ ���ؿ��� ���� ���ν����� ���� �����ϼ���?

--1. ���� ���ν��� ����
create or replace procedure ename_job(
        vename in emp.ename%type,
        vjob out emp.job%type)
is
begin
    select job into vjob from emp where ename = vename;
end;

--2. ���ν��� ��� Ȯ��
select * from  user_source;

--3. ���ε� ���� ����
variable var_job varchar2(10);

--4. ���ν��� ����
execute ename_job('SCOTT', :var_job); 
execute ename_job('KING', :var_job); 
execute ename_job('SMITH', :var_job); 

--5. ���ε� ������ ���� �� ���
print var_job;