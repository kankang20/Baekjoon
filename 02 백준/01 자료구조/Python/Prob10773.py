
"""
title  : 10773. 제로 (Silver 4)
time   : 64ms       132ms
memory : 31900KB    114244KB
"""

import sys

def solution():
    input = sys.stdin.readline

    K = int(input())        # 정수 개수

    money = []
    for _ in range(K):
        number = int(input())

        if number:
            money.append(number)
        else:
            money.pop()

    return sum(money)

print(solution())