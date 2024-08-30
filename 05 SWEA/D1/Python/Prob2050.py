
"""
title  : 2050. 알파벳을 숫자로 변환 (D1)
time   : 113ms
memory : 44288kb
"""

def solution():

    str = input().rstrip()
    for s in str:
        print(ord(s) - 64, end=" ")

solution()