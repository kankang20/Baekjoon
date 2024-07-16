
""" 골드 4. 마법사 상어와 파이어볼 """

import sys


def solution():
    input = sys.stdin.readline

    N, M, K = map(int, input().split())
    
    fireballs = []
    for _ in range(M):
        r, c, m, d, s = map(int, input().split())
        fireballs.append((r-1, c-1, m, d, s))

    

    


print(solution())