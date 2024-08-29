
"""
title  : 2072. 홀수만 더하기 (D1)
time   : 100ms
memory : 42696kb
"""

def solution():

    T = int(input())
    for tc in range(1, T+1):

        answer = 0
        for number in list(map(int, input().split())):
            if number % 2:
                answer += number

        # print("#{0} {1}".format(t, answer))
        print(f'#{tc} {answer}')

solution()