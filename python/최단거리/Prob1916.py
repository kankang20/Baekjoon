
""" 골드 5. 최소비용 구하기 """

import sys
from heapq import heappush, heappop

def solution():
    input = sys.stdin.readline

    N = int(input())    # 도시 개수
    M = int(input())    # 버스 개수

    edge = [[] for _ in range(N+1)]
    for _ in range(M):
        u, v, w = map(int, input().split())     # 시작, 도착, 비용
        edge[u].append((v, w))

    snode, enode = map(int, input().split())    # 출발점, 도착점

    table = [1e9] * (N+1)

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

    return table[enode]

print(solution())