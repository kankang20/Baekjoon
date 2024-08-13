
"""
title  : 9342. 염색체 (Silver 3)
time   : 108ms        180ms
memory : 34752KB      112896KB
"""

import sys
import re

def solution():

    input = sys.stdin.readline
    T = int(input())    # 테스트케이스 개수

    # 정규표현식
    check = re.compile('[ABCDEF]?A+F+C+[ABCDEF]?$')

    for _ in range(T):       
        print("Infected!" if check.match(input().rstrip()) else "Good")

solution()