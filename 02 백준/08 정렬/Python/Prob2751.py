
"""
title  : 2751. 수 정렬하기 2 (Silver 5)
time   : 1236ms       624ms
memory : 84788KB      137232KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())
    number = [int(input()) for _ in range(N)]

    for num in sorted(number):
        print(num)

solution()