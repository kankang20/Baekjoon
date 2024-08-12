
"""
title  : 6282. 장애물 인식 프로그램 (Level 2)
time   : 108ms
memory : 37.49MB
"""

import sys
from collections import deque

dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]

def solution():
    input = sys.stdin.readline

    N = int(input())
    board = [list(map(int, input().rstrip())) for _ in range(N)]
    selected = [[False] * N for _ in range(N)]

    answer = []
    for r in range(N):
        for c in range(N):
            if not selected[r][c] and board[r][c] == 1:
               answer.append(bfs(N, board, selected, r, c))

    print(len(answer))
    print(*sorted(answer), sep="\n")

def bfs(N:int, board:list, selected:list, r:int, c:int):

    q = deque()
    
    q.append((r, c))
    selected[r][c] = True

    count = 0
    while q:

        r, c = q.popleft()
        count += 1

        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]

            if nr < 0 or nr >= N or nc < 0 or nc >= N:
                continue

            if not selected[nr][nc] and board[nr][nc] == 1:
                q.append((nr, nc))
                selected[nr][nc] = True

    return count

solution()