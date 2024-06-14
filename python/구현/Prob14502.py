
""" 골드 4. 연구소 """

import sys
from collections import deque

dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]

answer = 0
virus = deque()

def solution():
    input = sys.stdin.readline

    global R, C
    R, C = map(int, input().split())

    board = []

    for r in range(R):
        board.append(list(map(int, input().split())))
        for c in range(C):
            if board[r][c] == 2:
                virus.append((r, c))


    make_wall(board, 0)

    return answer

def make_wall(board:list, count:int):

    if count == 3:
        vv = virus
        global answer
        answer = max(answer, bfs(board, vv))
        return
    
    for r in range(R):
        for c in range(C):
            if board[r][c] == 0:
                board[r][c] = 1
                make_wall(board, count+1)
                board[r][c] = 0


def bfs(board:list, virus:deque):

    selected = [[False] * C for _ in range(R)]

    count = 0
    while virus:

        r, c = virus.popleft()

        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]

            if nr < 0 or nr >= R or nc < 0 or nc >= C:
                continue

            if board[nr][nc] > 0 or selected[nr][nc]:
                continue

            virus.append((nr, nc))
            selected[nr][nc] = True

            count += 1
    
    return count
    






print(solution())