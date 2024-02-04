
""" Lv 2. [21년 재직자 대회 예선] 전광판 """

import sys

def solution():
    input = sys.stdin.readline

    T = int(input())    # 테스트케이스 

    # 0 1 2 3 4 5 6 7 8 9
    global board
    board = [[1, 1, 0, 1, 1, 1, 1], [0, 0, 0, 1, 0, 0, 1], [1, 0, 1, 1, 1, 1, 0] ,[1, 0, 1, 1, 0, 1, 1], [0, 1, 1, 1, 0, 0, 1], 
                [1, 1, 1, 0, 0, 1, 1], [1, 1, 1, 0, 1, 1, 1], [1, 1, 0, 1, 0, 0, 1], [1, 1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 0, 1, 1]]
    
    for _ in range(T):

        state, target = input().rstrip().split()

        answer = 0
        sdx, tdx = len(state)-1, len(target)-1
        while sdx >= 0 or tdx >= 0:
            
            if sdx < 0:
                answer += calculate_count(-1, int(target[tdx]))
            elif tdx < 0:
                answer += calculate_count(int(state[sdx]), -1)
            else:
                answer += calculate_count(int(state[sdx]), int(target[tdx]))
            
            sdx -= 1
            tdx -= 1

        print(answer)

def calculate_count(state:int, target:int):

    if state == -1:  
        return board[target].count(1)
    elif target == -1: 
        return board[state].count(1)
    else:
        board_state, board_target, answer = board[state], board[target], 0
        for idx in range(7):
            if board_state[idx] != board_target[idx]:
                answer += 1
        return answer

solution()