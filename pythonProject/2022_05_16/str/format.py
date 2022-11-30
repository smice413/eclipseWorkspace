# 문자열 포맷팅
# 문자열에서 변화는 값을 나타내는 포맷 문자열은 % 기호를 사용한다.

#   포맷 문자열                설명
#--------------------------------------------------------------
#     %s                     문자열(string) 출력
#     %c                     문자나 기호 1개(character) 출력
#     %d                     정수 출력
#     %f                     실수 출력
#     %%                     '%' 라는 기호 자체를 출력

txt1 = '자바'; txt2 = '파이썬'
num1 = 5; num2 = 10

print('나는 %s보다 %s에 더 익숙합니다.' %(txt1, txt2))
print('%s은 %s보다 %d배 더 쉽습니다.' %(txt2, txt1, num1))
print('%d + %d = %d' %(num1, num2, num1+num2))
print('작년 세계 경제 성장율은 전년에 비해 %d%% 포인트 증가했다.' %num1)


