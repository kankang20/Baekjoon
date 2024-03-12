
""" 골드 5. 마법사 상어와 비바라기 """

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())    # board 크기 N, 명령 개수 M
    board = [list(map(int, input().split())) for _ in range(N)]

    move_dir = [0, (0, -1), (-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1)]
    check_dir = [(-1, -1), (-1, 1), (1, 1), (1, -1)]

    # 비바라기 시전
    cloud = deque([(N-1, 0), (N-1, 1), (N-2, 0), (N-2, 1)])

    for _ in range(M):
        d, s = map(int, input().split())

        cloud_water = []
        while cloud:
            r, c = cloud.popleft()

            # 1. 모든 구름이 d 방향으로 s칸 이동
            # 2. 구름이 있는 칸의 물의 양이 1 증가
            # 3. 구름 다 사라짐
            nr = (r + (move_dir[d][0] * s)) % N
            nc = (c + (move_dir[d][1] * s)) % N

            board[nr][nc] += 1
            cloud_water.append((nr, nc))

        # 4. 물이 증가한 칸에 물복사버그 마법 시전
        #    대각선 방향으로 거리가 1인 칸에 물이 있는 경우만큼 물의 양 증가
        for idx in range(len(cloud_water)):
            
            r, c = cloud_water[idx]
            count = 0
            for check in check_dir:
                nr = r + check[0]
                nc = c + check[1]

                if 0 <= nr < N and 0 <= nc < N and board[nr][nc] > 0:
                    count += 1

            board[r][c] += count

        # 5. 바구니에 저장된 물의 양이 2 이상인 칸에 구름 생성 - 물의 양 2 감소 (구름이 사라진 칸이면 안됨)
        cloud_water = set(cloud_water)
        for r in range(N):
            for c in range(N):
                if (r, c) not in cloud_water and board[r][c] >= 2:
                    cloud.append((r, c))
                    board[r][c] -= 2

    answer = 0
    for n in range(N):
        answer += sum(board[n])

    return answer

print(solution())