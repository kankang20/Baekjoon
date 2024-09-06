
"""
title  : 2001. 파리 퇴치 (D2)
time   : 117ms
memory : 45060kb
"""

def solution():

    T = int(input())
    for tc in range(1, T+1):

        N, M = map(int, input().split())
        board = [list(map(int, input().split())) for _ in range(N)]

        answer = 0
        for r in range(M-1, N):
            for c in range(M-1, N):
                answer = max(answer, check(board, M, r, c))

        print(f'#{tc} {answer}')

def check(board:list, M:int, r:int, c:int):

    sum = 0
    for rdx in range(M):
        for cdx in range(M):
            sum += board[r - rdx][c - cdx]

    return sum

solution()