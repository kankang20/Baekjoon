
""" 실버 3. 풍선 터뜨리기 """

import sys
from collections import deque

def solution():

    input = sys.stdin.readline
    N = int(input())                                                                                # 풍선 개수
    balloons = deque((idx+1, num) for (idx, num) in enumerate(list(map(int, input().split()))))        # 각 풍선 안의 종이에 적혀있는 수

    while balloons:

        (idx, number) = balloons.popleft()
        print(idx, end = " ")

        if balloons:

            if number > 0:
                number -= 1
            else:
                while number < 0:
                    number += len(balloons)
            
            while number > 0:
                balloons.append(balloons.popleft())
                number -= 1

solution()