
""" 실버 1. 쉬운 최단거리 """

from collections import deque
import sys

input = sys.stdin.readline
R, C = map(int, input().split())    # 행, 열
graph = [list(map(int, input().split())) for _ in range(R)]

dr = [0, 0, -1, 1]
dc = [1, -1, 0, 0]


def solution():
    answer = [[0] * C for _ in range(R)]
    start = [(r, c) for r in range(R) for c in range(C) if graph[r][c] == 2]    # 탐색 시작 위치 찾기 (2)

    queue = deque()

    queue.append((start[0][0], start[0][1], 0))
    graph[start[0][0]][start[0][1]] = 0

    while queue:

        r, c, count = queue.popleft()

        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]

            if nr < 0 or nc < 0 or nr >= R or nc >= C or not graph[nr][nc]:
                continue

            queue.append((nr, nc, count+1))
            answer[nr][nc] = count+1
            graph[nr][nc] = 0

    for r in range(R):
        for c in range(C):
            if graph[r][c] == 1:print(-1, end = " ")
            else: print(answer[r][c], end = " ")
        print()


solution()