
"""
title  : 15657. N과 M (8) (Silver 3)
time   : 48ms        180ms
memory : 31120KB     113868KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())
    numbers = sorted(list(map(int, input().split())))

    def make(idx:int, count:int, answer:list):

        if count == M:
            print(" ".join(answer))
            return
        
        for jdx in range(idx, N):
            answer.append(str(numbers[jdx]))
            make(jdx, count+1, answer)
            answer.pop()

    make(0, 0, [])

solution()