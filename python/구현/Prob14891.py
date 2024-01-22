
""" 골드 5. 톱니바퀴 """

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    state = [0]
    for _ in range(4):
        state.append(deque(list(input().rstrip())))

    K = int(input())
    for _ in range(K):

        num, dir = map(int, input().split())    # 톱니바퀴 번호, 방향 (1 시계방향 -1 반시계방향)

        if dir == 1:
            dir = True
        elif dir == -1:
            dir = False

        # 해당 톱니바퀴 회전
        move(state[num], dir)
        
        # 왼쪽 톱니바퀴들 이동
        temp_dir = dir
        for n in range(num-1, 0, -1):
            
            if (temp_dir and state[n][2] == state[n+1][7]) or (not temp_dir and state[n][2] == state[n+1][5]):
                break

            # 극이 다르다면 이전 톱니바퀴가 회전한 반대방향으로 회전
            temp_dir = not temp_dir
            move(state[n], temp_dir)
        
        # 오른쪽 톱니바퀴 이동
        temp_dir = dir
        for n in range(num+1, 4, 1):

            if (temp_dir and state[n-1][1] == state[n][6]) or (not temp_dir and state[n-1][3] == state[n][6]):
                break

            # 극이 다르다면
            temp_dir = not temp_dir
            move(state[n], temp_dir)

        print("----------------------------------------------------------")
        print("state : ")
        for s in state[1:]:
            print(s)

    # 최종 계산
    answer = 0
    answer += (1 if state[1][0] == '1' else 0)
    answer += (2 if state[2][0] == '1' else 0)
    answer += (4 if state[3][0] == '1' else 0)
    answer += (8 if state[4][0] == '1' else 0)
    
    return answer

def move(one_state:deque, dir:bool):

    if dir:
        one_state.appendleft(one_state.pop())
    else:
        one_state.append(one_state.popleft())


print(solution()) 