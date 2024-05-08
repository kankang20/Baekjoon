
""" 골드 3. 벽 부수고 이동하기 """

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    R, C = map(int, input().split())
    board = [list(map(int, input().rstrip())) for _ in range(R)]  

    dr = [0, 0, 1, -1]
    dc = [1, -1, 0, 0]

    visited = [[[0] * C for _ in range(R)] for _ in range(2)]

    def bfs():

        q = deque()
        q.append((0, 0, 0))
        visited[0][0][0] = 1

        while q:

            r, c, flag = q.popleft()
            if r == (R-1) and c == (C-1):
                return visited[flag][r][c]

            for d in range(4):
                nr = r + dr[d]
                nc = c + dc[d]

                if not checkBoundry(nr, nc):
                    continue

                # 벽을 부수고 이동
                if flag == 0 and board[nr][nc] == 1 and visited[1][nr][nc] == 0:
                    q.append((nr, nc, 1))
                    visited[1][nr][nc] = visited[0][r][c] + 1

                # 벽을 부수지 않고 이동
                if board[nr][nc] == 0 and visited[flag][nr][nc] == 0:
                    q.append((nr, nc, flag))
                    visited[flag][nr][nc] = visited[flag][r][c] + 1

        return -1

    def checkBoundry(r, c):
        if 0 <= r < R and 0 <= c < C:
            return True
        return False
    
    return bfs()

print(solution())