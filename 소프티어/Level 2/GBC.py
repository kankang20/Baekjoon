
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

    print(normal_state)
    
    idx = 0
    for _ in range(M):
        test_length, test_speed = map(int, input().split())
        


solution()