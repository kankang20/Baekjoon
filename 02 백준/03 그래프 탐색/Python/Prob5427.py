
"""
title  : 5427. 불 (Gold 4)
time   : 2044ms     584ms
memory : 61060KB    214560KB
"""

import sys
from collections import deque

dr = [0, 0, -1, 1]
dc = [1, -1, 0, 0]

def solution():
    input = sys.stdin.readline

    T = int(input())
    for _ in range(T):
        C, R = map(int, input().split())
        board = [list(input().rstrip()) for _ in range(R)]
        print(bfs(board, R, C))

def bfs(board, R, C):

    fire = deque()
    sang = deque()

    for r in range(R):
        for c in range(C):
            if board[r][c] == '*':
                fire.append((r, c))
            elif board[r][c] == '@':
                sang.append((r, c, 1))

    while sang:

        for _ in range(len(fire)):
            r, c = fire.popleft()

            for d in range(4):
                nr = r + dr[d]
                nc = c + dc[d]
                if 0 <= nr < R and 0 <= nc < C and (board[nr][nc] == '.' or board[nr][nc] == '@'): 
                    fire.append((nr, nc))
                    board[nr][nc] = "#"

        for _ in range(len(sang)):
            r, c, count = sang.popleft()
            if r == 0 or c == 0 or r == R-1 or c == C-1:
                return count

            for d in range(4):
                nr = r + dr[d]
                nc = c + dc[d]
                if 0 <= nr < R and 0 <= nc < C and board[nr][nc] == '.':
                    sang.append((nr, nc, count+1))
                    board[nr][nc] = '@'

    return "IMPOSSIBLE"    

solution()