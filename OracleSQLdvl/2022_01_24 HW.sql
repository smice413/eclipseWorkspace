--2022.01.24 ����

--     Q3. ��� ���̺�(EMP)���� ���� �ֱٿ� �Ի��� ������� ��� �ϴ� 
--           SQL���� �ۼ� �ϼ���?
select ename, hiredate from emp order by hiredate desc;
select ename, hiredate from emp where hiredate = (select max(hiredate) from emp);

--
--     Q4. ��� ���̺�(EMP)���� �ִ� �޿��� �޴� ������ �ִ�޿�
--           �ݾ��� ����ϴ� SQL���� �ۼ� �ϼ���?
select ename, sal from emp where sal = (select max(sal) from emp);

--�ؼ�
--      Q1. ��� ���̺�(EMP)���� ���� �ֱٿ� �Ի��� ������� ��� 
--	         �ϴ� SQL���� �ۼ� �ϼ���?
--
--      Q2. ��� ���̺�(EMP)���� �ִ� �޿��� �޴� ������ �ִ�޿�
--           �ݾ��� ����ϴ� SQL���� �ۼ� �ϼ���?
--    
     Ans1. SQL> select ename, hiredate from emp where hiredate=
		(select max(hiredate) from emp);

     Ans2. SQL> select ename, sal from emp where sal=
		(select max(sal) from emp);
