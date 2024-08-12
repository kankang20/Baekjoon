
"""
title  : 2583. 영역 구하기 (Silver 1)
time   : 68ms       156ms
memory : 34112KB    114460KB
"""

import sys
from collections import deque

def solution():

    input = sys.stdin.readline

    R, C, K = map(int, input().split())     # 행 R, 열 C, 사각형 개수 K

    graph = [[0] * C for _ in range(R)]     # 전체 영역
    for _ in range(K):
        x1, y1, x2, y2 = map(int, input().split())
        for r in range(R-y2, R-y1):
            for c in range(x1, x2):
                graph[r][c] = 1

    answer = []
    for i in range(R):
        for j in range(C):
            if not graph[i][j]:
                answer.append(bfs(R, C, graph, i, j))
    
    print(len(answer))
    for a in sorted(answer):
        print(a, end = " ")

def bfs(R, C, graph, r, c):

    q = deque()
    q.append((r, c))
    graph[r][c] = 1

    count = 1

    while q:    

        r, c = q.popleft()

        for dr, dc in [[0, 1], [0, -1], [1, 0], [-1, 0]]:
            nr = r + dr
            nc = c + dc

            if nr < 0 or nc < 0 or nr >= R or nc >= C or graph[nr][nc]:
                continue

            q.append((nr, nc))
            graph[nr][nc] = 1

            count += 1

    return count

solution()