
""" 골드 2. 친구 네트워크 """

import sys

def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, size, x, y):
    x = find(parent, x)
    y = find(parent, y)

    if x != y:
        parent[y] = x
        size[x] += size[y]
    return size[x]

def solution():
    input = sys.stdin.readline

    T = int(input())
    for _ in range(T):

        parent = dict()
        size = dict()
        
        F = int(input())    # 친구 관계 수
        for _ in range(F):
            x, y = input().rstrip().split()

            if x not in parent:
                parent[x] = x
                size[x] = 1
            
            if y not in parent:
                parent[y] = y
                size[y] = 1

            print(union(parent, size, x, y))

solution()