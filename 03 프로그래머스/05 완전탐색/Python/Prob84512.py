
"""
title  : 84512. 모음사전 (Level 2)
"""

from itertools import product

def solution(word):
    answer = []

    alphabet = ['A', 'E', 'I', 'O', 'U']

    for idx in range(1, 6):
        for temp in list(product(alphabet, repeat=idx)):
            answer.append(''.join(temp))

    # answer.sort()
    return sorted(answer).index(word) + 1

print(solution("AAAAE"))        # 6
print(solution("AAAE"))         # 10
print(solution("I"))            # 1563
print(solution("EIO"))          # 1189