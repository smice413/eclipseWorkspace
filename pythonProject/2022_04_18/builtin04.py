# 내장 함수 : format()

# format(데이터, 서식형식)
print(4)
print(format(4, '10d'))         #d는 정수라는 의미, 정수를 출력하는 10자리
print(format(4.3, '10.3f'))     #실수를 출력하는 전체 10자리, 소숫점 이하 3자리
print(format(42.195, '.3f'))    #소숫점 3자리까지 출력: 42.195로 출력됨.
                                # 만약 42.195678에 대한 값을 소숫점3자리 출력하면 6이 5이상으로 반올림되기 때문에 42.196이 출력됨
print(format('안녕하세요', 's'))  #s는 문자라는 의미

#{숫자}와 format()함수를 이용한 데이터 매핑
print('{0} is {1}'.format('Python','fun')) #Python is fun이 출력됨
print('{} is {}'.format('Python','fun'))   #Python is fun이 출력됨
print('{1} is {0}'.format('Python','fun')) #fun is Python이 출력됨

# 키보드로 입력한 문자를 format()함수로 출력

name = input('이름을 입력하세요?')
job = input('직업을 입력하세요?')

print('{0} is a {1}'.format(name, job))      # 홍길동 is a 의적
print('{} is a {}'.format(name, job))        # 홍길동 is a 의적
print('{1} is a {0}'.format(name, job))      # 의적 is a 홍길동
print('{j} is a {n}'.format(n=name, j=job))  # 의적 is a 홍길동

