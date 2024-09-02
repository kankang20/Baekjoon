
"""
title  : 2005. 파스칼의 삼각형 (D2)
time   : 110ms
memory : 44816kb
"""

def solution():

    T = int(input())
    for tc in range(1, T+1):

        N = int(input())
        number = [[1] * idx for idx in range(1, N+1)]

        for idx in range(2, N):
            for jdx in range(1, idx):
                number[idx][jdx] = number[idx-1][jdx-1] + number[idx-1][jdx]

        print(f'#{tc}')
        for idx in range(N):
            print(*number[idx], sep=" ")

solution()