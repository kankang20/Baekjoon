
""" Lv 3. [HSAT 2회 정기 코딩 인증평가 기출] Garage game """

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    N = int(input())    # 차고 격자 칸의 가로, 세로

    waiting = []
    waiting_index = [2*N - 1] * N
    for _ in range(2*N):
        waiting.append(list(map(int, input().split())))

    global board
    board = []
    for _ in range(N):
        board.append(list(map(int, input().split())))

    # 게임은 3판 진행합니다.
    answer = 0
    for _ in range(3):

        # 어느 자동차를 선택하면 가장 많은 점수를 획득할 수 있을까?
        visited = [[0] * N for _ in range(N)]
        grade, index, answer_index = 0, 1, 0
        for r in range(N):
            for c in range(N):
                if not visited[r][c]:
                    temp = bfs(N, visited, index, r, c, board[r][c])
                    if grade < temp:
                        grade = temp
                        answer_index = index
                    index += 1

        answer += grade
        for r in range(N):
            for c in range(N):
                if visited[r][c] == answer_index:
                    board[r][c] = -1

        # 자리 채워넣기!
        for cdx in range(N):

            rdx = N-1
            while rdx >= 0 and board[rdx][cdx] != -1:
                rdx -= 1

            rrdx, wdx = rdx, waiting_index[cdx]
            while rrdx >= 0 and wdx >= 0:
                board[rrdx][cdx] = waiting[wdx][cdx]
                rrdx -= 1
                wdx -= 1
            
            waiting_index[cdx] = wdx

        print("-----------------------------")
        for b in board:
            print(b)

    return answer

def bfs(N, visited, index, r, c, value):

    q = deque()

    q.append((r, c))
    visited[r][c] = index

    count = 1
    minR, maxR, minC, maxC = r, r, c, c

    while q:

        r, c = q.popleft()

        for (dr, dc) in [(0, 1), (1, 0), (-1, 0), (0, -1)]:

            nr = r + dr
            nc = c + dc

            if nr < 0 or nr >= N or nc < 0 or nc >= N:
                continue

            if visited[nr][nc] or board[nr][nc] != value:
                continue

            q.append((nr, nc))
            visited[nr][nc] = index

            count += 1
            minR = min(minR, nr)
            maxR = max(maxR, nr)
            minC = min(minC, nc)
            maxC = max(maxC, nc)

    return count + (maxR - minR + 1) * (maxC - minC + 1)

print(solution())

# 2
# 1 1
# 2 2
# 1 1
# 3 3
# 4 4
# 1 2

# 3
# 8 5 1
# 9 6 1
# 10 7 1
# 11 1 3
# 12 1 3
# 13 1 3
# 1 2 2
# 1 2 2
# 1 2 2