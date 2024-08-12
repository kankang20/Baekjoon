
"""
title  : 1012. 유기농 배추 (Silver 2)
time   : 68ms       152ms
memory : 34112KB    114308KB
"""

import sys
from collections import deque

def solution():

    input = sys.stdin.readline
    testcase = int(input())

    for _ in range(testcase):

        C, R, K = map(int, input().split())
        graph = [[0] * C for _ in range(R)]

        for _ in range(K):
            c, r = map(int, input().split())
            graph[r][c] = 1

        answer = 0
        for r in range(R):
            for c in range(C):
                if graph[r][c] == 1:
                    search(R, C, graph, r, c)
                    answer += 1
        
        print(answer)

def search(R, C, graph, r, c):

    dir = [(0, 1), (0, -1), (1, 0), (-1, 0)]

    q = deque()
    q.append((r, c))
    graph[r][c] = 0

    while q:

        r, c = q.popleft()

        for d in range(4):
            nr = r + dir[d][0]
            nc = c + dir[d][1]

            if nr < 0 or nc < 0 or nr >= R or nc >= C or not graph[nr][nc]:
                continue

            graph[nr][nc] = 0
            q.append((nr, nc))

solution()