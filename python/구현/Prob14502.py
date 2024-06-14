
""" 골드 4. 연구소 """

import sys
from collections import deque

answer = 0

def solution():
    input = sys.stdin.readline

    global R, C
    R, C = map(int, input().split())

    board = []
    virus = deque()

    for r in range(R):
        board.append(list(map(int, input().split())))
        for c in range(C):
            if board[r][c] == 2:
                virus.append((r, c))


    make_wall(0)

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


def bfs(board:list, virus:list):

    selected = [[False] * C in range(R)]
    






print(solution())