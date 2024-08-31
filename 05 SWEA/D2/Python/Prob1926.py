
"""
title  : 1926. 간단한 369게임 (D2)
time   : 133ms
memory : 44792kb
"""

def solution():

    N = int(input())

    for num in range(1, N+1):
        print(count3(str(num)), end=" ")

def count3(num:str):

    count = 0
    for n in num:
        nnum = int(n)
        if (nnum > 0 and nnum % 3 == 0):
            count += 1

    return "-" * count if count else num

solution()