
"""
title  : 1600. 말이 되고픈 원숭이 (Gold 3)
time   : 2084ms     544ms
memory : 44788KB    151192KB
"""

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    K = int(input())
    C, R = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(R)]

    return bfs(K, R, C, board)

def bfs(K:int, R:int, C:int, board:list):
    
    dr_horse = [-2, -1, 1, 2, 2, 1, -1, -2]
    dc_horse = [-1, -2, -2, -1, 1, 2, 2, 1]

    dr_monkey = [0, 0, -1, 1]
    dc_monkey = [-1, 1, 0, 0]

    q = deque()
    q.append((0, 0, K, 0))

    selected = [[[False] * (K+1) for _ in range(C)] for _ in range(R)]
    selected[0][0][K] = True

    while q:

        r, c, k, cnt = q.popleft()

        if r == (R-1) and c == (C-1):
            return cnt
        
        if k:   # 말

            for d in range(8):
                nr = r + dr_horse[d]
                nc = c + dc_horse[d]

                if nr < 0 or nr >= R or nc < 0 or nc >= C:
                    continue
                if selected[nr][nc][k-1] or board[nr][nc]:
                    continue

                q.append((nr, nc, k-1, cnt+1))
                selected[nr][nc][k-1] = True

        # 원숭이 

        for d in range(4):
            nr = r + dr_monkey[d]
            nc = c + dc_monkey[d]

            if nr < 0 or nr >= R or nc < 0 or nc >= C:
                continue
            if selected[nr][nc][k] or board[nr][nc]:
                continue

            q.append((nr, nc, k, cnt+1))
            selected[nr][nc][k] = True

    return -1
    
print(solution())