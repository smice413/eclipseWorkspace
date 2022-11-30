# 1 ~ 12월을 3자리 약어로 출력하는 프로그램 작성
#  ex) January  ->  Jan

months = ['January','February','March','April','May','June',
          'July','August','September','October','November','December']

#        range(12) : 길이가 12(len은 문자열의 길이를 구해옴)
# 인덱싱과 슬라이싱을 같이 써야해결할 수 있다.
for i in range(len(months)):    # 0 ~ 11
    months[i] = months[i][:3]
    # print(months[i])
    # print(months[i][:3])

print(months)