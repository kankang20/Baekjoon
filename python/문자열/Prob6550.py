
""" 실버 5. 부분 문자열 """

import sys

def solution():

    input = sys.stdin.readline

    while True:
        try:
            S, T = input().split()
            print("Yes" if S in T else "No")
        except:
            break
        
solution()