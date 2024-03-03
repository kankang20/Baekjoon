
""" 골드 5. 파이프 옮기기 1 """

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]

    return bfs(N, board)

def bfs(N:int, board:list):

    # 0 가로 방향 1 세로 방향 2 대각선 방향
    q = deque()
    q.append((0, 1, 0))

    answer = 0
    while q:

        r, c, dir = q.popleft()

        if r == N-1 and c == N-1:
            answer += 1
            continue

        if (dir == 0 or dir == 2) and c + 1 < N and board[r][c+1] == 0:
            q.append((r, c+1, 0))
        
        if (dir == 1 or dir == 2) and r + 1 < N and board[r+1][c] == 0:
            q.append((r+1, c, 1))

        if r + 1 < N and c + 1 < N and board[r][c+1] == 0 and board[r+1][c] == 0 and board[r+1][c+1] == 0:
            q.append((r+1, c+1, 2))

    return answer

print(solution())