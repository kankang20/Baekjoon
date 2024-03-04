
""" 실버 3. 구간 합 구하기 4 """

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())

    numbers = list(map(int, input().split()))
    table = [0] * (N+1)

    previous = 0
    for idx in range(N):
        previous += numbers[idx]
        table[idx+1] = previous

    for _ in range(M):
        s, t = map(int, input().split())
        print(table[t] - table[s-1])

solution()