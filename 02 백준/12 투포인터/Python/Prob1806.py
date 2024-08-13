
"""
title  : 1806. 부분합 (Gold 4)
time   : 72ms       112ms
memory : 42204KB    120932KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N, S = map(int, input().split())
    number = list(map(int, input().split()))

    start, end = 0, 0
    sum = 0

    answer = N+1
    while True:
        
        if S <= sum:
            answer = min(answer, end - start)
            sum -= number[start]
            start += 1
        elif end == N:
            break
        else:
            sum += number[end]
            end += 1

    return 0 if answer == (N+1) else answer

print(solution())