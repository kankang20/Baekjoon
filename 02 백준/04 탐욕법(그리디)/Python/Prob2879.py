
"""
title  : 2879. 코딩은 예쁘게 (Gold 3)
time   : 
memory : 
"""

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())
    current = list(map(int, input().split()))
    target = list(map(int, input().split()))

    answer = 0
    now, idx = 0, 0
    while idx < N:
        now = target[idx] - current[idx]
        day = abs(now)
        while idx < N-1 and check(now, target[idx+1] - current[idx+1]):
            day = max(day, abs(target[idx+1] - current[idx+1]))
            idx += 1
        answer += day
        idx += 1

    return answer

def check(num1, num2):
    if (num1 > 0 and num2 > 0) or (num1 < 0 and num2 < 0):
        return True
    return False

print(solution())