
"""
title  : 15650. N과 M (2) (Silver 3)
time   : 40ms       124ms
memory : 31120KB    108080KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())

    def make(idx:int, count:int, word:list):

        if count == M:
            print(" ".join(word))
            return
        
        for jdx in range(idx+1, N+1):
            word.append(str(jdx))
            make(jdx, count+1, word)
            word.pop()

    make(0, 0, [])

solution()