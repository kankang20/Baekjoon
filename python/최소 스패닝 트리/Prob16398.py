
""" 골드 4. 행성 연결 """

import sys
from collections import defaultdict
from heapq import heappush, heappop

def prim(N, edges, start):

    heap = []
    connected = [False] * (N)
    selected = defaultdict(list)

    for i, j, count in edges:
        selected[i].append((count, i, j))
        selected[j].append((count, j, i))

    connected[start] = True
    for count, i, j in selected[start]:
        heappush(heap, (count, i, j))

    answer = 0

    while heap:
        count, i, j = heappop(heap)
        if not connected[j]:
            connected[j] = True
            answer += count

            for edge in selected[j]:
                if not connected[edge[2]]:
                    heappush(heap, edge)

    return answer

def solution():

    input = sys.stdin.readline
    N = int(input())

    edges = []
    for i in range(N):
        for (j, cost) in enumerate(list(map(int, input().split()))):
            if cost > 0:
                edges.append((i, j, cost))

    return prim(N, edges, 0)

print(solution())