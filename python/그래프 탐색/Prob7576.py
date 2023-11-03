
""" 골드 5. 토마토 """

import sys
from collections import deque

def solution():

    input = sys.stdin.readline

    C, R = map(int, input().split())                                # 상자의 가로칸, 세로칸
    box = [list(map(int, input().split())) for _ in range(R)]       # 토마토 박스

    return search(R, C, box)

def search(R, C, box):

    dr = [0, 0, -1, 1]
    dc = [1, -1, 0, 0]

    q = deque()

    yet_tomato = 0
    answer = -1

    # 익지 않은 토마토와 익은 토마토
    for r in range(0, R):
        for c in range(0, C):
            if box[r][c] == 0:
                yet_tomato += 1
            elif box[r][c] == 1:
                q.append((r, c))

    if not yet_tomato: 
        return 0

    while q:

        answer += 1

        for _ in range(len(q)):

            r, c = q.popleft()

            for d in range(4):

                nr = r + dr[d]
                nc = c + dc[d]

                if nr < 0 or nc < 0 or nr >= R or nc >= C or box[nr][nc] == -1 or box[nr][nc] == 1:
                    continue

                box[nr][nc] = 1
                q.append((nr, nc))

                yet_tomato -= 1

    return -1 if yet_tomato else answer

print(solution())