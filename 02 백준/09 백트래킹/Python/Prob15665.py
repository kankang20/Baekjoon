
"""
title  : 15665. N과 M (11) (Silver 2)
time   : 620ms        528ms
memory : 57744KB      145244KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())
    numbers = sorted(list(map(int, input().split())))

    check = set()

    def make(count:int, answer:list):

        if count == M:
            temp = " ".join(answer)
            if temp not in check:
                print(temp)
                check.add(temp)
            return
        
        for idx in range(N):
            answer.append(str(numbers[idx]))
            make(count+1, answer)
            answer.pop()

    make(0, [])

solution()