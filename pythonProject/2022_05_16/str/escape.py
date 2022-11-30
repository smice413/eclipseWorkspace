# escape 문자
# 1.이스케이프 문자는 프로그래밍을 할때 사용할 수 있도록 미리 정의된 문자조합으로
#   출력물을 보기좋게 정렬하는 용도로 사용된다.
# 2. 이스케이프 문자는 '\'로 시작한다.

#     이스케이프 문자              설명
#-------------------------------------------------------
#        \n                       줄 바꾸기
#        \t                       탭 키로 간격 조절
#        \\                       문자 \ 를 출력
#        \'                       문자 ' 를 출력
#        \"                       문자 " 를 출력

print('나는 파이썬을 사랑합니다.\n 파이썬은 자바보다 쉽습니다.')
print('Name:John Simth\tSex:Male\tAge:22')
print('작은 따옴표(\')와 큰 따옴표(\")는 문자열을 정의할때 사용합니다.')
print('\'python\"')                 # 'python"
print('\\자바\\')                   # \자바\
