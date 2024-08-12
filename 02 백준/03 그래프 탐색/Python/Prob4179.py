
"""
title  : 4179. 불! (Gold 4)
time   : 1144ms     520ms
memory : 39452KB    164816KB
"""

import sys
from collections import deque

def solution():

    input = sys.stdin.readline
    
    R, C = map(int, input().split())    # 행 R, 열 C
    graph = [list(input()) for _ in range(R)]

    return search(graph, R, C)
    
def search(graph, R, C):

    dir = [[1, 0], [0, 1], [-1, 0], [0, -1]]    # 사방탐색

    fire = deque()
    jihun = deque()

    # 환경 세팅
    for i in range(R):
        for j in range(C):
            if graph[i][j] == 'F':
                fire.append((i, j))
            elif graph[i][j] == 'J':
                jihun.append((i, j, 0))

    while jihun:

        # 불 이동
        for _ in range(len(fire)):

            nowr, nowc = fire.popleft()

            for d in range(4):
                nr = nowr + dir[d][0]
                nc = nowc + dir[d][1]

                # 이동 불가능
                if nr < 0 or nc < 0 or nr >= R or nc >= C or graph[nr][nc] == '#' or graph[nr][nc] == 'F':
                    continue
                
                graph[nr][nc] = 'F'
                fire.append((nr, nc))

        # 지훈이 이동
        for _ in range(len(jihun)):

            nowr, nowc, dis = jihun.popleft()

            if nowr == 0 or nowr == R-1 or nowc == 0 or nowc == C-1:
                return dis+1

            for d in range(4):
                nr = nowr + dir[d][0]
                nc = nowc + dir[d][1]

                # 이동 불가능
                if graph[nr][nc] == '#' or graph[nr][nc] == 'F' or graph[nr][nc] == 'J':
                    continue

                graph[nr][nc] = 'J'
                jihun.append((nr, nc, dis+1))

    return 'IMPOSSIBLE'

print(solution())