

""" 실버 1. 오목 """

import sys

def solution():

    input = sys.stdin.readline

    board = []
    for _ in range(19):
        board.append(list(map(int, input().split())))

    answer = []
    for i in range(19):
        for j in range(19):

            if board[i][j] > 0:

                flag, endr, endc = isWin(board, i, j, board[i][j])

                if flag:
                    answer.append((board[i][j], i+1, j+1))
                    answer.append((board[i][j], endr+1, endc+1))

    if answer:
        answer.sort(key=lambda x: (x[2], x[1]))
        print(answer[0][0])
        print(answer[0][1], answer[0][2])
    else:
        print(0)

def isWin(board:list, r:int, c:int, number:int):

    dr = [0, 1, 1, 1]
    dc = [1, 1, 0, -1]

    for d in range(4):

        nr = r - dr[d]
        nc = c - dc[d]

        if boundry_check(nr, nc) and board[nr][nc] == number:
            continue

        nr = r + dr[d]
        nc = c + dc[d]
        count = 1

        while boundry_check(nr, nc) and board[nr][nc] == number:
            count += 1
            nr += dr[d]
            nc += dc[d]

        if count == 5:
            return number, nr-dr[d], nc-dc[d]

    return 0, -1, -1

def boundry_check(r, c):
    return False if r < 0 or c < 0 or r >= 19 or c >= 19 else True

solution()