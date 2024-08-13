
"""
title  : 1753. 최단경로 (Gold 4)
time   : 532ms       480ms
memory : 68380KB     135544KB
"""

import sys
from heapq import heappush, heappop

def solution():
    input = sys.stdin.readline

    V, E = map(int, input().split())        # 정점 개수 V, 간선 개수 E
    snode = int(input())                    # 시작정점

    edge = [[] for _ in range(V+1)]
    for _ in range(E):
        u, v, w = map(int, input().split())     # u에서 v로 가는 가중치는 w
        edge[u].append((v, w))

    table = [1e9] * (V+1)

    def dijkstra(table):

        q = []

        heappush(q, (0, snode))
        table[snode] = 0

        while q:

            dis, node = heappop(q)

            if table[node] < dis:
                continue

            for e in edge[node]:
                cost = dis + e[1]
                if cost < table[e[0]]:
                    table[e[0]] = cost
                    heappush(q, (cost, e[0]))

    dijkstra(table)

    for t in table[1:]:
        print('INF' if t == 1e9 else t)

solution()