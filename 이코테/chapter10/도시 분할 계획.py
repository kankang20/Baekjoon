
""" 예제 10-6) 도시 분할 계획 """

# 2개의 신장 트리로 분할
# 최소 신장 트리를 찾은 뒤에 최소 신장 트리를 구성하는 간선 중에서 가장 비용이 큰 간선 제거

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

N, M = map(int, input().split())                # 집의 개수 N, 길의 개수 M
parent = [0] + [i for i in range(1, N+1)]       # 부모 테이블

edges = []
result = 0

for _ in range(M):
    a, b, cost = map(int, input().split())
    edges.append((cost, a, b))

edges.sort()

max_cost = 0
for cost, a, b in edges:
    if find(parent, a) != find(parent, b):
        union(parent, a, b)
        result += cost
        max_cost = cost

print(result - max_cost)