
"""
title  : 2667. 단지번호붙이기 (Silver 1)
time   : 40ms       128ms
memory : 31332KB    114480KB
"""

import sys

input = sys.stdin.readline
N = int(input())    # 지도의 크기
graph = [list(map(int, input().rstrip())) for _ in range(N)]

visited = [[False] * N for _ in range(N)]    # 방문 처리
count = 0

dr = [0, 0, -1, 1]
dc = [1, -1, 0, 0]

def dfs(r, c):
    visited[r][c] = True
    global count
    count += 1

    for d in range(4):
        nr = r + dr[d]
        nc = c + dc[d]

        if nr < 0 or nc < 0 or nr >= N or nc >= N or visited[nr][nc] or not graph[nr][nc]:
            continue

        dfs(nr, nc)

answers = []
ans = 0

for i in range(N):
    for j in range(N):
        if graph[i][j] and not visited[i][j]:
            dfs(i, j)
            answers.append(count)
            ans += 1
            count = 0

print(ans)
for a in sorted(answers):
    print(a)