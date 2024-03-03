
""" 골드 5. 파이프 옮기기 1 """

import sys

answer = 0

def solution():
    input = sys.stdin.readline

    global N, board
    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]

    dfs(0, 1, 0)

    return answer

def dfs(r, c, dir):

    if r == N-1 and c == N-1:
        global answer
        answer += 1
        return
    
    if (dir == 0 or dir == 2) and c + 1 < N and board[r][c+1] == 0:
        dfs(r, c+1, 0)
    
    if (dir == 1 or dir == 2) and r + 1 < N and board[r+1][c] == 0:
        dfs(r+1, c, 1)

    if r + 1 < N and c + 1 < N and board[r][c+1] == 0 and board[r+1][c] == 0 and board[r+1][c+1] == 0:
        dfs(r+1, c+1, 2)

print(solution())