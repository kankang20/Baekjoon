
""" 실버 3. N과 M (1) """

import sys
from itertools import permutations

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())
    number = [str(idx+1) for idx in range(N)]
    
    for temp in list(permutations(number, M)):
        print(" ".join(temp))

solution()