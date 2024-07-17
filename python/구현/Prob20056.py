
""" 골드 4. 마법사 상어와 파이어볼 """

import sys

dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, 1, 1, 1, 0, -1, -1, -1]

def solution():
    input = sys.stdin.readline

    N, M, K = map(int, input().split())
    
    fireballs = []
    for _ in range(M):
        r, c, m, d, s = map(int, input().split())
        fireballs.append((r-1, c-1, m, d, s))

    for _ in range(K):
        board = [[0] * N for _ in range(N)]

        # 1. 모든 파이어볼이 자신의 방향 d로 속력 s칸 만큼 이동한다.
        move_fireballs(N, board, fireballs)

        # 2. 

def move_fireballs(N:int, board:list, fireballs:list):

    for (r, c, m, d, s) in fireballs:
        nr = (r + dr[d] * s) % N
        nc = (c + dc[d] * s) % N

        board[nr][nc] += 1



    


print(solution())