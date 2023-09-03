
""" 실버 1. 미로 탐색 """

from collections import deque
import sys

### 입력
input = sys.stdin.readline

N, M = map(int, input().split())    
graphs = [list(map(int, input().rstrip())) for _ in range(N)]

dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]

### 함수
def bfs():

    visited = [[False] * M for _ in range(N)]
    queue = deque()

    queue.append((0, 0, 1))
    visited[0][0] = True

    while queue:

        r, c, count = queue.popleft()

        if r == N-1 and c == M-1:
            return count

        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]

            if nr < 0 or nc < 0 or nr >= N or nc >= M or visited[nr][nc] or not graphs[nr][nc]:
                continue

            queue.append((nr, nc, count+1))
            visited[nr][nc] = True


### 실행
print(bfs())