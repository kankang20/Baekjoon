
""" 실버 4. 수 찾기 """

import sys

def solution():

    input = sys.stdin.readline

    _ = int(input())                           # 정수 개수
    numbers = set(map(int, input().split()))   # 수

    _ = int(input())
    for num in list(map(int, input().split())):
        print(1 if num in numbers else 0)

solution()