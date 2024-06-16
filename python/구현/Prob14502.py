
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
    board = [list(map(int, input().split())) for _ in range(R)]

    make_wall(board, 0)

    return answer

def make_wall(board:list, count:int):

    if count == 3:
        global answer
        answer = max(answer, bfs(board))
        return
    
    for r in range(R):
        for c in range(C):
            if board[r][c] == 0:
                board[r][c] = 1
                make_wall(board, count+1)
                board[r][c] = 0


def bfs(board:list):
    temp_board = copy.deepcopy(board)

    virus = deque()
    for r in range(R):
        for c in range(C):
            if temp_board[r][c] == 2:
                virus.append((r, c))

    while virus:
        r, c = virus.popleft()

        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            if 0 <= nr < R and 0 <= nc < C and temp_board[nr][nc] == 0:
                virus.append((nr, nc))
                temp_board[nr][nc] = 2

    return count_safe_area(temp_board)

def count_safe_area(board:list):
    cnt = 0
    for r in range(R):
        cnt += board[r].count(0)
    return cnt
    
print(solution())