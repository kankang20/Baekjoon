
""" 실버 3. 파일 정리 """

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