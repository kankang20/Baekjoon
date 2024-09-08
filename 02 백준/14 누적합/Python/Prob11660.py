
"""
title  : 11660. 구간 합 구하기 5 (Silver 1)
time   : 656ms          276ms
memory : 105932KB       129216KB
"""

import sys

def solution():

    input = sys.stdin.readline
    N, M = map(int, input().split())        # 표의 크기 N, 합을 구해야 하는 횟수 M
    table = [list(map(int, input().split())) for _ in range(N)]

    matrix = [[0] * (N+1) for _ in range(N+1)]
    for i in range(1, N+1):
        for j in range(1, N+1):
            matrix[i][j] = matrix[i-1][j] + matrix[i][j-1] - matrix[i-1][j-1] + table[i-1][j-1]

    for _ in range(M):
        x1, y1, x2, y2 = map(int, input().split())
        print(matrix[x2][y2] - matrix[x2][y1-1] - matrix[x1-1][y2] + matrix[x1-1][y1-1])

solution()