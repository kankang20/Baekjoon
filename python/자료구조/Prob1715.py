
""" 골드 4. 카드 정렬하기 """

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
        answer += (heappop(card) + heappop(card))
        heappush(card, answer)
    
    return answer

print(solution())