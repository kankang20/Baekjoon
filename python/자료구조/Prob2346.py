
""" 실버 3. 풍선 터뜨리기 """

import sys
from collections import deque

def solution():

    input = sys.stdin.readline
    N = int(input())                                                                                # 풍선 개수
    ballons = deque((idx, num) for (idx, num) in enumerate(list(map(int, input().split()))))        # 각 풍선 안의 종이에 적혀있는 수

    while ballons:

        (idx, number) = ballons.popleft()
        print(idx+1, end = " ")

        if ballons:

            number += (-1 if number > 0 else len(ballons))
            
            while number:
                ballons.append(ballons.popleft())
                number -= 1

solution()