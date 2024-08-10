
"""
title  : 1021. 회전하는 큐 (Silver 3)
time   : 68ms       136ms
memory : 34160KB    113164KB
"""

import sys
from collections import deque

def solution():
    input = sys.stdin.readline
    
    N, M = map(int, input().split())
    numbers = deque([num for num in range(1, N+1)])
    position = list(map(int, input().split()))

    answer = 0
    for p in position:

        idx = 0
        while numbers[idx] != p:
            idx += 1

        left_move = idx                     # 왼쪽으로 이동 횟수
        right_move = len(numbers) - idx     # 오른쪽으로 이동 횟수

        if left_move <= right_move:
            numbers.rotate(-left_move)
            answer += left_move
        else:
            numbers.rotate(right_move)
            answer += right_move

        numbers.popleft()
    
    return answer

print(solution())