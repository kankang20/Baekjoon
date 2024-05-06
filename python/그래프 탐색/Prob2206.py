
""" 골드 3. 벽 부수고 이동하기 """

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    R, C = map(int, input().split())
    board = [list(map(int, input().rstrip())) for _ in range(R)]  

    dr = [0, 0, 1, -1]
    dc = [1, -1, 0, 0]

    visited = [[0] * C for _ in range(R)]

    def bfs():
        q = deque()
        q.append((0, 0, 1))
        visited[0][0] = 1

        while q:

            r, c, count = q.popleft()
            if r == (R-1) and c == (C-1):
                return visited[r][c]

            for d in range(4):
                nr = r + dr[d]
                nc = c + dc[d]

                if not checkBoundry(nr, nc):
                    continue

                if not visited[nr][nc] and not board[nr][nc]:
                    q.append((nr, nc, count))
                    visited[nr][nc] = visited[r][c] + 1

                if count:
                    nr += dr[d]
                    nc += dc[d]

                    if checkBoundry(nr, nc) and not visited[nr][nc] and not board[nr][nc]:
                        q.append((nr, nc, 0))
                        visited[nr][nc] = visited[r][c] + 2
        return -1

    def checkBoundry(r, c):
        if 0 <= r < R and 0 <= c < C:
            return True
        return False
    
    return bfs()

print(solution())