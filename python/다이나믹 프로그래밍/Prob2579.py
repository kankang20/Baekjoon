
""" 실버 3. 계단 오르기 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())
    stair = [int(input()) for _ in range(N)]

    if N <= 2:
        return sum(stair)

    table = [0] * N
    table[0] = stair[0]
    table[1] = stair[0] + stair[1]
    table[2] = max(stair[0] + stair[2], stair[1] + stair[2])

    for idx in range(3, N):
        table[idx] = max(table[idx-3] + stair[idx-1] + stair[idx], table[idx-2] + stair[idx])

    return table[N-1]

print(solution())