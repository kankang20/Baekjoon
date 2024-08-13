
"""
title  : 1789. 수들의 합 (Silver 5)
time   : 40ms        116ms
memory : 31256KB     113112KB
"""

import sys

input = sys.stdin.readline
S = int(input())

def solution(start, end):
    answer = 0

    while start <= end:
        mid = (start + end) // 2

        if (mid * (mid + 1)) / 2 <= S:
            answer = mid
            start = mid + 1
        else:
            end = mid - 1

    return answer

print(solution(0, S))