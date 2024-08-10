
"""
title  : 17144. 미세먼지 안녕! (Gold 4)
time   : 52ms      124ms
memory : 34140KB   113164KB
"""

import sys
from collections import deque

dr = [0, 0, -1, 1]
dc = [1, -1, 0, 0]

def solution():
    input = sys.stdin.readline

    R, C, T = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(R)]

    # 1. 미세먼지와 공기청정기 위치 찾기
    dust = deque()
    cleaner = []

    for r in range(R):
        for c in range(C):
            if board[r][c] > 0:
                dust.append((r, c, board[r][c]))
            elif board[r][c] == -1:
                cleaner.append((r, c))

    # 2. 성능 테스트
    for _ in range(T):
        
        # 2-1. 미세먼지 확산
        spread_dust(R, C, board, dust)
        for r in range(R):
            print(board[r])
        # 2-2. 미세먼지 위치
        search_dust(R, C, board, dust)

        print(dust)
        
        # 2-3. 공기청정기 작동
        #

        break

def spread_dust(R:int, C:int, board:list, dust:deque):

    for _ in range(len(dust)):

        r, c, amount = dust.popleft()

        namount = amount // 5

        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]

            if  nr < 0 or nr >= R or nc < 0 or nc >= C or board[nr][nc] == -1:
                continue

            board[nr][nc] += namount
            board[r][c] -= namount

def search_dust(R:int, C:int, board:list, dust:deque):

    for r in range(R):
        for c in range(C):
            if board[r][c] > 0:
                dust.append((r, c, board[r][c]))




print(solution())