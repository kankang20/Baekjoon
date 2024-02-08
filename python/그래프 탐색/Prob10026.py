
""" 골드 5. 적록색약 """

import sys
from collections import deque

direction = [(0, 1), (1, 0), (-1, 0), (0, -1)]

def solution():
    input = sys.stdin.readline

    N = int(input())

    global board
    board = [list(input().rstrip()) for _ in range(N)]
    
    global selected
    selected = [[False] * N for _ in range(N)]
    global selected_confused
    selected_confused = [[False] * N for _ in range(N)]

    answer = 0
    answer_confused = 0
    for r in range(N):
        for c in range(N):
            if not selected[r][c]:
                answer += bfs(N, r, c, board[r][c])
            if not selected_confused[r][c]:
                answer_confused += bfs_confused(N, r, c,
                                                False if board[r][c] == "B" else True)

    return str(answer) + " " + str(answer_confused)

def bfs(N:int, r:int, c:int, value:str):

    q = deque()

    q.append((r, c))
    selected[r][c] = True

    while q:
        r, c = q.popleft()

        for dir in direction:
            nr = r + dir[0]
            nc = c + dir[1]

            if nr < 0 or nr >= N or nc < 0 or nc >= N or selected[nr][nc]:
                continue

            if board[nr][nc] == value:
                q.append((nr, nc))
                selected[nr][nc] = True

    return 1

def bfs_confused(N:int, r:int, c:int, flag:bool):

    q = deque()

    q.append((r, c))
    selected_confused[r][c] = True

    while q:
        r, c = q.popleft()

        for dir in direction:
            nr = r + dir[0]
            nc = c + dir[1]

            if nr < 0 or nr >= N or nc < 0 or nc >= N or selected_confused[nr][nc]:
                continue

            if (not flag and board[nr][nc] == "B") or (flag and (board[nr][nc] == "R" or board[nr][nc] == "G")):
                q.append((nr, nc))
                selected_confused[nr][nc] = True

    return 1

print(solution())