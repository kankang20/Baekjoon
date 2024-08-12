
"""
title  : 6284. 바이러스 (Level 2)
time   : 103ms
memory : 37.15MB
"""

import sys

def solution():
    input = sys.stdin.readline

    K, P, N = map(int, input().split())     # 처음 바이러스의 수 K, 증가율 P, 총 시간 N

    print(K * spread(P, N) % 1000000007)

def spread(p:int, n:int):

    if (n == 1):
        return p

    temp = spread(p, n//2)

    if (n % 2 == 0):
        return temp * temp % 1000000007
    else:
        return temp * temp * p % 1000000007

solution()