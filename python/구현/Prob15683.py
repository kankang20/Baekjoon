
""" 골드 4. 감시 """

import sys

def solution():
    input = sys.stdin.readline

    global R, C
    R, C = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(R)]

    global answer
    answer = R*C

    cctv = []
    for r in range(R):
        for c in range(C):
            if 1 <= board[r][c] <= 5:
                cctv.append((r, c, board[r][c]))

    direction = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    cctv_direction = [0, [[0], [1], [2], [3]], 
                [[0, 2], [1, 3]], 
                [[0, 1], [1, 2], [2, 3], [3, 0]],
                [[0, 1, 2], [1, 2, 3], [2, 3, 0], [3, 0, 1]],
                [[0, 1, 2, 3]]]

    def count_area(board):
        return sum(board[r].count(0) for r in range(R))

    def dfs(idx):

        if idx == len(cctv):
            global answer
            answer = min(answer, count_area(board))
            return

        r, c, cctv_num = cctv[idx]
        for cc in cctv_direction[cctv_num]:
            make_board(cc, r, c, 1)
            dfs(idx+1)
            make_board(cc, r, c, -1)

    def make_board(dir, sr, sc, num):

        for d in dir:
            nr = sr + direction[d][0]
            nc = sc + direction[d][1]
            while 0 <= nr < R and 0 <= nc < C and board[nr][nc] < 6:
                board[nr][nc] += num
                nr += direction[d][0]
                nc += direction[d][1]   

    dfs(0)

    return answer

print(solution())