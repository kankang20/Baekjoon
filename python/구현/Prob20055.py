
""" 골드 5. 컨베이어 벨트 위의 로봇 """

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    N, K = map(int, input().split())    
    
    count = 0
    belt = deque()
    for ab in list(map(int, input().split())):
        belt.append((0, ab))
        if ab == 0:
            count += 1

    step = 0
    while True:

        step += 1

        # 1. 벨트가 각 칸 위에 있는 로봇과 함께 한칸 회전한다.
        belt.rotate(1)
        pull_robot(N, belt)

        # 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한칸 이동한다.
        for idx in range(N-2, -1, -1):
            # 2-1. 현재 위치에 로봇이 존재하고, 이동하려는 칸에는 로봇이 없으며 그 칸의 내구도가 1 이상 일때
            if belt[idx][0] == 1 and belt[idx+1][0] == 0 and belt[idx+1][1] > 0:
                belt[idx] = (0, belt[idx][1])
                belt[idx+1] = (1, belt[idx+1][1]-1)
                if belt[idx+1][1] == 0:
                    count += 1

        pull_robot(N, belt)    
        
        # 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
        if belt[0][1] > 0:
            belt[0] = (1, belt[0][1]-1)
            if belt[0][1] == 0:
                count += 1

        # 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다.
        if count >= K:
            break

    return step

def pull_robot(N:int, belt:deque):
    # 내리는 위치에 로봇이 도달하면 그 즉시 내린다.
    if belt[N-1][0] == 1:
        belt[N-1] = (0, belt[N-1][1])

print(solution())