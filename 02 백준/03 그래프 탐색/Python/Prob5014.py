
"""
title  : 5014. 스타트링크 (Silver 1)
time   : 476ms      264ms
memory : 39956KB    126832KB
"""

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    F, S, G, U, D = map(int, input().split())   # 강호 S -> G
    return bfs(F, S, G, U, D)

def bfs(F, S, G, U, D):

    stair = [U, -D]

    q = deque()
    q.append(S)

    selected = [False] * (F+1)
    selected[S] = True

    answer = 0
    while q:
        for _ in range(len(q)):

            now = q.popleft()
            if now == G:
                return answer
            
            for s in stair:
                temp = now + s
                if 0 < temp <= F and not selected[temp]:
                    q.append(temp)
                    selected[temp] = True
        answer += 1

    return "use the stairs"

print(solution())