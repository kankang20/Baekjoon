
"""
title  : 1931. 회의실 배정 (Silver 1)
time   : 264ms       272ms
memory : 46260KB     118320KB
"""

import sys
from heapq import heappush, heappop

def solution():
    input = sys.stdin.readline

    N = int(input())    # 회의 수
    
    meeting = []
    for _ in range(N):
        start, end = map(int, input().split())
        heappush(meeting, (end, start))

    answer = 0
    previous_time = 0
    while meeting:

        tend, tstart = heappop(meeting)

        if previous_time <= tstart:
            answer += 1
            previous_time = tend

    return answer

print(solution())