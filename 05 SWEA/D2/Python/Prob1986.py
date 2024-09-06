
"""
title  : 1986. 지그재그 숫자 (D2)
time   : 158ms
memory : 44792kb
"""

def solution():

    T = int(input())
    for tc in range(1, T+1):

        N = int(input())

        answer = -1 * (N // 2)
        if N % 2:
            answer += N

        print(f'#{tc} {answer}')

solution()