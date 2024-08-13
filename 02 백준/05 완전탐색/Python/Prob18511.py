
"""
title  : 18511. 큰 수 구성하기 (Silver 5)
time   : 48ms        116ms
memory : 32140KB     110920KB
"""

import sys
from itertools import product

def solution():

    input = sys.stdin.readline

    N, K = map(int, input().split())       
    numbers = list(input().split())

    answer = 0
    maxLength = len(str(N))

    while maxLength > 0:

        for p in list(product(numbers, repeat=maxLength)):
            
            temp = int("".join(p))

            if temp <= N and temp > answer:
                answer = temp

        if answer:
            break
        else:
            maxLength -= 1

    return answer

print(solution())