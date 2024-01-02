
""" 골드 4. 도시 건설 """

import sys

def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)

    if a == b:
        pass
    elif a < b:
        parent[b] = a
    else:
        parent[a] = b

def solution():

    input = sys.stdin.readline

    N, M = map(int, input().split())            # 건물의 개수 N, 도로의 개수 M

    parent = [num for num in range(N+1)]
    edges = []
    for _ in range(M):
        a, b, c = map(int, input().split())     # 두 건물 a, b, 건물 사이 도로를 만들때 드는 비용 c
        edges.append((c, a, b))
    
    edges.sort()

    answer_cost = 0
    answer_count = 0

    for (c, a, b) in edges:
        answer_cost += c
        if find(parent, a) != find(parent, b):
            union(parent, a, b)
            answer_cost -= c
            answer_count += 1

    return answer_cost if answer_count == N-1 else -1

print(solution())