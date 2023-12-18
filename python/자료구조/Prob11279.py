
""" 실버 2. 최대 힙 """

import sys
from heapq import heappush, heappop

def solution():

    input = sys.stdin.readline
    N = int(input())                # 연산의 개수

    answer = []
    
    for _ in range(N):

        command = int(input())

        if command:
            heappush(answer, -command)
        else:
            print(-(heappop(answer)) if answer else 0)

solution()