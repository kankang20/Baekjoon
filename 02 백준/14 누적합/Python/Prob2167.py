
"""
title  : 2167. 2차원 배열의 합 (Silver 5)
time   : 280ms        196ms
memory : 37028KB      112532KB
"""

import sys

def solution():
    
    input = sys.stdin.readline
    N, M = map(int, input().split())
    array = [list(map(int, input().split())) for _ in range(N)]

    prefix_sum = [[0] * M for _ in range(N)]

    for r in range(N):
        prefix_sum[r][0] = array[r][0]
        for c in range(1, M):
            prefix_sum[r][c] = prefix_sum[r][c-1] + array[r][c]

    K = int(input())
    
    for _ in range(K):
        i, j, x, y = map(int, input().split())
        print(search(prefix_sum, i, j, x, y))


def search(prefix_sum, i, j, x, y):

    total_sum = 0

    for idx in range(i-1, x):
        total_sum += (prefix_sum[idx][y-1] if j == 1 else prefix_sum[idx][y-1] - prefix_sum[idx][j-2])
    
    return total_sum


solution()