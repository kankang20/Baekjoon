
"""
title  : 2012. 등수 매기기 (Silver 3)
time   : 364ms        292ms
memory : 56412KB      122148KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())
    grade = sorted([int(input()) for _ in range(N)])

    answer = 0
    for idx in range(N):
        answer += abs(idx + 1 - grade[idx])

    return answer

print(solution())