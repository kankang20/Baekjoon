
""" 1182. 부분 수열의 합 """

import sys

answer = 0

def solution():
    input = sys.stdin.readline

    global N, S, numbers
    N, S = map(int, input().split())            # 정수의 개수 N, 정수 S
    numbers = list(map(int, input().split()))   # 정수들

    select_number(0, 0)

    return answer

def select_number(idx:int, total_sum:int):

    if idx == N:
        return
    
    total_sum += numbers[idx]
    
    if total_sum == S:
        global answer
        answer += 1

    select_number(idx + 1, total_sum - numbers[idx])
    select_number(idx + 1, total_sum)

print(solution())
