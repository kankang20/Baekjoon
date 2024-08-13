
"""
title  : 1541. 잃어버린 괄호 (Silver 2)
time   : 44ms        108ms
memory : 31120KB     108080KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N = input().rstrip().split("-")      # 문제의 핵심은 - 

    answer = sum(map(int, N[0].split("+")))
    for nm in N[1:]:
        answer -= sum(map(int, nm.split("+")))

    return answer

print(solution())
