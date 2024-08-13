
"""
title  : 2512. 예산 (Silver 2)
time   : 52ms        120ms
memory : 32276KB     114328KB
"""

import sys

input = sys.stdin.readline
N = int(input())                            # 지방 수
budget = list(map(int, input().split()))    # 예산
maxBudget = int(input())                    # 총 예산


def solution(start, end):
    answer = 0

    while start <= end:

        mid = (start + end) // 2

        total = 0
        for b in budget:
            if mid < b: total += mid
            else: total += b

        if total == maxBudget:
            return mid
        elif total < maxBudget:
            answer = mid
            start = mid + 1
        else:
            end = mid - 1

    return answer


print(solution(0, max(budget)))