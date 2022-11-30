# calendar 모듈

import calendar

# calendar()함수는 해당 연도의 달력을 구해주는 함수
cal = calendar.calendar(2020)
print(cal)

# prcal()함수는 2020년 달력을 출력해줌
calendar.prcal(2020)

# prmonth() : 특정 연도의 특정 월의 달력을 출력함
calendar.prmonth(2020, 11)

# weekday() : 날짜에 해당하는 요일 정보를 리턴
# 월(0), 화(1), 수(2), 목(3), 금(4), 토(5), 일(6)
weekday = calendar.weekday(2020, 11, 24)
print('요일:', weekday)           # 1

# 숫자(0~6) 요일을 문자 요일로 변환
week = ['월','화','수','목','금','토','일']
print(week[weekday],'요일')       # 화 요일
