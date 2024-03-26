
""" 골드 4. 감시 """

import sys

direction = [(-1, 0), (0, 1), (1, 0), (0, -1)]

def solution():
    input = sys.stdin.readline

    global R, C
    R, C = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(R)]

    cctv = []

    global answer
    answer = R*C

    for r in range(R):
        for c in range(C):
            if board[r][c] == 0:
                answer += 1
            elif 1 <= board[r][c] <= 5:
                cctv.append((r, c))

    cctv_direction = [0, [[0], [1], [2], [3]], 
                [[0, 2], [1, 3]], 
                [[0, 1], [1, 2], [2, 3], [3, 0]],
                [[0, 1, 2], [1, 2, 3], [2, 3, 0], [3, 0, 1]],
                [[0, 1, 2, 3]]]

    dfs(board, cctv, 0, cctv_direction)

    return answer

def count_area(board):
        zero = 0
        for r in range(R):
            for c in range(C):
                if board[r][c] == 0:
                    zero += 1
        return zero

def dfs(board, cctv, idx, cctv_dir):

    if idx == len(cctv):
        global answer
        answer = min(answer, count_area(board))
        return

    r = cctv[idx][0]
    c = cctv[idx][1]
    cctv_num = board[r][c]

    for cc in cctv_dir[cctv_num]:
        make_board(board, cc, r, c, -1)
        dfs(board, cctv, idx+1, cctv_dir)
        make_board(board, cc, r, c, 0)

def make_board(board, dir, sr, sc, num):

    for d in dir:

        nr = sr + direction[d][0]
        nc = sc + direction[d][1]

        while 0 <= nr < R and 0 <= nc < C and board[nr][nc] < 6:
            if board[nr][nc] == -1 or board[nr][nc] == 0:
                board[nr][nc] = num
            nr += direction[d][0]
            nc += direction[d][1]   




print(solution())