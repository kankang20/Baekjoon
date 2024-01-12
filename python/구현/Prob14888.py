
""" 실버 1. 연산자 끼워넣기 """

import sys
from itertools import permutations

max_answer = -1e9
min_answer = 1e9

numbers = []
operator = []

def solution():

    input = sys.stdin.readline
    
    N = int(input())                                # 수의 개수

    global numbers
    numbers = list(map(int, input().split()))       # 수
    
    global operator
    operator = list(map(int, input().split()))      # 지옥의 연산자 (연산자는 왜 연산자일까)

    calculate(N, 1, numbers[0], 0, 0, 0, 0)

    print(int(max_answer), int(min_answer), sep="\n")

def calculate(N, idx, answer, plus, minus, multi, divis):

    if idx == N:
        global max_answer
        max_answer = max(max_answer, answer)
        global min_answer
        min_answer = min(min_answer, answer)
        return

    if plus < operator[0]:
        calculate(N, idx+1, answer + numbers[idx], plus+1, minus, multi, divis)
    if minus < operator[1]:
        calculate(N, idx+1, answer - numbers[idx], plus, minus+1, multi, divis)
    if multi < operator[2]:
        calculate(N, idx+1, answer * numbers[idx], plus, minus, multi+1, divis)
    if divis < operator[3]:
        answer = -(-answer // numbers[idx]) if answer < 0 else (answer // numbers[idx])
        calculate(N, idx+1, answer, plus, minus, multi, divis+1)

solution()