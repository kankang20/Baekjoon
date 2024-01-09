
""" 실버 4. 수 찾기 """

import sys

def solution():

    input = sys.stdin.readline

    _ = int(input())                                    # 정수 개수
    numbers = sorted(list(map(int, input().split())))   # 수

    _ = int(input())
    for num in list(map(int, input().split())):
        print(1 if search(numbers, num) else 0)

def search(numbers, target):

    start, end = 0, len(numbers)-1

    while start <= end:

        mid = (start + end) // 2
        temp = numbers[mid]

        if temp == target:
            return True
        elif temp < target:
            start = mid + 1
        else:
            end = mid - 1

    return False

solution()