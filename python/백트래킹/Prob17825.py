
""" 골드 2. 주사위 윷놀이 """

import sys

def solution():
    input = sys.stdin.readline

    dice = list(map(int, input().split()))

    target = [(0, 0)] * 4

    global answer
    answer = 0

    board = [[idx*2 for idx in range(21)],
            [10, 13, 16, 19, 25, 30, 35, 40],
            [20, 22, 24, 25, 30, 35, 40],
            [30, 28, 27, 26, 25, 30, 35, 40]]

    def dfs(ddx, target, ans):

        if ddx == 10:
            global answer
            answer = max(answer, ans)
            return
        
        for tdx in range(4):

            row, col = target[tdx]

            if row == 0:
                num = board[row][col]
                if num % 10 == 0:
                    ans += board[num // 10][dice[ddx] - 1]
                    target[tdx] = (num // 10, col)
                else:
                    if col + dice[ddx] < len(board[0]):
                        ans += board[0][col + dice[ddx]]
                        target[tdx] = (0, col + dice[ddx], 0)
            # elif row == 1:
            # elif row == 2:
            # elif row == 3:




    dfs(0, 0, target, 0)
    return answer

print(solution())
