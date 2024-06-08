
""" 실버 5. 수 정렬하기 2 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())
    number = [int(input()) for _ in range(N)]

    for num in sorted(number):
        print(num)

solution()