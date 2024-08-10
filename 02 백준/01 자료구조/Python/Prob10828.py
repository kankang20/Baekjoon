
"""
title  : 10828. 스택 (Silver 4)
time   : 48ms      124ms
memory : 31120KB   111760KB
"""

import sys

def solution():

    input = sys.stdin.readline
    N = int(input())                # 명령 수

    stack = []

    for _ in range(N):

        command = input().split()
        
        if command[0] == "push":
            stack.append(command[1])
        elif command[0] == "pop":
            print(stack.pop() if stack else -1)
        elif command[0] == "size":
            print(len(stack))
        elif command[0] == "empty":
            print(0 if stack else 1)
        elif command[0] == "top":
            print(stack[-1] if stack else -1)

solution()