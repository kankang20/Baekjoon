
""" 골드 4. 행성 연결 """

import sys

def find(parent, a):
    if parent[a] != a:
        parent[a] = find(parent, parent[a])
    return parent[a]

def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)
    
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

def solution():

    input = sys.stdin.readline
    N = int(input())                # 행성의 수
    parent = [i for i in range(N)]

    edges = []
    for i in range(N):
        for (j, cost) in enumerate(list(map(int, input().split()))):
            if cost > 0:
                edges.append((cost, i, j))

    edges.sort()

    answer = 0
    count = 0

    for cost, i, j in edges:
        if find(parent, i) != find(parent, j):
            union(parent, i, j)
            answer += cost
            count += 1

        if count == N-1:
            break

    return answer

print(solution())