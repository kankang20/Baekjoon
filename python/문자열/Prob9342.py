
""" 실버 3. 염색체 """

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