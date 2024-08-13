
"""
title  : 5568. 카드 놓기 (Silver 4)
time   : 44ms        116ms
memory : 31632KB     110920KB
"""

import sys
from itertools import permutations

def solution():

    input = sys.stdin.readline

    N = int(input())                                    # 카드 개수 
    K = int(input())                                    # 선택할 카드 개수
    cards = [input().rstrip() for _ in range(N)]        # 카드

    answer = set()

    for temp in list(permutations(cards, K)):
        answer.add(int("".join(temp)))

    return len(answer)

print(solution())