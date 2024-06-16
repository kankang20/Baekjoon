
""" 골드 4. 연구소 """

import sys
from collections import deque
import copy

dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]

answer = 0

def solution():
    input = sys.stdin.readline

    global R, C
    R, C = map(int, input().split())

    global board, virus, cnt_space
    board = []
    virus = []

    cnt_space = R * C
    for r in range(R):
        board.append(list(map(int, input().split())))
        for c in range(C):
            if board[r][c] > 0:
                cnt_space -= 1
                if board[r][c] == 2:
                    virus.append((r, c))

    make_wall(0)

    return answer

def make_wall(count:int):

    if count == 3:
        global answer
        answer = max(answer, bfs())
        return
    
    for r in range(R):
        for c in range(C):
            if board[r][c] == 0:
                board[r][c] = 1
                make_wall(count+1)
                board[r][c] = 0

def bfs():
    temp_board = copy.deepcopy(board)

    vv = deque()
    for (vr, vc) in virus:
        vv.append((vr, vc))

    cnt = 0
    while vv:
        r, c = vv.popleft()

        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            if 0 <= nr < R and 0 <= nc < C and temp_board[nr][nc] == 0:
                vv.append((nr, nc))
                temp_board[nr][nc] = 2
                cnt += 1

    return cnt_space - cnt - 3
    
print(solution())