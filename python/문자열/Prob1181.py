
""" 실버 5. 단어 정렬 """

import sys

def solution():

    input = sys.stdin.readline
    N = int(input())                # 단어 개수
    words = []
    for _ in range(N):
        word = input().rstrip()
        if word not in words:
            words.append(word)

    words.sort()
    words.sort(key=lambda x:len(x))

    for word in words:
        print(word)

solution()