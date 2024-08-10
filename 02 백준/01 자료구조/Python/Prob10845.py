
"""
title  : 10845. 큐 (Silver 4)
time   : 72ms       180ms
memory : 34028KB    115244KB
"""

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    q = deque()

    for _ in range(int(input())):
        command = list(input().rstrip().split())
        cm = command[0]

        if cm == 'push':
            q.append(int(command[1]))
        elif cm == 'pop':
            print(q.popleft() if q else -1)
        elif cm == 'size':
            print(len(q))
        elif cm == 'empty':
            print(0 if q else 1)
        elif cm == 'front':
            print(q[0] if q else -1)
        elif cm == 'back':
            print(q[-1] if q else -1)

solution()