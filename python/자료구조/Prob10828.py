
""" 실버 4. 스택 """

import sys

def solution():

    input = sys.stdin.readline
    N = int(input())                # 명령 수

    for _ in range(N):

        command = input().split()
        print(command)

solution()