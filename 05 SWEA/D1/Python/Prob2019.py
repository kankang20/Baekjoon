
"""
title  : 2019. 더블더블 (D1)
time   : 114ms
memory : 43236kb
"""

def solution():
    
    N = int(input())

    answer = 1
    print(answer, end=" ")
    
    for _ in range(N):
        answer *= 2
        print(answer, end=" ")

solution()