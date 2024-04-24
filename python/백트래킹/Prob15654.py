
""" 실버 3. N과 M (5) """

import sys
from itertools import permutations

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())
    numbers = list(map(int, input().split()))

    for temp in list(permutations(sorted(numbers), M)):
        print(" ".join(map(str, temp)))

solution()