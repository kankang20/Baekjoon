
""" 실버 1. 지름길 """

import sys

def solution():
    input = sys.stdin.readline

    N, D = map(int, input().split())

    short = []
    for _ in range(N):
        start, end, length = map(int, input().split())
        short.append((start, end, length))
    
    short.sort(key=lambda x : (x[0], x[2], x[1]))

    print(short)

    # ans = 0
    # pos, idx = 0
    # while pos < D:






print(solution())