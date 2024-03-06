
""" 골드 5. 마법사 상어와 비바라기 """

import sys
from collections import deque

dir = [0, (0, -1), (-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1)]
check = [(-1, -1), (-1, 1), (1, 1), (1, -1)]

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())    # board 크기 N, 명령 개수 M
    board = [list(map(int, input().split())) for _ in range(N)]

    # 비바라기 시전 - (N-1, 0) (N-1, 1) (N-2, 0) (N-2, 1)에 비구름 생성
    q = deque([(N-1, 0), (N-1, 1), (N-2, 0), (N-2, 1)])

    cloud_board = [[False] * N for _ in range(N)]

    for _ in range(M):
        d, s = map(int, input().split())

        while q:
            r, c = q.popleft()

            # 1. 모든 구름이 d 방향으로 s칸 이동
            # 2. 구름이 있는 칸의 물의 양이 1 증가
            # 3. 구름 다 사라짐
            nr = r + (dir[d][0] * s)
            nc = c + (dir[d][1] * s)

            while nr < 0:
                nr += N

            while nc < 0:
                nc += N

            nr %= N
            nc %= N

            board[nr][nc] += 1
            cloud_board[nr][nc] = True
            print("cloud = ", r, c, " -> ", nr, nc)
            for b in board:
                print(b)
            print("---------")

            # 4. 물이 증가한 칸에 물복사버그 마법 시전
            #    대각선 방향으로 거리가 1인 칸에 물이 있는 경우만큼 물의 양 증가
            count = 0
            for c in check:
                nnr = nr + c[0]
                nnc = nc + c[1]

                if 0 <= nnr < N and 0 <= nnc < N and board[nnr][nnc] > 0:
                    count += 1

            board[nr][nc] += count

        # 5. 바구니에 저장된 물의 양이 2 이상인 칸에 구름 생성 - 물의 양 2 감소 (구름이 사라진 칸이면 안됨)
        for r in range(N):
            for c in range(N):
                if cloud_board[r][c]:
                    cloud_board[r][c] = False
                else:
                    if board[r][c] >= 2:
                        q.append((r, c))
                        board[r][c] -= 2

        print(q)
        for b in board:
            print(b)

        print("-----------------------------------------")

    answer = 0
    for n in range(N):
        answer += sum(board[n])

    return answer

print(solution())

# 5 4
# 0 0 1 0 2
# 2 3 2 1 0
# 4 3 2 9 0
# 1 0 2 9 0
# 8 8 2 1 0
# 1 3
# 3 4
# 8 1
# 4 8