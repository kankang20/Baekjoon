
""" 실버 2. 특정 거리의 도시 찾기 """

import sys
from heapq import heappush, heappop

input = sys.stdin.readline
INF = int(1e9)

N, M, K, X = map(int, input().split())      # 도시 개수 N, 도로 개수 M, 거리 정보 K, 출발 도시 번호 X

graph = [[] for _ in range(N+1)]
table = [INF] * (N+1)

for _ in range(M):
    i, j = map(int, input().split())
    graph[i].append(j)

def dijkstra():

    q = []

    heappush(q, (0, X))
    table[X] = 0

    while q:
        cost, now = heappop(q)

        if table[now] < cost:
            continue

        for g in graph[now]:
            all_cost = cost+1
            if all_cost < table[g]:
                table[g] = all_cost
                heappush(q, (all_cost, g))

dijkstra()

flag = True

for idx in range(1, N+1):
    if table[idx] == K:
        flag = False
        print(idx)

if flag:
    print(-1)