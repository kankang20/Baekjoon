
"""
title  : 2063. 중간값 찾기 (D1)
time   : 119ms
memory : 44508kb
"""

def solution():

    N = int(input())
    number = sorted(list(map(int, input().split())))

    print(number[N//2])

solution()  