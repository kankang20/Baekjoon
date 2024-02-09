
""" 골드 5. 로봇 청소기 """

import sys

# 북(0) 동(1) 남(2) 서(3)
direction = [(-1, 0), (0, 1), (1, 0), (0, -1)]

def solution():
    input = sys.stdin.readline

    global N, M
    N, M = map(int, input().split())

    robot = list(map(int, input().split()))
    room = [list(map(int, input().split())) for _ in range(N)]

    answer = 0
    four_flag, back_flag = True, True
    while True:

        # 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소
        if room[robot[0]][robot[1]] == 0:
            room[robot[0]][robot[1]] = 2
            answer += 1

        # 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
        four_flag = check_four_direction(robot, room)

        # 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
        if not four_flag:
            back_flag = check_back_direction(robot, room)

        if not back_flag:
            break

    return answer

def check_four_direction(robot, room):
# 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,

    dir = robot[2]
    for _ in range(4):

        # 2-1. 반시계 방향으로 90도 회전
        dir = (dir + 3) % 4
        nr = robot[0] + direction[dir][0]
        nc = robot[1] + direction[dir][1]

        # 2-2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한칸 전진       
        if room[nr][nc] == 0:
            robot[0], robot[1], robot[2] = nr, nc, dir
            return True

    return False

def check_back_direction(robot, room):
# 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,

    nd = (robot[2] + 2) % 4
    nr = robot[0] + direction[nd][0]
    nc = robot[1] + direction[nd][1]

    # 3-2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진 불가능
    if room[nr][nc] == 1:
        return False
    
    # 3-1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한칸 후진
    robot[0], robot[1] = nr, nc
    return True

print(solution())