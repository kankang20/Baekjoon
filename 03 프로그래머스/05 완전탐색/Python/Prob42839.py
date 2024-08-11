
"""
title  : 42839. 소수 찾기 (Level 2)
"""

from itertools import permutations
import math

def solution(numbers):

    answer = set()

    for count in range(1, len(numbers)+1):
        for num in list(permutations(numbers, count)):
    
            num = int("".join(num))
            if num not in answer and is_prime(num):
                answer.add(num)

    return len(answer)

def is_prime(number):

    if number < 2:
        return False
    
    for check in range(2, int(math.sqrt(number))+1):
        if number % check == 0:
            return False
        
    return True

print(solution("17"))       # 3
print(solution("011"))      # 2