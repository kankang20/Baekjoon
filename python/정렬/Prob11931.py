
""" 실버 5. 수 정렬하기 4 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())
    numbers = [int(input()) for _ in range(N)]

    for num in sorted(numbers, reverse=True):
        print(num)

solution()