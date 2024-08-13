
"""
title  : 2417. 정수 제곱근 (Silver 4)
time   : 44ms        116ms
memory : 31256KB     113112KB
"""

import sys

input = sys.stdin.readline
N = int(input())

def solution(start, end):

    answer = 0

    while start <= end:
        mid = (start + end) // 2

        if mid * mid < N:
            start = mid + 1
        else:
            answer = mid
            end = mid - 1

    return answer

print(solution(0, N))