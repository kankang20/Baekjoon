
""" 실버 5. 숫자 카드 """

import sys

input = sys.stdin.readline

N = int(input())
cards = list(map(int, input().split()))
M = int(input())
numbers = list(map(int, input().split()))

def solution():
    for n in numbers:
        print(binary(n), end = " ")

def binary(target):
    
    start = 0
    end = len(cards) - 1

    while start <= end:
        mid = (start + end) // 2

        if cards[mid] == target:
            return 1
        elif cards[mid] < target:
            start = mid + 1
        else:
            end = mid - 1

    return 0

cards.sort()
solution()
