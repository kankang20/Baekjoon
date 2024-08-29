
"""
title  : 2071. 평균값 구하기 (D1)
time   : 98ms
memory : 44004kb
"""

def solution():

    T = int(input())
    for tc in range(1, T+1):
        answer = round(sum(list(map(int, input().split()))) / 10)
        print(f'#{tc} {answer}')

solution()