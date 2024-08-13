
"""
title  : 1654. 랜선 자르기 (Silver 2)
time   : 68ms       124ms
memory : 31256KB    115000KB
"""

import sys

input = sys.stdin.readline
K, N = map(int, input().split())            # 이미 가지고 있는 랜선 개수 K, 필요한 랜선 개수 N
lines = [int(input() ) for _ in range(K)]   # 가지고 있는 각 랜선의 길이 

def solution(start, end):
    
    while start <= end:
        mid = (start + end) // 2

        total = 0
        for i in lines:
            total += (i // mid)

        if total < N:
            end = mid - 1
        else:
            start = mid + 1
    
    return start - 1

print(solution(1, max(lines)))