# 딕셔너리의 정렬 : sorted() 함수
# 딕셔너리의 key(아기이름)를 이용해서 오름차순, 내림차순 정렬?
# 딕셔너리의 value(출생아수)를 이용해서 오름차순, 내림차순 정렬?

# { 'key ' : 'value' } = { '아기이름' : 출생아수 }
names = {'Mary':10999, 'Sams':2111, 'Aimy':9778, 'Tom':20245 , 'Michale':27115,
         'Bob':5887, 'Kelly':7855}

#----------------------------------------------------------------------
# 딕셔너리의 key를 리턴하는 함수
def f1(x):              #f1()함수는 x[0]으로 key값 리턴함
    return x[0]

# 딕셔너리의 value를 리턴하는 함수
def f2(x):              ##f2()함수는 x[1]으로 value값 리턴함
    return x[1]
# 정렬하는 방식에는 위의 f1, f2함수 말고도 lamda(이름이 없는 한 줄 짜리 함수) 함수를 호출하여 정렬하기도 한다. key값으로 정렬하는 것은
# 별도의 함수가 필요 없을 수도 있지만 value값을 정렬할 때는 반드시 f1,f2,lamda함수가 필요하다.

# 1. 딕셔너리의 key(아기이름)를 이용해서 오름차순
result1 = sorted(names)                 #sorted 함수는 정렬하는 함수로 원본이 바뀌지 않는다.
print('result1:', result1)              # ['Aimy', 'Bob', 'Kelly', 'Mary', 'Michale', 'Sams', 'Tom']

result2 = sorted(names.items(), key=f1) # names.items() items()함수는 key, value를 한번에 구해줌
print('result2:', result2)              # [('Aimy', 9778), ('Bob', 5887), ('Kelly', 7855), ('Mary', 10999), ('Michale', 27115), 'Tom']

# 2. 딕셔너리의 key(아기이름)를 이용해서 내림차순
result3 = sorted(names, reverse=True)
print('result3:', result3)              # ['Tom', 'Sams', 'Michale', 'Mary', 'Kelly', 'Bob', 'Aimy']

result4 = sorted(names.items(), reverse=True , key=f1) #key=f1 key를 가지고 f1함수인 key값을 호출하라는 의미
print('result4:', result4)              # [('Tom', 20245), ('Sams', 2111), ('Michale', 27115), ('Mary', 10999), ('Kelly', 7855)y']

# 3. 딕셔너리의 value(출생아수)를 이용해서 오름차순
result5 = sorted(names.items(), key=f2) #key=f2 key를 가지고 f2함수인 value값을 호출하라는 의미
print('result5:', result5)              # [('Sams', 2111), ('Bob', 5887), ('Kelly', 7855), ('Aimy', 9778), ('Mary', 10999),

# 4. 딕셔너리의 value(출생아수)를 이용해서 내림차순
result6 = sorted(names.items(), reverse=True , key=f2)
print('result6:', result6)              # [('Michale', 27115), ('Tom', 20245), ('Mary', 10999), ('Aimy', 9778), ('Kelly', 7855)