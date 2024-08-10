
""" 예제 5-7) 미로 탈출 (BFS) """

"""
5 6
101010
111111
000001
111111
111111

>> 10
"""

from collections import deque

R, C = map(int, input().split())
graph = [list(map(int, input())) for _ in range(R)]


def bfs(nowr, nowc):

    dir = [(0, -1), (0, 1), (1, 0), (-1, 0)]

    queue = deque()
    queue.append((nowr, nowc))

    while queue:

        r, c = queue.popleft()

        for d in range(4):

            nr = r + dir[d][0]
            nc = c + dir[d][1]

            if nr < 0 or nc < 0 or nr >= R or nc >= C or not graph[nr][nc]:
                continue
            
            if graph[nr][nc] == 1:
                graph[nr][nc] += graph[r][c] 
                queue.append((nr, nc))


bfs(0, 0)

# for r in range(R):
#     for c in range(C):
#         print(graph[r][c], end = " ")
#     print()

print(graph[R-1][C-1])

