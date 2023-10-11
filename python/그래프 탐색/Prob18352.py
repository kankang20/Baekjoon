
""" 실버 2. 특정 거리의 도시 찾기 """

import sys
from collections import deque

input = sys.stdin.readline

N, M, K, X = map(int, input().split())      # 도시 개수 N, 도로 개수 M, 거리 정보 K, 출발 도시 번호 X

graph = [[] for _ in range(N+1)]
visited = [False] * (N+1)

for _ in range(M):
    i, j = map(int, input().split())
    graph[i].append(j)

def solution():
    
    q = deque()

    q.append((0, X))
    visited[X] = True

    answer = []

    while q:

        dist, now = q.popleft()

        for g in graph[now]:
            if not visited[g]:
                if dist + 1 < K:
                    visited[g] = True
                    q.append((dist+1, g))
                else:
                    visited[g] = True
                    answer.append(g)

    if len(answer):
        for a in sorted(answer):
            print(a)
    else:
        print(-1)

solution()
