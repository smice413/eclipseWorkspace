--2022.01.21 ����

--����.
--      Q1. ������̺�(EMP)���� �Ի���(HIREDATE)�� 4�ڸ� ������ ��� 
--           �ǵ��� SQL���� �ۼ��ϼ���? (ex. 1980/01/01)
select * from emp;
select ename,hiredate,to_char(hiredate, 'yyyy/mm/dd') as "HIREDATE01" from emp;

--
--     Q2. ������̺�(EMP)���� MGR�÷���  ����  null �� �������� MGR�� 
--          ����  CEO ��  ����ϴ� SQL���� �ۼ� �ϼ���?
select * from emp;
select ename,mgr,nvl(to_char(MGR), 'CEO') as "MGR01" from emp;


--���.

--     Q1. ������̺�(EMP)���� �Ի���(HIREDATE)�� 4�ڸ� ������ ���                                
--           �ǵ��� SQL���� �ۼ��ϼ���? (ex. 1980/01/01)
--
--     Q2. ������̺�(EMP)���� MGR�÷���  ����  null �� �������� MGR                              
--          �÷��� ����  CEO ��  ����ϴ� SQL���� �ۼ� �ϼ���?     


     Ans1. SQL> select  to_char(hiredate,'YYYY/MM/DD') from emp;

     Ans2. SQL> select ename, nvl(to_char(mgr,'9999'), 'CEO')  	         	                               
                    as	 MANAGER  from emp where mgr  is  null;



--
--     Q3. ��� ���̺�(EMP)���� ���� �ֱٿ� �Ի��� ������� ��� �ϴ� 
--           SQL���� �ۼ� �ϼ���?
--
--     Q4. ��� ���̺�(EMP)���� �ִ� �޿��� �޴� ������ �ִ�޿�
--           �ݾ��� ����ϴ� SQL���� �ۼ� �ϼ���?