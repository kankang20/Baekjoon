
""" 실버 4. 차집합 """

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())
    A = set(list(map(int, input().split())))
    B = set(list(map(int, input().split())))

    answer = list(A - B)

    print(len(answer))
    for ans in sorted(answer):
        print(ans, end = " ")

solution()