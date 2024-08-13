
"""
title  : 11660. 구간 합 구하기 5 (Silver 1)
time   : 시간초과
memory : 
"""

import sys

def solution():

    input = sys.stdin.readline
    N, M = map(int, input().split())        # 표의 크기 N, 합을 구해야 하는 횟수 M

    array = []
    for _ in range(N):
        array.append(list(map(int, input().split())))

    sum_array = [[0] * N for _ in range(N)]
    for idx in range(N):
        sum_array[idx][0] = array[idx][0]
        for jdx in range(1, N):
            sum_array[idx][jdx] = sum_array[idx][jdx-1] + array[idx][jdx]

    for _ in range(M):
        x1, y1, x2, y2 = map(int, input().split())
        
        answer = 0
        for idx in range(x1-1, x2):
            answer += (sum_array[idx][y2-1] - (0 if y1 == 1 else sum_array[idx][y1-2]))

        print(answer)

solution()