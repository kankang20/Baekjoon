
"""
title  : 5648. 역원소 정렬 (Silver 5)
time   : 56ms        136ms
memory : 32140KB     110424KB
"""

import sys

def solution():
    input = sys.stdin.readline

    numbers = list(input().rstrip().split())

    N = int(numbers[0])
    length = len(numbers) - 1

    while length < N:

        temp = list(input().rstrip().split())
        length += len(temp)

        numbers.extend(temp)

    answer = []

    for num in numbers[1:]:

        temp = ""
        idx = len(num) - 1
        
        while idx >= 0:
            temp += num[idx]
            idx -= 1

        answer.append(int(temp))

    for ans in sorted(answer):
        print(ans)

solution()