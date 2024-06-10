
""" 실버 2. 최소 힙 """

import sys
from heapq import heappush, heappop

def solution():
    input = sys.stdin.readline

    N = int(input())

    number = []
    for _ in range(N):
        num = int(input())

        if num == 0:
            print(heappop(number) if number else 0)
            continue
        heappush(number, num)

solution()