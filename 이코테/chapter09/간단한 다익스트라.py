
""" 예제 9-1) 간단한 다익스트라 """

import sys

input = sys.stdin.readline
INF = int(1e9)

N, M = map(int, input().split())    # 노드의 개수 N, 간선의 개수 M
start = int(input())                # 시작 노드

graph = [[] for _ in range(N+1)]    # 각 노드에 연결되어 있는 노드에 대한 정보 저장
visited = [False] * (N+1)           # 방문 여부
table = [INF] * (N+1)               # 최단 거리 테이블

for _ in range(M):
    a, b, c = map(int, input().split())     # a -> b의 비용이 c
    graph[a].append((b, c))                 

# 방문하지 않은 노드 중 가장 최단거리가 짧은 노드 선택
def get_smallest_node():
    min_value = INF
    idx = 0

    for i in range(1, N+1):
        if table[i] < min_value and not visited[i]:
            min_value = table[i]
            idx = i

    return idx

# 최단 거리 갱신
def dijkstra(start):
    table[start] = 0
    visited[start] = True

    for g in graph[start]:
        table[g[0]] = g[1]

    for _ in range(N-1):
        now = get_smallest_node()
        visited[now] = True

        for g in graph[now]:
            cost = table[now] + g[1]
            if cost < table[g[0]]:
                table[g[0]] = cost

dijkstra(start)

for i in range(1, N+1):
    if table[i] == INF:
        print(-1, end = " ")
    else:
        print(table[i], end = " ")