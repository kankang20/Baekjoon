
"""
title  : 1197. 최소 스패닝 트리 (Gold 4)
time   : 268ms       524ms
memory : 47788KB     129280KB
"""

import sys

V, E = map(int, sys.stdin.readline().split())           # 정점의 개수, 간선의 개수
parent = [num for num in range(V+1)]                    # 부모 테이블

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

def solution():
    edges = []

    for _ in range(E):
        a, b, cost = map(int, sys.stdin.readline().split())
        edges.append((cost, a, b))

    edges.sort()
    answer = 0

    for edge in edges:
        cost, a, b = edge
        if find(a) != find(b):
            union(a, b)
            answer += cost

    print(answer)

if __name__ == '__main__':
    solution()