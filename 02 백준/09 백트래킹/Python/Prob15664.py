
"""
title  : 15664. N과 M (10) (Silver 2)
time   : 40ms        108ms
memory : 31120KB     108080KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())
    numbers = sorted(list(map(int, input().split())))

    check = set()

    def make(idx:int, count:int, answer:list):

        if count == M:
            temp = " ".join(answer)
            if temp not in check:
                print(temp)
                check.add(temp)
            return

        for jdx in range(idx+1, N):
            answer.append(str(numbers[jdx]))
            make(jdx, count+1, answer)
            answer.pop()

    make(-1, 0, [])

solution()