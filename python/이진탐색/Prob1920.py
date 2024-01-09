
""" 실버 4. 수 찾기 """

import sys

def solution():

    input = sys.stdin.readline

    N = int(input())                            # 정수 개수
    numbers = "".join(list(input().split()))   # 수

    M = int(input())
    for num in list(input().split()):
        print(0 if numbers.find(num) < 0 else 1)

solution()