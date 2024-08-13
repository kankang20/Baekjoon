
"""
title  : 11723. 집합 (Silver 5)
time   : 2808ms      1092ms
memory : 31120KB     128692KB
"""

import sys

def solution():
    input = sys.stdin.readline

    numbers = [0] * 21

    for _ in range(int(input())):

        command = input().rstrip().split()

        if command[0] == 'add':
            numbers[int(command[1])] = 1
        elif command[0] == 'remove':
            numbers[int(command[1])] = 0
        elif command[0] == 'check':
            print(1 if numbers[int(command[1])] else 0)
        elif command[0] == 'toggle':
            num = int(command[1])
            numbers[num] = abs(numbers[num] - 1)
        elif command[0] == 'all':
            total_numbers(numbers, 1)
        elif command[0] == 'empty':
            total_numbers(numbers, 0)
    
def total_numbers(numbers:list, check:int):
    for idx in range(21):
        numbers[idx] = check
        
solution()