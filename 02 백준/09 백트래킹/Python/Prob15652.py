
"""
title  : 15652. N과 M (4) (Silver 3)
time   : 52ms       160ms
memory : 31120KB    111956KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())

    def make(idx:int, count:int, word:list):

        if count == M:
            print(" ".join(word))
            return
        
        for jdx in range(idx, N+1):
            word.append(str(jdx))
            make(jdx, count+1, word)
            word.pop()

    make(1, 0, [])

solution()