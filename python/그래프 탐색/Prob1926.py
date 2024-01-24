
""" 실버 1.  그림 """

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    R, C = map(int, input().split())
    picture = [list(map(int, input().split())) for _ in range(R)]

    answer = []
    for r in range(R):
        for c in range(C):
            if picture[r][c] == 1:
                answer.append(bfs(R, C, picture, r, c))

    print(len(answer))
    print(max(answer) if answer else 0)

def bfs(R, C, picture, r, c):

    q = deque()

    q.append((r, c))
    picture[r][c] = 0

    count = 0
    while q:

        r, c = q.popleft()
        count += 1

        for (dr, dc) in [(0, 1), (0, -1), (1, 0), (-1, 0)]:

            nr = r + dr
            nc = c + dc

            if nr < 0 or nr >= R or nc < 0 or nc >= C or picture[nr][nc] == 0:
                continue

            q.append((nr, nc))
            picture[nr][nc] = 0

    return count

solution()