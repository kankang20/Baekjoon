
"""
title  : 2068. 최대수 구하기 (D1)
time   : 122ms
memory : 44796kb
"""

def solution():

    T = int(input())
    for tc in range(1, T+1):

        answer = max(list(map(int, input().split())))
        print(f'#{tc} {answer}')

solution()