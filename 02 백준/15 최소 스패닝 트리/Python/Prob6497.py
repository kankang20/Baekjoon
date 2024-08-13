
"""
title  : 6497. 전력난 (Gold 4)
time   : 1548ms      2000ms
memory : 59080KB     218800KB
"""

import sys

def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, x, y):
    x = find(parent, x)
    y = find(parent, y)

    if x == y:
        pass
    elif x < y:
        parent[y] = x
    else:
        parent[x] = y

def calculate_edge(parent:list, edges:list, count:int, max_edge_count:int):

    edges.sort()
    edge_count = 0

    for edge in edges:
        cost, x, y = edge
        if find(parent, x) != find(parent, y):
            union(parent, x, y)
            count -= cost
            edge_count += 1

        if edge_count == max_edge_count:
            return count

def solution():
    input = sys.stdin.readline

    while True:

        M, N = map(int, input().split())    # 집의 수 M, 길의 수 N

        if M == 0 and N == 0:
            break
    
        parent = [num for num in range(M)]
        edges = []

        count = 0
        for _ in range(N):
            x, y, z = map(int, input().split())     # x번과 y번 집 사이의 거리가 Z
            edges.append((z, x, y))
            count += z

        print(calculate_edge(parent, edges, count, M-1))

solution()