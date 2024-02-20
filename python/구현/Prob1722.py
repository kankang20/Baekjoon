
""" 골드 5. 순열의 순서 """

import sys
from itertools import permutations

def solution():
    input = sys.stdin.readline

    N = int(input())    
    question = list(map(int, input().split()))

    numbers = list(permutations([num for num in range(1, N+1)]))
    if question[0] == 1:    # k 번째 수열 출력
        print(" ".join(list(map(str, numbers[question[1]-1]))))
    elif question[0] == 2:  # 입력받은 순열의 순서
        answer = tuple(question[1:])
        for idx in range(len(numbers)):
            if numbers[idx] == answer:
                print(idx+1)
                break

solution()