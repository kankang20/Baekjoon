
"""
title  : 18258. 큐 2 (Silver 4)
time   : 1252ms      936ms
memory : 175120KB    253912KB
"""

import sys
from collections import deque

def solution():

    input = sys.stdin.readline
    N = int(input())                # 명령 수

    queue = deque()

    for _ in range(N):

        command = input().split()

        if command[0] == "push":
            queue.append(command[1])
        elif command[0] == "pop":
            print(queue.popleft() if queue else -1)
        elif command[0] == "size":
            print(len(queue))
        elif command[0] == "empty":
            print(0 if queue else 1)
        elif command[0] == "front":
            print(queue[0] if queue else -1)
        elif command[0] == "back":
            print(queue[-1] if queue else -1)
            
solution()