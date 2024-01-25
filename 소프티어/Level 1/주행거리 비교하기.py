
""" Lv 1. 주행거리 비교하기 """

import sys

def solution():
    input = sys.stdin.readline

    A, B = map(int, input().split())

    if A < B:
        return "B"
    elif A > B:
        return "A"
    else:
        return "same"

print(solution())