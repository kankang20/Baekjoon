
""" 골드 5. 무한 수열 """

import sys
import math

N, P, Q = map(int, sys.stdin.readline().split())

def solution():
    
    max_value = max(N//P, N//Q)

    table = [0] * (max_value+1)
    table[0] = 1

    if N == 0:
        return table[0]

    for idx in range(1, max_value+1):
        table[idx] = table[idx//P] + table[idx//Q]

    return table[N//P] + table[N//Q]

print(solution())