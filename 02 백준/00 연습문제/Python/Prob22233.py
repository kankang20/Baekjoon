
"""
title  : 22233. 가희와 키워드 (Silver 3)
time   : 864ms      1036ms
memory : 53648KB    151472KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())

    answer = 0

    keyword = {}
    for _ in range(N):
        keyword[input().rstrip()] = 1
        answer += 1

    for _ in range(M):
        for word in list(input().rstrip().split(",")):
            if keyword.pop(word, 0):
                answer -= 1
        print(answer)

solution()