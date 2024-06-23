
""" 실버 3. 가희와 키워드 """

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