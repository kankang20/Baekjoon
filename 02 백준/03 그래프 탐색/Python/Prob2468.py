
"""
title  : 2468. 안전 영역 (Silver 1)
time   : 640ms      304ms
memory : 34088KB    117400KB
"""

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    dr = [0, 0, -1, 1]
    dc = [1, -1, 0, 0]

    N = int(input())    
    board = [list(map(int, input().split())) for _ in range(N)]

    def bfs(height, r, c):

        q = deque()
        q.append((r, c))
        selected[r][c] = True

        while q:
            r, c = q.popleft()

            for d in range(4):
                nr = r + dr[d]
                nc = c + dc[d]

                if nr < 0 or nr >= N or nc < 0 or nc >= N or selected[nr][nc]:
                    continue
                if height < board[nr][nc]:
                    q.append((nr, nc))
                    selected[nr][nc] = True

    answer = 1

    for h in range(1, 101):
        selected = [[False] * N for _ in range(N)]
        count = 0
        for r in range(N):
            for c in range(N):
                if not selected[r][c] and board[r][c] > h:
                    bfs(h, r, c)
                    count += 1
        if count == 0:
            return answer
        answer = max(answer, count)

    return answer

print(solution())