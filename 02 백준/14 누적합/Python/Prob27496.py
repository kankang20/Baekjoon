
"""
title  : 27496. 발머의 피크 이론 (Silver 3)
time   : 380ms          312ms
memory : 112316KB       213180KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N, L = map(int, input().split())
    drink = list(map(int, input().split()))

    total = 0
    answer = 0
    for idx in range(N):
        total += drink[idx]
        if L <= idx:
            total -= drink[idx-L]
        if 129 <= total <= 138:
            answer += 1

    return answer

print(solution())