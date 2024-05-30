
""" 실버 4. 국영수 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())

    answer = []
    for _ in range(N):
        temp = list(input().rstrip().split())
        answer.append((temp[0], int(temp[1]), int(temp[2]), int(temp[3])))

    answer.sort(key=lambda x: (-x[1], x[2], -x[3], x[0]))

    for ans in answer:
        print(ans[0])

solution()