
"""
title  : 2025. N줄덧셈 (D1)
time   : 114ms
memory : 43760kb
"""

def solution():

    N = int(input())

    if (N % 2):
        print(N * (N//2) + N)
    else:
        print((1 + N) * (N // 2))

solution()