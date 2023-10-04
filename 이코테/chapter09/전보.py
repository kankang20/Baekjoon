
""" 예제 9-5) 전보 """

import sys
import heapq

input = sys.stdin.readline
INF = int(1e9)

N, M, C = map(int, input().split())     # 도시 개수 N, 통로 개수 M, 메세지를 보내는 도시 C
graph = [[] for _ in range(N+1)]        # 각 노드에 연결되어 있는 노드들
table = [INF] * (N+1)                   # 최단 거리 테이블

for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

def dijkstra(start):
    q = []

    heapq.heappush(q, (0, start))
    table[start] = 0

    while q:
        
        dist, now = heapq.heappop(q)

        if table[now] < dist:
            continue

        for g in graph[now]:
            cost = dist + g[1]
            if cost < table[g[0]]:
                table[g[0]] = cost
                heapq.heappush(q, (cost, g[0]))

dijkstra(C)

all_city = 0
all_distance = 0

for t in table:
    if t != INF:
        all_city += 1
        all_distance = max(all_distance, t)

print(all_city - 1, all_distance)