
""" 실버 1. 연산자 끼워넣기 """

import sys
from itertools import permutations

def solution():

    input = sys.stdin.readline
    
    N = int(input())                            # 수의 개수
    numbers = list(map(int, input().split()))   # 수

    operator = []
    for idx, num in enumerate(list(map(int, input().split()))):
        for _ in range(num):
            operator.append(idx)

    max_answer = -1e9
    min_answer = 1e9

    for per in permutations(operator):
        answer = numbers[0]
        for idx in range(1, N):
            answer = calculate(per[idx-1], answer, numbers[idx])

        max_answer = max(answer, max_answer)
        min_answer = min(answer, min_answer)
    
    print(int(max_answer), int(min_answer), sep="\n")

def calculate(operator:int, num1:int, num2:int):
    if operator == 0:
        return num1 + num2
    elif operator == 1:
        return num1 - num2
    elif operator == 2:
        return num1 * num2
    else:
        if num1 < 0 and num2 > 0:
            return - (-num1 // num2)
        return num1 // num2

solution()