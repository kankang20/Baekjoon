
"""
title  : 17141. 연구소 2 (Gold 4)
time   : 524ms     268ms
memory : 34220KB   114736KB
"""

import sys
import copy
from itertools import combinations
from collections import deque

dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())
    
    board = []
    for _ in range(N):
        board.append(list(map(int, input().split())))

    virus = []
    space = 0
    for r in range(N):
        for c in range(N):
            if board[r][c] == 0:
                space += 1
            elif board[r][c] == 2:
                virus.append((r, c))

    if len(virus) < M:
        return bfs(N, board, virus)

    space += len(virus)
    answer = space

    for temp in list(combinations(virus, M)):
        answer = min(answer, bfs(N, copy.deepcopy(board), temp, space))
    
    return -1 if answer == space else answer
    
def bfs(N:int, nboard:list, virus_pos:list, space:int):

    q = deque()
    selected = [[False] * N for _ in range(N)]

    for (r, c) in virus_pos:
        q.append((r, c))
        selected[r][c] = True

    count_space = space
    count = 0

    while q:
        count += 1
        for _ in range(len(q)):
            r, c = q.popleft()
            count_space -= 1

            for d in range(4):
                nr = r + dr[d]
                nc = c + dc[d]

                if nr < 0 or nr >= N or nc < 0 or nc >= N:
                    continue
                if selected[nr][nc] or nboard[nr][nc] == 1:
                    continue

                q.append((nr, nc))
                selected[nr][nc] = True

    return space if count_space else count-1
            
print(solution())