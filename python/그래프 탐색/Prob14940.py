
""" 실버 1. 쉬운 최단거리 """

from collections import deque
import sys

input = sys.stdin.readline
R, C = map(int, input().split())    # 행, 열
graph = [list(map(int, input().split())) for _ in range(R)]

dr = [0, 0, -1, 1]
dc = [1, -1, 0, 0]


def solution():

    start = [(r, c) for r in range(R) for c in range(C) if graph[r][c] == 2]    # 탐색 시작 위치 찾기 (2)

    queue = deque()

    queue.append((start[0][0], start[0][1]))
    graph[start[0][0]][start[0][1]] = 2

    while queue:

        r, c = queue.popleft()

        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]

            if nr < 0 or nc < 0 or nr >= R or nc >= C or graph[nr][nc] is not 1:
                continue

            queue.append((nr, nc))
            graph[nr][nc] = graph[r][c] + 1 

    for r in range(R):
        for c in range(C):
            if graph[r][c] == 1: print(-1, end = " ")
            elif graph[r][c] == 0: print(0, end = " ")
            else: print(graph[r][c]-2, end = " ")
        print()


solution()