
"""
title  : 2559. 수열 (Silver 3)
time   : 64ms        104ms
memory : 40156KB     120956KB
"""

import sys

def solution():
    
    input = sys.stdin.readline

    N, K = map(int, input().split())
    record = list(map(int, input().split()))

    count = sum(record[:K])
    answer = count

    for i in range(K, N):
        count += (record[i] - record[i-K])
        answer = max(answer, count)

    print(answer)

solution()