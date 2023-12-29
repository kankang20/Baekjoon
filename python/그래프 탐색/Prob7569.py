
""" 골드 5. 토마토 """

import sys
from collections import deque

def solution():

    input = sys.stdin.readline
    C, R, H = map(int, input().split())     # 상자의 크기 R, C, 상자의 수 H

    box = [[] for _ in range(H)]
    for h in range(H):
        for _ in range(R):
            box[h].append(list(map(int, input().split())))     # 1 익은 토마토, 0 익지 않은 토마토, -1 비어있음

    return move_tomato(R, C, H, box)
    

def move_tomato(R, C, H, box):

    dir = [[1, 0, 0], [-1, 0, 0], [0, -1, 0], [0, 1, 0], [0, 0, -1], [0, 0, 1]]

    not_tomato = 0
    day = -1

    tomato = deque()

    for h in range(H):
        for r in range(R):
            for c in range(C):
                if box[h][r][c] == 0:
                    not_tomato += 1
                elif box[h][r][c] == 1:
                    tomato.append((h, r, c))

    while tomato:

        day += 1

        for _ in range(len(tomato)):

            h, r, c = tomato.popleft()

            for d in range(6):

                nh = h + dir[d][0]
                nr = r + dir[d][1]
                nc = c + dir[d][2]

                if nh < 0 or nh >= H or nr < 0 or nr >= R or nc < 0 or nc >= C:
                    continue

                if box[nh][nr][nc] == -1 or box[nh][nr][nc] == 1:
                    continue

                box[nh][nr][nc] = 1
                tomato.append((nh, nr, nc))

                not_tomato -= 1

    return -1 if not_tomato else day


print(solution())