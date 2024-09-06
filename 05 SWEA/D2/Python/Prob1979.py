
"""
title  : 1979. 어디에 단어가 들어갈 수 있을까 (D2)
time   : 109ms
memory : 45036kb
"""

def solution():

    T = int(input())
    for tc in range(1, T+1):

        N, K = map(int, input().split())
        board = [list(map(int, input().split())) for _ in range(N)]

        answer = 0
        for i in range(N):

            count = 0
            for j in range(N):
                if board[i][j] == 1:
                    count += 1
                if board[i][j] == 0 or j == (N-1):
                    if count == K:
                        answer += 1
                    count = 0

            for j in range(N):
                if board[j][i] == 1:
                    count += 1
                if board[j][i] == 0 or j == (N-1):
                    if count == K:
                        answer += 1
                    count = 0

        print(f'#{tc} {answer}')

solution()