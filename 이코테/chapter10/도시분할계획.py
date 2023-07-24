
""" 예제 10-2) 도시 분할 계획 (크루스칼 Kruskal 알고리즘)"""

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

V, E = map(int, input().split())        # 팀 개수, 연산 개수
parent = [num for num in range(V+1)]    # 부모 테이블 초기화

edges = []      # 간선 비용

for _ in range(E):
    a, b, cost = map(int, input().split())
    edges.append((cost, a, b))

edges.sort()

allCost = 0         # 최종 비용
maxCost = 0         # 포함되는 간선 중 제일 큰 비용

for edge in edges:
    cost, a, b = edge

    if find(parent, a) != find(parent, b):
        union(parent, a, b)
        allCost += cost
        maxCost = cost

# 하나의 신장 트리에서 간선 하나를 제거하면 2개의 신장 트리가 된다 -> 제일 비용이 큰 간선 하나를 제거하자!
print(allCost - maxCost)    




