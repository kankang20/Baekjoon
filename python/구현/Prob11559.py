
""" 골드 4. Puyo Puyo """

import sys
from collections import deque

dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]

def solution():
    input = sys.stdin.readline

    board = []
    for _ in range(12):
        board.append(list(input().rstrip()))
    
    # 게임 시작
    answer = 0
    while True:

        selected = [[False] * 6 for _ in range(12)]

        flag = False
        for r in range(12):
            for c in range(6):
                if board[r][c] != "." and not selected[r][c]:
                    coordinate = search_pang(board, selected, r, c)

                    if len(coordinate) >= 4:
                        flag = True
                        change_coordinate(board, coordinate)

        if flag:
            reassemble_board(board)
        else:
            return answer

        answer += 1

def search_pang(board:list, selected:list, r:int, c:int):

    q = deque()

    q.append((r, c))
    selected[r][c] = True

    word = board[r][c]
    coor = []

    while q:

        r, c = q.popleft()
        coor.append((r, c))

        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]

            if nr < 0 or nr >= 12 or nc < 0 or nc >= 6:
                continue

            if not selected[nr][nc] and board[nr][nc] == word:
                q.append((nr, nc))
                selected[nr][nc] = True

    return coor

def change_coordinate(board:list, coor:list):

    for (r, c) in coor:
        board[r][c] = '.'

def reassemble_board(board:list):

    for c in range(6):
        rdx = 11
        for r in range(11, -1, -1):
            if board[r][c] != '.':
                while rdx > r and board[rdx][c] != '.':
                    rdx -= 1
                if rdx > r : 
                    board[rdx][c] = board[r][c]
                    board[r][c] = '.'

print(solution())