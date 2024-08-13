
"""
title  : 20291. 파일 정리 (Silver 3)
time   : 204ms        324ms
memory : 41104KB      125384KB
"""

import sys

def solution() -> dict:

    input = sys.stdin.readline
    N = int(input())    # 파일 개수

    Extension = {}

    for _ in range(N):
        extension = input().rstrip().split(".")[1]
        Extension[extension] = Extension.get(extension, 0) + 1

    return Extension

answer = solution()
for key in sorted(answer.keys()):
    print(key, answer[key], sep=" ")