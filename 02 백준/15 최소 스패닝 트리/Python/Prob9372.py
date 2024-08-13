
"""
title  : 9372. 상근이의 여행 (Silver 4)
time   : 56ms       132ms
memory : 31120KB    110272KB
"""

import sys

def solution():
    input = sys.stdin.readline

    T = int(input())
    for _ in range(T):
        
        N, M = map(int, input().split())    # 국가 수 N, 비행기 종류 M
        for _ in range(M):
            input()

        print(N-1)

solution()