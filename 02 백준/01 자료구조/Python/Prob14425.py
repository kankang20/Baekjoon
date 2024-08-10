
"""
title  : 14425. 문자열 집합 (Silver 4)
time   : 116ms       276ms
memory : 36680KB     116136KB
"""

import sys

def solution():

    input = sys.stdin.readline
    N, M = map(int, input().split())

    answer = 0

    check_string = set()
    for _ in range(N):
        check_string.add(input().rstrip())

    for _ in range(M):
        check = input().rstrip()
        if check in check_string:
            answer += 1
    
    return answer

print(solution())
