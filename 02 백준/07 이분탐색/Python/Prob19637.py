
"""
title  : 19637. IF문 좀 대신 써줘 (Silver 3)
time   : 400ms       320ms
memory : 47396KB     130744KB
"""

import sys

input = sys.stdin.readline
N, M = map(int, input().split())    # 칭호의 개수 N, 칭호를 출력해야 하는 캐릭터들의 개수 M
awards = []
for _ in range(N):
    name, grade = input().split()
    awards.append((name, int(grade)))


def solution(start, end, target):
    answer = 0

    while start <= end:

        mid = (start + end) // 2

        if awards[mid][1] >= target:
            answer = mid
            end = mid - 1
        else:
            start = mid + 1

    return awards[answer][0]


for _ in range(M):
    grade = int(input())
    print(solution(0, N-1, grade))