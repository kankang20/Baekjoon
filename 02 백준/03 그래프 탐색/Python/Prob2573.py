
"""
title  : 2573. 빙산 (Gold 4)
time   : 3076ms     776ms
memory : 34136KB    213408KB
"""

import sys
from collections import deque

dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]

def solution():
    input = sys.stdin.readline

    R, C = map(int, input().split())
    board = []

    # 빙하 찾기
    ice = deque()
    for r in range(R):
        board.append(list(map(int, input().split())))
        for c in range(C):
            if board[r][c] > 0:
                ice.append((r, c))

    answer = 0
    while count_area(board, R, C) < 2 and ice:

        # 빙하 녹은거 확인 -> 새로운 배열 생성
        nboard = [[0] * C for _ in range(R)]

        for _ in range(len(ice)):
            ir, ic = ice.popleft()

            sea = 0
            for d in range(4):
                nr = ir + dr[d]
                nc = ic + dc[d]
                if 0 <= nr < R and 0 <= nc < C and board[nr][nc] <= 0:
                    sea += 1

            nboard[ir][ic] = board[ir][ic] - sea
            if nboard[ir][ic] > 0:
                ice.append((ir, ic))

        board = nboard
        answer += 1

    return answer if ice else 0

def count_area(board, R, C):
    visited = [[False] * C for _ in range(R)]

    def bfs(r, c):
        q = deque()
        q.append((r, c))
        visited[r][c] = True
        
        while q:
            br, bc = q.popleft()
            for d in range(4):
                nr = br + dr[d]
                nc = bc + dc[d]
                if 0 <= nr < R and 0 <= nc < C and not visited[nr][nc] and board[nr][nc] > 0:
                    q.append((nr, nc))
                    visited[nr][nc] = True

    count = 0
    for r in range(R):
        for c in range(C):
            if board[r][c] > 0 and not visited[r][c]:
                count += 1
                bfs(r, c)

    return count

print(solution())