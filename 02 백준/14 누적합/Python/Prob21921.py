
"""
title  : 21921. 블로그 (Silver 3)
time   : 136ms        184ms
memory : 58784KB      172184KB
"""

import sys

def solution():

    input = sys.stdin.readline
    N, X = map(int, input().split())
    visitors = list(map(int, input().split()))

    prefix_sum = [visitors[0]]
    for idx in range(1, N):
        prefix_sum.append(prefix_sum[idx-1] + visitors[idx])

    answer = prefix_sum[X-1]
    count = 1

    for idx in range(X, N):
        value = prefix_sum[idx] - prefix_sum[idx-X]
        if answer == value:
            count += 1
        elif answer < value:
            answer = value
            count = 1

    if answer:
        print(answer, count, sep="\n")
    else:
        print("SAD")

solution()