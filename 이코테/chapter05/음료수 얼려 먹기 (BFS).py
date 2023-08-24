
""" 예제 5-6) 음료수 얼려 먹기 (BFS)"""

from collections import deque

R, C = map(int, input().split())
graph = [list(map(int, input())) for _ in range(R)]

visited = [[0] * C for _ in range(R)]
dr = [0, 0, -1, 1]
dc = [-1, 1, 0, 0]


def bfs(nowr, nowc):

    queue = deque([(nowr, nowc)])
    visited[nowr][nowc] = True

    while queue:

        r, c = queue.popleft()

        for d in range(4):

            nr = r + dr[d]
            nc = c + dc[d]

            if nr < 0 or nc < 0 or nr >= R or nc >= C or visited[nr][nc] or graph[nr][nc]:
                continue

            queue.append((nr, nc))
            visited[nr][nc] = True


answer = 0

for r in range(R):
    for c in range(C):
        if not graph[r][c] and not visited[r][c]:
            answer += 1
            bfs(r, c)

print(answer)