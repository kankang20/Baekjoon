
"""
title  : 5073. 삼각형과 세 변 (Bronze 3)
time   : 40ms      112ms
memory : 31120KB   108080KB
"""

import sys

def solution():
    input = sys.stdin.readline

    while True:
        numbers = sorted(list(map(int, input().split())))

        if numbers[2] == 0:
            break
            
        if numbers[0] + numbers[1] <= numbers[2]:
            print("Invalid")
            continue
        
        numbers = set(numbers)
        length = len(numbers)

        if length == 1:
            print("Equilateral")
        elif length == 2:
            print("Isosceles")
        else:
            print("Scalene ")

solution()