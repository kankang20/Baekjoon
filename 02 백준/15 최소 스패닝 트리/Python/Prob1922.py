
"""
title  : 1922. 네트워크 연결 (Gold 4)
time   : 276ms       448ms
memory : 45740KB     129124KB
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
    N = int(sys.stdin.readline())    # 컴퓨터의 수
    M = int(sys.stdin.readline())    # 연결할 수 있는 선의 수
    parent = [num for num in range(N+1)]
    edges = []

    for _ in range(M):
        a, b, cost = map(int, sys.stdin.readline().split())
        edges.append((cost, a, b))

    edges.sort()
    answer = 0      # 최소 비용

    for edge in edges:
        cost, a, b = edge
        if find(parent, a) != find(parent, b):
            union(parent, a, b)
            answer += cost

    print(answer)

if __name__ == "__main__":
    solution()

