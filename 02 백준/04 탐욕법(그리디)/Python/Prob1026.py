
"""
title  : 1026. 보물 (Silver 4)
time   : 40ms       108ms
memory : 31252KB    108080KB
"""

import sys

def solution():

    input = sys.stdin.readline

    N = int(input())
    A = sorted(list(map(int, input().split())), reverse=True)
    B = sorted(list(map(int, input().split())))

    return sum([A[idx]*B[idx] for idx in range(N)])

print(solution())