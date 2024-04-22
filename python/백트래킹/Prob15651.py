
""" 실버 3. N과 M (3) """

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())

    def make(count:int, word:list):

        if count == M:
            print(" ".join(word))
            return
        
        for jdx in range(1, N+1):
            word.append(str(jdx))
            make(count+1, word)
            word.pop()

    make(0, [])

solution()