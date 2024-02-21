
""" 실버 1. 카드 합체 놀이 """

import sys
from heapq import heappush, heappop, heapify

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())                        # 카드의 개수 N, 카드 합체 수 M
    numbers = list(map(int, input().split()))     # 카드들

    heapify(numbers)
    for _ in range(M):
        num = heappop(numbers) + heappop(numbers)
        heappush(numbers, num)
        heappush(numbers, num)

    return sum(numbers)

print(solution())