
"""
title  : 1052. 물병 (Gold 5)
time   : 2648ms     3408ms
memory : 31120KB    110272KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N, K = map(int, input().split())

    # print(type(bin(N)))     # str

    answer = 0
    while bin(N).count("1") > K:
        N += 1
        answer += 1

    return answer

print(solution())