
""" Lv 4. 징검다리2 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())                            # 돌의 개수 
    rocks = list(map(int, input().split()))     # 돌들

    up_count = [1] * N
    down_count = [1] * N

    answer = 0

    # 오름차순
    for idx in range(0, N):
        for jdx in range(0, idx):
            if rocks[jdx] < rocks[idx]:
                up_count[idx] = max(up_count[idx], up_count[jdx]+1)
    
    # 내림차순
    for idx in range(0, N):
        for jdx in range(0, idx):
            if rocks[jdx] > rocks[idx]:
                down_count[idx] = max(down_count[idx], down_count[jdx] + 1)
        answer = max(answer, up_count[idx] + down_count[idx])

    return answer

print(solution())