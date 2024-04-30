
""" 골드 5. 상범 빌딩 """

import sys
from collections import deque

dh = [0, 0, 0, 0, 1, -1]
dr = [1, -1, 0, 0, 0, 0]
dc = [0, 0, 1, -1, 0, 0]

def solution():
    input = sys.stdin.readline

    while True:

        L, R, C = map(int, input().split())     # 층 L, 행 R, 열 C

        if L == 0 and R == 0 and C == 0:
            break
        
        board = []
        for _ in range(L):
            temp = [list(input().rstrip()) for _ in range(R)]
            input()
            board.append(temp)

        print(bfs(board, L, R, C))
        
def bfs(board, L, R, C):

    q = deque()

    pos = search(board, L, R, C)
    q.append((pos[0], pos[1], pos[2], 0))
    board[pos[0]][pos[1]][pos[2]] = '#'

    print(pos[0], pos[1], pos[2])
    
    while q:

        h, r, c, count = q.popleft()
        if board[h][r][c] == 'E':
            return "Escaped in {0} minute(s).".format(count)

        for d in range(6):
            nh = h + dh[d]
            nr = r + dr[d]
            nc = c + dc[d]

            if nh < 0 or nh >= L or nr < 0 or nr >= R or nc < 0 or nc >= C:
                continue

            if board[nh][nr][nc] == '#':
                continue

            print(nh, nr, nc)

            q.append((nh, nr, nc, count+1))
            board[nh][nr][nc] = '#'

    return 'Trapped!'

def search(board, L, R, C):
    for h in range(L):
        for r in range(R):
            for c in range(C):
                if board[h][r][c] == 'S':
                    return (h, r, c)




solution()