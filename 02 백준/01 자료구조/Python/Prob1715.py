
"""
title  : 1715. 카드 정렬하기 (Gold 4)
time   : 148ms      268ms
memory : 33972KB    116308KB
"""

import sys
from heapq import heappush, heappop

def solution():
    input = sys.stdin.readline

    N = int(input())

    card = []
    for _ in range(N):
        heappush(card, int(input()))

    answer = 0
    for _ in range(N-1):
        temp = (heappop(card) + heappop(card))
        answer += temp
        heappush(card, temp)
    
    return answer

print(solution())