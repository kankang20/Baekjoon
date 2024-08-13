
"""
title  : 1647. 도시 분할 계획 (Gold 4)
time   : 2900ms       3884ms
memory : 197612KB     268916KB
"""

import sys

def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

def solution():

    input = sys.stdin.readline

    N, M = map(int, input().split())            # 집(노드)의 개수 N, 길(간선)의 개수 M
    parent = [0] + [i for i in range(1, N+1)]

    edges = []      # 집과 집 사이의 유지비

    for _ in range(M):
        a, b, c = map(int, input().split())
        edges.append((c, a, b))

    edges.sort()
    
    answer = 0
    count = 0

    for c, a, b in edges:

        if count == N-2:
            break

        if find(parent, a) != find(parent, b):
            union(parent, a, b)
            answer += c
            count += 1
    
    return answer

print(solution())