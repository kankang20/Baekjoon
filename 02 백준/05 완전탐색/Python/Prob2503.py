
"""
title  : 2503. 숫자 야구 (Silver 3)
time   : 68ms        140ms
memory : 31120KB     111524KB
"""

import sys

def solution():

    input = sys.stdin.readline

    N = int(input())                # 질문 개수
    number = [False] *  1000        # 111 ~ 999 (0 ~ 888)

    for n in range(N):
        num, strike, ball = map(int, input().split())
        num = str(num)

        for idx in range(111, 1000):
            
            temp = str(idx)

            if temp[0] == temp[1] or temp[0] == temp[2] or temp[1] == temp[2] or temp[1] == '0' or temp[2] == '0':
                continue

            if n == 0:
                number[idx] = check(temp, num, strike, ball)
                continue

            if number[idx]:
                number[idx] = check(temp, num, strike, ball)

    return number.count(True)

def check(answer, input, strike, ball):

    count_strike, count_ball = 0, 0

    for idx in range(3):
        for jdx in range(3):
            if input[idx] == answer[jdx]:
                if idx == jdx: 
                    count_strike += 1
                else: 
                    count_ball += 1

    return strike == count_strike and ball == count_ball

print(solution())