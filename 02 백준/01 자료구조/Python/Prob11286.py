
"""
title  : 11286. 절댓값 힙 (Silver 1)
time   : 108ms       252ms
memory : 35724KB     116204KB
"""

import sys
from heapq import heappush, heappop

def solution():

    input = sys.stdin.readline
    N = int(input().rstrip())

    answer_minus = []
    answer_plus = []

    for _ in range(N):

        command = int(input().rstrip())

        if command > 0:
            heappush(answer_plus, command)
        elif command < 0:
            heappush(answer_minus, -command)
        else:
            if not answer_plus and not answer_minus:
                print(0)
                continue

            number_plus = answer_plus[0] if answer_plus else 1e9
            number_minus = answer_minus[0] if answer_minus else 1e9

            if number_plus < number_minus:
                print(heappop(answer_plus))
            else:
                print(-heappop(answer_minus))
        
solution()