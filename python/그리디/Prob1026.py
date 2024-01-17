
""" 실버 4. 보물 """

import sys

def solution():

    input = sys.stdin.readline

    N = int(input())

    A = sorted(list(map(int, input().split())), reverse=True)
    B = sorted(list(map(int, input().split())))

    return sum([A[idx]*B[idx] for idx in range(N)])

print(solution())