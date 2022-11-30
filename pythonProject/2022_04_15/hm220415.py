# 과제.
# 1. 1~ 12월 중에서 달(Month)에'r'이 들어있는 달(Month)을 출력하는 프로그램을 작성하세요?
#
# months = ("January", "February", "March", "April", "May", "June",
#           "July", "August", "September", "October", "November", "December")
#
# giduck23 @ naver.com 로 제출

t = ("January", "February", "March", "April", "May", "June", "July"
     , "August", "September", "October", "November", "December")

for i in range(0, 12):
    if 'r' in t[i]:
        print(t[i])


