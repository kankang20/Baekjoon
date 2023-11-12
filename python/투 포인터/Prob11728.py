
""" 실버 5. 배열 합치기 """

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())    # 배열 A의 크기 N, 배열 B의 크기 B
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))

    astart, bstart = 0, 0

    answer = []

    while astart < N and bstart < M:

        if A[astart] <= B[bstart]:
            answer.append(str(A[astart]))
            astart += 1
        else:
            answer.append(str(B[bstart]))
            bstart += 1

    if astart < N:
        answer.extend(map(str, A[astart:]))
    else:
        answer.extend(map(str, B[bstart:]))

    return " ".join(answer)

print(solution())