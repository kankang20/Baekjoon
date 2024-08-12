
"""
title  : 11724. 연결 요소의 개수 (Silver 2)
time   : 448ms       356ms
memory : 65284KB     173476KB
"""

import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())

def solution():

    graph = [[] for _ in range(N+1)]

    for _ in range(M):
        i, j = map(int, input().split())
        graph[i].append(j)
        graph[j].append(i)

    visited = [False] * (N+1)
    answer = 0

    for idx in range(1, N+1):
        if not visited[idx]:
            visited = bfs(graph, visited, idx)
            answer += 1
    
    return answer

def bfs(graph, visited, idx):

    q = deque()

    q.append(idx)
    visited[idx] = True

    while q:
        now = q.popleft()
        
        for i in graph[now]:
            if not visited[i]:
                q.append(i)
                visited[i] = True

    return visited

print(solution())