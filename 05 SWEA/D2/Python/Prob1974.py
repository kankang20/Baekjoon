
"""
title  : 1974. 스도쿠 검증 (D2)
time   : 107ms
memory : 45036kb
"""

def solution():

    T = int(input())
    for tc in range(1, T+1):

        board = [list(map(int, input().split())) for _ in range(9)]

        answer = 1
        for i in range(9):
            if not check_line(board, i):
                answer = 0
                break
        
        else:
            for i in range(0, 9, 3):
                if not check_square(board, i):
                    answer = 0
                    break

        print(f'#{tc} {answer}')

def check_line(board:list, target:int):

    row = [False] * 10
    col = [False] * 10

    for j in range(9):

        if row[board[target][j]] or col[board[j][target]]:
            return False

        row[board[target][j]] = True
        col[board[j][target]] = True

    return True

def check_square(board:list, target:int):

    check = [False] * 10

    for i in range(3):
        for j in range(3):

            if check[board[target+i][target+j]]:
                return False
            
            check[board[target+i][target+j]] = True

    return True

solution()