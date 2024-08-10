
"""
title  : 2164. 카드2 (Silver 4)
time   : 192ms      168ms
memory : 54996KB    123048KB
"""

import sys
from collections import deque

def solution():

    input = sys.stdin.readline

    N = int(input())    
    queue = deque([i for i in range(1, N+1)])

    while len(queue) > 1:
        queue.popleft()
        queue.append(queue.popleft())

    return queue[0]

print(solution())