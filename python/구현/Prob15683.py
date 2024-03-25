
""" 골드 4. 감시 """

import sys

def solution():
    input = sys.stdin.readline

    global R, C
    R, C = map(int, input().split())
    board = list(map(int, input().split()))

    cctv = []
    for r in range(R):
        for c in range(C):
            if 1 <= board[r][c] <= 5:
                cctv.append((r, c))

    dir = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    cctv_dir = [0, [0, 1, 2, 3], 
                [(0, 2), (1, 3)], 
                [(0, 1), (1, 2), (2, 3), (3, 0)]
                [(0, 1, 2), (1, 2, 3), (2, 3, 0), (3, 0, 1)],
                [(0, 1, 2, 3)]]

    answer = 0

def count_area(board):
        zero = 0
        for r in range(R):
            zero += board[r].count(0)
        return zero

def dfs(board, cctv, idx, cctv_dir, dir):

    if idx == len(cctv):
            answer = min(answer, count_area(board))

    r = cctv[idx][0]
    c = cctv[idx][1]
    cctv_num = board[r][c]

    if cctv_num == 1:
        
        for cc in cctv_dir[cctv_num]:
            
                



print(solution())