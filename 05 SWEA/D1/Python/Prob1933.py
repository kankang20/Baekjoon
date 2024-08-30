
"""
title  : 1933. 간단한 N의 약수 (D1)
time   : 106ms
memory : 44780kb
"""

def solution():

    N = int(input())
    for idx in range(1, N//2+1):
        if (N % idx == 0):
            print(idx, end=" ")
    
    print(N)

solution()