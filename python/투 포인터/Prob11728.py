
""" 실버 5. 배열 합치기 """

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())    # 배열 A의 크기 N, 배열 B의 크기 B
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))

    answer = map(str, sorted(A+B))

    return " ".join(answer)

print(solution())