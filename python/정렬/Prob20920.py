
""" 실버 3. 영단어 암기는 괴로워 """

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())

    word = dict()

    for _ in range(N):
        w = input().rstrip()

        if M <= len(w):
            word[w] = word.get(w, 0) + 1

    for (k, _) in sorted(word.items(), key=lambda x: (-x[1], -len(x[0]), x[0])):
        print(k)

solution()