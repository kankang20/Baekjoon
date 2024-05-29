
""" 실버 4. 접미사 배열 """

import sys

def solution():
    input = sys.stdin.readline

    word = input().rstrip()

    answer = []
    for idx in range(len(word)):
        answer.append(word[idx:])

    for ans in sorted(answer):
        print(ans)

solution()