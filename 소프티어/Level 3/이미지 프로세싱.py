
""" Lv 3. [21년 재직자 대회 예선] 이미지 프로세싱 """

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    global R, C
    R, C = map(int, input().split())    # 행 R, 열 C

    global board
    board = [list(map(int, input().split())) for _ in range(R)]

    for _ in range(int(input())):
        i, j, c = map(int, input().split())
        bfs(i-1, j-1, c)

    for r in range(R):
        print(" ".join(map(str, board[r])))

def bfs(i, j, value):

    visited = [[False] * C for _ in range(R)]
    check_value = board[i][j]

    q = deque()

    q.append((i, j))
    board[i][j] = value 
    visited[i][j] = True

    while q:

        r, c = q.popleft()

        for (dr, dc) in [(0, 1), (1, 0), (-1, 0), (0, -1)]:
            nr = r + dr
            nc = c + dc

            if 0 <= nr < R and 0 <= nc < C and board[nr][nc] == check_value and not visited[nr][nc]:
                q.append((nr, nc))
                board[nr][nc] = value
                visited[nr][nc] = True

solution()