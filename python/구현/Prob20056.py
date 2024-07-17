
""" 골드 4. 마법사 상어와 파이어볼 """

import sys
from collections import deque

dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, 1, 1, 1, 0, -1, -1, -1]

def solution():
    input = sys.stdin.readline

    N, M, K = map(int, input().split())
    
    fireballs = deque()
    for _ in range(M):
        r, c, m, d, s = map(int, input().split())
        fireballs.append((r-1, c-1, m, d, s))

    board = [[deque() for _ in range(N)] for _ in range(N)]

    for _ in range(K):

        # 1. 모든 파이어볼이 자신의 방향 d로 속력 s칸 만큼 이동한다.
        while fireballs:
            r, c, m, d, s = fireballs.popleft()
            nr = (r + dr[d] * s) % N
            nc = (c + dc[d] * s) % N
            board[nr][nc].append((m, d, s))

        # 2. 이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 칸에서는 다음과 같은 일이 일어난다.
        for r in range(N):
            for c in range(N):
                
                if len(board[r][c]) >= 2:
                    # 2-1. 같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
                    # 2-2. 파이어볼은 4개의 파이어볼로 나누어진다.
                    # 2-3. 나누어진 파이어볼의 질량, 속력, 방향은 다음과 같다. 
                    temp = board[r][c]

                    




    


print(solution())