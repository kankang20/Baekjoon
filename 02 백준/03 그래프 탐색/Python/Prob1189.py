
"""
title  : 1189. 컴백홈 (Silver 1)
time   : 96ms       208ms
memory : 31120KB    113264KB
"""

import sys

def solution():
    input = sys.stdin.readline

    R, C, K = map(int, input().split())
    board = [list(input()) for _ in range(R)]

    dr = [0, 0, 1, -1]
    dc = [1, -1, 0, 0]

    answer = 0

    def dfs(sr, sc, count):

        if sr == 0 and sc == C-1:
            if count == K:
                nonlocal answer
                answer += 1
            return
        
        if count >= K:
            return
        
        board[sr][sc] = 'T'
        for d in range(4):
            nr = sr + dr[d]
            nc = sc + dc[d]

            if 0 <= nr < R and 0 <= nc < C and board[nr][nc] == '.':
                board[nr][nc] = 'T'
                dfs(nr, nc, count+1)
                board[nr][nc] = '.'

    dfs(R-1, 0, 1)

    return answer
    
print(solution())