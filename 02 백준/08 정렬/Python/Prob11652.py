
"""
title  : 11652. 카드 (Silver 4)
time   : 104ms       180ms
memory : 42900KB     119496KB
"""

import sys

def solution():
    input = sys.stdin.readline

    numbers = dict()
    ansNum = 0
    ansCnt = 0

    N = int(input())

    for _ in range(N):
        num  = int(input())
        temp = numbers.get(num, 0) + 1

        if ansCnt == temp and num < ansNum:
            ansNum = num
        elif ansCnt < temp:
            ansNum = num
            ansCnt = temp

        numbers[num] = temp

    return ansNum

print(solution())