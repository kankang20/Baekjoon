
""" 골드 4. 트리의 지름 """

import sys
sys.setrecursionlimit(10**6)        # 이거 없으면 RecursionError

input = sys.stdin.readline

N = int(input())    # 노드의 개수

graph = [[] for _ in range(N+1)]
for _ in range(N-1):
    a, b, c = map(int, input().split())     # 부모 노드 a, 자식 노드 b, 가중치 c
    graph[a].append((b, c))
    graph[b].append((a, c))

idx, answer = 0, 0

def solution():

    visited = [False] * (N+1)
    visited[1] = True
    search(visited, 1, 0)

    visited = [False] * (N+1)
    visited[idx] = True
    search(visited, idx, 0)


def search(visited, n, d):

    global answer, idx
    if answer < d:
        idx, answer = n, d

    for (node, distance) in graph[n]:
        if not visited[node]:
            visited[node] = True
            search(visited, node, d + distance)

solution()
print(answer)