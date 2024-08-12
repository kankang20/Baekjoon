
"""
title  : 2644. 촌수계산 (Silver 2)
time   : 60ms       140ms
memory : 34072KB    112004KB
"""

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    N = int(input())    # 전체 사람 수
    start, end = map(int, input().split())      # 촌수를 계산해야 하는 두 사람

    graph = [0] + [[] for _ in range(N+1)]

    M = int(input())    # 관계 개수
    for _ in range(M):
        parent, child = map(int, input().split())   # 부모, 자식
        graph[parent].append(child)
        graph[child].append(parent)
    
    return bfs(N, graph, start, end)

def bfs(N:int, graph:list, start:int, end:int):

    q = deque()
    q.append(start)

    selected = [False] * (N+1)
    selected[start] = True
    
    answer = 0
    while q:

        answer += 1
        for _ in range(len(q)):
            for c in graph[q.popleft()]:

                if c == end:
                    return answer
                
                if not selected[c]:
                    q.append(c)
                    selected[c] = True
    return -1

print(solution())