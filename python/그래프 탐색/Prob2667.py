
""" 실버 1. 단지번호붙이기 """

from collections import deque
import sys


input = sys.stdin.readline
N = int(input())    # 지도의 크기
graph = [list(map(int, input().rstrip())) for _ in range(N)]

visited = [[False] * N for _ in range(N)]    # 방문 처리
dr = [0, 0, -1, 1]
dc = [1, -1, 0, 0]


def bfs(r, c):

    q = deque()

    q.append((r, c))
    visited[r][c] = True

    count = 1

    while q:
        nowr, nowc = q.popleft()

        for d in range(4):
            nr = nowr + dr[d]
            nc = nowc + dc[d]

            if nr < 0 or nc < 0 or nr >= N or nc >= N or visited[nr][nc] or not graph[nr][nc]:
                continue
            
            count += 1

            q.append((nr, nc))
            visited[nr][nc] = True

    return count


answers = []
ans = 0

for i in range(N):
    for j in range(N):
        if graph[i][j] and not visited[i][j]:
            ans += 1
            answers.append(bfs(i, j))

print(ans)
for a in sorted(answers):
    print(a)