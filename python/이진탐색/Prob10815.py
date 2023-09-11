
""" 실버 5. 숫자 카드 """

import sys

input = sys.stdin.readline

N = int(input())
cards = set(map(int, input().split()))
M = int(input())
numbers = list(map(int, input().split()))

def solution(target):
    if target in cards:
        return 1
    else:
        return 0
    
for n in numbers:
    print(solution(n), end= " ")
