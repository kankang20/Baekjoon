
"""
title  : 11478. 서로 다른 부분 문자열의 개수 (Silver 3)
time   : 432ms      564ms
memory : 240872KB   317976KB
"""

import sys

input = sys.stdin.readline

def solution():

    N = input().strip()     # 문자열

    answer = set()
    length = len(N)

    for i in range(length):
        for j in range(i+1, length+1):
            answer.add(N[i:j])

    print(len(answer))

solution()