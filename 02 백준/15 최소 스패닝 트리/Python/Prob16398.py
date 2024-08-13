
"""
title  : 16398. 행성 연결 (Gold 4)
time   : 1804ms       1104ms
memory : 123148KB     169320KB
"""

import sys
from heapq import heappush, heappop

def prim(N, edges, start):

    heap = []
    connected = [False] * (N)

    heappush(heap, (0, start))
    answer = 0

    while heap:
        count, node = heappop(heap)

        if not connected[node]:

            connected[node] = True
            answer += count

            for idx in range(N):
                if edges[node][idx] != 0 and not connected[idx]:
                    heappush(heap, (edges[node][idx], idx))

    return answer

def solution():

    input = sys.stdin.readline
    N = int(input())

    edges = []
    for _ in range(N):
        edges.append(list(map(int, input().split())))

    return prim(N, edges, 0)

print(solution())