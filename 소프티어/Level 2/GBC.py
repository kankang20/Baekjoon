
""" Lv 2. GBC """

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())       

    normal_state, previous_length = [], 0
    for _ in range(N):
        length, speed = map(int, input().split())   # 구간의 길이 length, 제한 속도 speed
        normal_state.append((previous_length + length, speed))
        previous_length += length
    
    answer = 0
    idx, previous_length = 0, 0
    for _ in range(M):

        test_length, test_speed = map(int, input().split())
        test_length += previous_length

        answer = max(answer, test_speed - normal_state[idx][1])
        while idx+1 < N and normal_state[idx][0] < test_length:
            idx += 1
            answer = max(answer, test_speed - normal_state[idx][1])

        previous_length += test_length

    return answer

print(solution())