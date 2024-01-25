
""" Lv 1. A + B """

import sys

def solution():
    input = sys.stdin.readline
    
    for t in range(int(input())):
        A, B = map(int, input().split())
        print(f'Case #{t+1}: {A+B}')
    
solution()