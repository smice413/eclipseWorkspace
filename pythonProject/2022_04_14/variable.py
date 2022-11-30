# 변수 : 메모리상에 데이터를 저장하기 위한 기억공간의 이름
# 변수 만드는 방법 : 변수명 = 값(데이터)

# 정수형 변수
i=10
print('i=', i)   # i= 10
print(type(i))   # <class 'int'>

# 실수형 변수
r= 3.14
print('r=', r)
print(type(r)) #<class 'float'>

# 복소수형 변수
c= 3+ 5j
print('c=', c)
print(type(c)) #<class 'complex'>

# 논리형 변수
b1 = True      # 첫 캐릭터를 대문자로 작성
b2 = False
print('b1=', b1)
print('b2=', b2)
print(type(b1)) #<class 'bool'>
print(type(b2)) #<class 'bool'>

# 문자형 변수
s1 = "파이썬"
s2 = 'python'
print('s1=', s1)
print('s2=', s2)
print(type(s1)) #<class 'str'>
print(type(s2)) #<class 'str'>

# 리스트(list)
list = ['빨강','주황','노랑','초록','파랑','남색','보라']
print(list[0])      #인덱싱 : 빨강
list[0] = 'red'     #빨강을 red로 수정
print('list=', list) #  ['red', '주황', '노랑', '초록', '파랑', '남색', '보라']
print(type(list))    #<class 'list'>

# 튜플(tuple)
t = ('red','orange','yellow','blue','navy','puple')
print(t[0]) # 인덱싱 : red
#t[0] ='빨강'  수정안됨 오류발생함. 튜플은 값을 수정할 수 없다.
print('t=', t) # t= ('red', 'orange', 'yellow', 'blue', 'navy', 'puple')
print(type(t)) #<class 'tuple'>

# 집합(set)
s = set([1,2,3,3])
print('s=', s) #s= {1, 2, 3} 중복된 값을 저장 안함
print(type(s)) #<class 'set'>

# 딕셔너리(dictionary) : {'key' : 'value'}
d = {'네이버' : 'http://www.naver.com',
     '구글' : 'http://www.google.com',
     '애플' : 'http://www.apple.com' }
print('d=', d)
print(type(d)) #<class 'dict'>


