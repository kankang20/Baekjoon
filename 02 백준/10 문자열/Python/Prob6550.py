
"""
title  : 6550. 부분 문자열 (Silver 5)
time   : 52ms        124ms
memory : 31120KB     110460KB
"""

import sys

def solution():

    input = sys.stdin.readline

    while True:
        try:
            
            S, T = input().split()
            
            sidx = 0
            for t in T:
                if sidx < len(S) and S[sidx] == t:
                    sidx += 1
            
            print("Yes" if sidx == len(S) else "No")

        except:
            break
        
solution()