
""" 실버 3. 풍선 터뜨리기 """

import sys
from collections import deque

def solution():

    input = sys.stdin.readline
    N = int(input())                                                                                    # 풍선 개수
    balloons = deque((idx+1, num) for (idx, num) in enumerate(list(map(int, input().split()))))         # 각 풍선 안의 종이에 적혀있는 수

    while balloons:

        (idx, number) = balloons.popleft()
        print(idx, end = " ")

        if balloons:
            balloons.rotate(-number + (1 if number > 0 else 0))


solution()