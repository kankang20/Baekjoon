
""" 골드 4. 트리의 지름 """

import sys
from collections import deque

input = sys.stdin.readline

def solution():

    N = int(input())    # 노드의 개수

    graph = [[] for _ in range(N+1)]
    for _ in range(N-1):
        a, b, c = map(int, input().split())     # 부모 노드 a, 자식 노드 b, 가중치 c
        graph[a].append((b, c))
        graph[b].append((a, c))

    i, _ = search(N, graph, 1)
    _, answer = search(N, graph, i)

    return answer
    
def search(N, graph, start):

    q = deque()
    visited = [False] * (N+1)

    q.append((start, 0))
    visited[start] = True

    idx, answer = start, 0

    while q:

        n, d = q.popleft()

        if answer < d:
            idx, answer = n, d

        for (node, distance) in graph[n]:
            if not visited[node]:
                visited[node] = True
                q.append((node, d + distance))

    return idx, answer

print(solution())