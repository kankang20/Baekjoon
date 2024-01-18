
""" 실버 1. 점프 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())
    array = [list(map(int, input().split())) for _ in range(N)]

    selected = [[0] * N for _ in range(N)]

    selected[0][0] = 1
    for r in range(N):
        for c in range(N):

            if r == N-1 and c == N-1:
                break
            
            if c + array[r][c] < N:
                selected[r][c + array[r][c]] += selected[r][c]

            if r + array[r][c] < N:
                selected[r + array[r][c]][c] += selected[r][c]

    return selected[N-1][N-1]

print(solution())