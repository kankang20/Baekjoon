
"""
title  : 16918. 봄버맨 (Silver 1)
time   : 76ms       160ms
memory : 34184KB    117832KB
"""

from collections import deque
import sys

input = sys.stdin.readline
R, C, N = map(int, input().split())         # 행 R, 열 C, 시간 N
graph = [list(input().rstrip()) for _ in range(R)]   # 격자판
dr = [0, 0, -1, 1]
dc = [-1, 1, 0, 0]

def solution():

    if N == 1:
        for g in graph:
            print(''.join(g))
    elif N % 2 == 0:
        for _ in range(R):
            print('O' * C)
    else:
        if N % 4 == 3:
            answer = bfs(graph)
            for a in answer:
                print(''.join(a))
        elif N % 4 == 1:
            answer = bfs(bfs(graph))
            for a in answer:
                print(''.join(a))

def bfs(graph):

    answer = [['O'] * C for _ in range(R)]
    bombs = deque()

    for r in range(R):
        for c in range(C):
            if graph[r][c] == 'O': 
                bombs.append((r, c))

    while bombs:
        nowr, nowc = bombs.popleft()
        answer[nowr][nowc] = '.'

        for d in range(4):
            nr = nowr + dr[d]
            nc = nowc + dc[d]

            if nr < 0 or nc < 0 or nr >= R or nc >= C:
                continue

            answer[nr][nc] = '.'

    return answer

solution()