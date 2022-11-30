# 반복문 : for문

# 키보드로 구구단 1개 단을 입력 받아서 해당 구구단을 출력하는 프로그램 작성

# input으로 keyboard입력을 할 수 있고 앞에 int를 붙여 String형을 int로 자료형 변환함. 따라서 입력값에 문자를 쓰면 오류발생
dan = int(input('원하는 단을 입력하세요?'))

print('[',dan,'단 ]')
for i in range(1, 10):              # 1 ~ 9
    # print(dan, '*', i, '=', dan * i)
    print('{0} * {1} = {2}'.format(dan, i, dan*i))
# format 내장함수에서 설정한 값에 따라 각각 0번 위치인 dan부터 1번 2번위치까지 3가지 모두 출력
