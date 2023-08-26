
""" 실버 2. DFS와 BFS """

from collections import deque

### 입력

# 정점의 개수, 간선의 개수, 탐색을 시작할 정점의 번호
N, M, V = map(int, input().split())
# 인접리스트
maps = [[] for _ in range(N+1)]

for _ in range(M):
    i, j = map(int, input().split())
    maps[i].append(j)
    maps[j].append(i)

for m in maps:
    m.sort()

### 함수

def dfs(n):

    visitedDFS[n] = True
    print(n, end = " ")

    for i in maps[n]:
        if not visitedDFS[i]:
            dfs(i)

def bfs(n):

    visitedBFS = [False] * (N+1)

    queue = deque()

    queue.append(n)
    visitedBFS[n] = True

    while queue:

        now = queue.popleft()
        print(now, end = " ")

        for i in maps[now]:
            if not visitedBFS[i]:
                queue.append(i)
                visitedBFS[i] = True

### 실행

visitedDFS = [False] * (N+1)
dfs(V)

print()

bfs(V)