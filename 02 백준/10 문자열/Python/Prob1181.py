
"""
title  : 1181. 단어 정렬 (Silver 5)
time   : 100ms       224ms
memory : 36552KB     115388KB
"""

import sys

def solution():

    input = sys.stdin.readline
    N = int(input())                # 단어 개수
    words = set()
    for _ in range(N):
        words.add(input().rstrip())

    for word in sorted(list(words), key=lambda x:(len(x), x)):
        print(word)

solution()