
"""
title  : 15688. 수 정렬하기 5 (Silver 5)
time   : 20664ms      12192ms
memory : 83812KB      137356KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())
    numbers = [int(input()) for _ in range(N)]

    for num in sorted(numbers):
        print(num)

solution()