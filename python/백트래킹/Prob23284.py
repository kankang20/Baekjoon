
""" 골드 5. 모든 스택 수열 """

import sys
from itertools import permutations

def solution():
    input = sys.stdin.readline

    N = int(input())

    for ans in list(permutations([(idx+1) for idx in range(N)], N)):
        print(ans)

solution()