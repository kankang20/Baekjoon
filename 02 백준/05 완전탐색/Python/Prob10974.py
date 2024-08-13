
"""
title  : 10974. 모든 순열 (Silver 3)
time   : 64ms       152ms
memory : 31256KB    115392KB
"""

import itertools

def solution():
    num = int(input())
    numbers = [str(i) for i in range(1, num+1)]

    npr = itertools.permutations(numbers, num)

    for n in npr:
        print(" ".join(n))


if __name__ == '__main__':
    solution()