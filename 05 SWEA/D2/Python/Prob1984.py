
"""
title  : 1984. 중간 평균값 구하기 (D2)
time   : 98ms
memory : 42720kb
"""

def solution():

    T = int(input())
    for tc in range(1, T+1):

        number = sorted(list(map(int, input().split())))
        answer = round(sum(number[1:-1]) / 8)

        print(f'#{tc} {answer}')

solution()