
"""
title  : 6593. 상범 빌딩 (Gold 5)
time   : 116ms      196ms
memory : 34148KB    115580KB
"""

import sys
from collections import deque

dh = [0, 0, 0, 0, 1, -1]
dr = [1, -1, 0, 0, 0, 0]
dc = [0, 0, 1, -1, 0, 0]

def solution():
    input = sys.stdin.readline

    while True:

        L, R, C = map(int, input().split())     # 층 L, 행 R, 열 C
        if L == 0 and R == 0 and C == 0:
            break
        
        board = []
        for _ in range(L):
            board.append([list(input().rstrip()) for _ in range(R)])
            input()

        print(bfs(board, L, R, C))
        
def bfs(board, L, R, C):
    
    sh, sr, sc = search(board, L, R, C)
    
    q = deque()
    q.append((sh, sr, sc))

    selected = [[[0] * C for _ in range(R)] for _ in range(L)]
    selected[sh][sr][sc] = 1
    
    while q:

        h, r, c = q.popleft()
        if board[h][r][c] == 'E':
            return "Escaped in {0} minute(s).".format(selected[h][r][c]-1)

        for d in range(6):
            nh = h + dh[d]
            nr = r + dr[d]
            nc = c + dc[d]

            if nh < 0 or nh >= L or nr < 0 or nr >= R or nc < 0 or nc >= C:
                continue
            
            if board[nh][nr][nc] != '#' and selected[nh][nr][nc] == 0:
                q.append((nh, nr, nc))
                selected[nh][nr][nc] = selected[h][r][c] + 1

    return 'Trapped!'

def search(board, L, R, C):
    for h in range(L):
        for r in range(R):
            for c in range(C):
                if board[h][r][c] == 'S':
                    return (h, r, c)

solution()