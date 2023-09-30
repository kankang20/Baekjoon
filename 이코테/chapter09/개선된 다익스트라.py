
"""  예제 9-2) 개선된 다익스트라 """

"""
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2

>> 0 2 3 1 2 4
"""

import sys
import heapq

input = sys.stdin.readline
INF = int(1e9)

N, M = map(int, input().split())    # 노드의 개수 N, 간선의 개수 M
start = int(input())                # 시작 노드

graph = [[] for _ in range(N+1)]    # 각 노드에 연결되어 있는 노드에 대한 정보 저장
table = [INF] * (N+1)               # 최단 거리 테이블

for _ in range(M):
    a, b, c = map(int, input().split())     # a -> b의 비용이 c
    graph[a].append((b, c))   


def dijkstra(start):

    q = []

    heapq.heappush(q, (0, start))       
    table[start] = 0                    # 시작 노드를 가기 위한 최단 거리는 0

    while q:

        dist, now = heapq.heappop(q)    # 가장 최단거리가 짧은 노드는?

        if table[now] < dist:           # 이미 처리된적 있는 노드는 더이상 처리하지 않음
            continue

        for g in graph[now]:
            cost = dist + g[1]
            if cost < table[g[0]]:      # 거리를 비교해서 최단 거리 갱신
                table[g[0]] = cost
                heapq.heappush(q, (cost, g[0]))

dijkstra(start)

for i in range(1, N+1):
    if table[i] == INF:
        print(-1, end = " ")
    else:
        print(table[i], end = " ")