
""" 실버 1. 컴백홈 """

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    R, C, K = map(int, input().split())
    board = [list(input()) for _ in range(R)]

    dr = [0, 0, 1, -1]
    dc = [1, -1, 0, 0]

    def bfs(sr, sc):

        q = deque()
        q.append((sr, sc, 1))

        selected = [[False] * C for _ in range(R)]
        selected[sr][sc] = True
        
        answer = 0
        while q:

            r, c, dis = q.popleft()
            selected[r][c] = True

            if r == 0 and c == C-1 and dis == K:
                answer += 1

            if dis >= K:
                continue

            for d in range(4):
                nr = r + dr[d]
                nc = c + dc[d]

                if nr < 0 or nr >= R or nc < 0 or nc >= C or board[nr][nc] == 'T' or selected[nr][nc]:
                    continue

                q.append((nr, nc, dis + 1))

        return answer
    
    return bfs(R-1, 0)
    
print(solution())