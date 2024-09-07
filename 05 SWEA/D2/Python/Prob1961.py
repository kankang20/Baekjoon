
"""
title  : 1961. 숫자 배열 회전 (D2)
time   : 119ms
memory : 43796kb
"""

def solution():

    T = int(input())
    for tc in range(1, T+1):

        N = int(input())
        board = [list(input().rstrip().split()) for _ in range(N)]

        board_90 = compute(N, board)
        board_180 = compute(N, board_90)
        board_270 = compute(N, board_180)

        print(f'#{tc}')
        for i in range(N):
            print("".join(board_90[i]), "".join(board_180[i]), "".join(board_270[i]))

def compute(N:int, board:list):

    target = [[0] * N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            target[i][j] = board[N-j-1][i]

    return target

solution()