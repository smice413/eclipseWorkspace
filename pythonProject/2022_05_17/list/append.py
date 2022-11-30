# append() : 리스트에 새로운 원소를 추가할 때 사용되는 함수

a = [1, 2, 3]
a.append(4)                 # 4 추가
print('a:', a)              # [1, 2, 3, 4]

#리스트를 추가하여 중첩리스트가 되었다.
a.append([5, 6])            # [5, 6] 추가
print('a:', a)              # [1, 2, 3, 4, [5, 6]]

#-----------------------------------------------------------
listdata = []               # 비어있는 리스트

#i의 초기값이 0이기 때문에 +1을 해서 숫자가 1로 나타나게함 루프는 range함수로 3번 돌림
for i in range(3):          # 0 ~ 2
    text = input('리스트에 추가할 값을 입력하세요?[%d/3]'%(i+1))
    listdata.append(text)
    print(listdata)

print(listdata)

