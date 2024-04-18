
""" 골드 5. 1, 2, 3, 더하기 4 """

import sys

def solution():
    input = sys.stdin.readline

    T = int(input())                            # 테스트케이스 개수
    numbers = [int(input()) for _ in range(T)]  

    max_number = max(numbers)
    table = [0] * (4 if max_number < 4 else (max_number+1))

solution()