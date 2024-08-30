
"""
title  : 1938. 아주 간단한 계산기 (D1)
time   : ms
memory : kb
"""

def solution():

    a, b = map(int, input().split())
    print(a+b, a-b, a*b, a//b, sep="\n")

solution()