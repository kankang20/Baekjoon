
"""
title  : 11656. 접미사 배열 (Silver 4)
time   : 44ms        116ms
memory : 31120KB     109108KB
"""

import sys

def solution():
    input = sys.stdin.readline

    word = input().rstrip()

    answer = []
    for idx in range(len(word)):
        answer.append(word[idx:])

    for ans in sorted(answer):
        print(ans)

solution()