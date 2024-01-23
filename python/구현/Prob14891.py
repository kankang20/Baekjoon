
""" 골드 5. 톱니바퀴 """

import sys
from collections import deque           # rotate 활용하기

def solution():
    input = sys.stdin.readline

    state = [deque()]
    for _ in range(4):
        state.append(deque(list(input().rstrip())))

    K = int(input())
    for _ in range(K):

        num, dir = map(int, input().split())        # 톱니바퀴 번호, 방향 (1 시계방향 -1 반시계방향)
        
        state[num].rotate(dir)

        temp_dir = dir
        for n in range(num-1, 0, -1):

            if (temp_dir == 1  and state[n][2] == state[n+1][7]) or (temp_dir == -1 and state[n][2] == state[n+1][5]):
                break

            temp_dir = -temp_dir
            state[n].rotate(temp_dir)
        
        temp_dir = dir
        for n in range(num+1, 5, 1):

            if (temp_dir == 1 and state[n-1][3] == state[n][6]) or (temp_dir == -1 and state[n-1][1] == state[n][6]):
                break

            temp_dir = -temp_dir
            state[n].rotate(temp_dir)

    # 최종 계산
    answer = 0
    answer += (1 if state[1][0] == '1' else 0)
    answer += (2 if state[2][0] == '1' else 0)
    answer += (4 if state[3][0] == '1' else 0)
    answer += (8 if state[4][0] == '1' else 0)
    
    return answer

print(solution()) 