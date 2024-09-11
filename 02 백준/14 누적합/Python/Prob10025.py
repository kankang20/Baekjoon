
"""
title  : 10025. 게으른 백곰 (Silver 3)
time   : 288ms     132ms
memory : 49820KB   126036KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N, K = map(int, input().split())

    record = [0] * 1000001
    idx = 0

    for _ in range(N):
        g, x = map(int, input().split())
        record[x] = g
        idx = max(idx, x)

    count = sum(record[:2*K+1])
    answer = count

    for i in range(K+1, idx-K+1):
        count += (record[i+K] - record[i-K-1])
        answer = max(answer, count)

    return answer

print(solution())