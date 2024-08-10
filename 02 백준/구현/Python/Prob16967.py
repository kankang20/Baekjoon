
"""
title  : 16967. 배열 복원하기 (Silver 3)
time   : 116ms     160ms
memory : 38120KB   113272KB
"""

import sys

def solution():
    input = sys.stdin.readline

    R, C, X, Y = map(int, input().split()) 
    B = [list(map(int, input().split())) for _ in range(R+X)]

    A = [[0] * C for _ in range(R)]
    for r in range(R):
        for c in range(C):

            A[r][c] = B[r][c]
            if 0 <= r - X < R and 0 <= c - Y < C:
                A[r][c] -= A[r - X][c - Y]

    for a in A:
        print(" ".join(map(str, a)))
            
solution()