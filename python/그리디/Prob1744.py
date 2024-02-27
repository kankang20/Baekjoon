
""" 골드 4. 수 묶기 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())

    low_numbers, high_numbers = [], []
    for _ in range(N):
        number = int(input())

        if number > 0:
            high_numbers.append(number)
        else:
            low_numbers.append(number)

    answer = 0
    
    low_numbers.sort()
    length = len(low_numbers)
    
    idx = 0
    while idx < length-1:
        answer += (low_numbers[idx] * low_numbers[idx+1])
        idx += 2

    if idx < length:
        answer += low_numbers[idx]

    high_numbers.sort(reverse=True)
    length = len(high_numbers)

    idx = 0
    while idx < length-1:
        num1 = high_numbers[idx]
        num2 = high_numbers[idx+1]

        answer += ((num1 * num2) if num1 > 1 and num2 > 1 else (num1 + num2))
        idx += 2
    
    if idx < length:
        answer += high_numbers[idx]

    return answer

print(solution())