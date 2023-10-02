
""" 예제 10-3) 크루스칼 """

# 특졍 원소가 속한 집합 찾기
def find(parent, x):
    if parent[x] != x:          # 루트노드가 아니라면
        parent[x] = find(parent, parent[x])
    return parent[x]


# 두 원소가 속한 집합 합치기
def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)

    if a < b: 
        parent[b] = a
    else:
        parent[a] = b


V, E = map(int, input().split())                # 노드의 개수 V, 간선의 개수 E
parent = [0] + [i for i in range(1, V+1)]       # 부모 테이블 자기 자신으로 초기화

edges = []      # 모든 간선
result = 0      # 최종 비용

for _ in range(E):
    a, b, cost = map(int, input().split())
    edges.append((cost, a, b))                  # 비용 순대로 정렬하기 위해 첫 번째 원소를 cost로 설정

# 간선을 비용 순으로 정렬
edges.sort()

for cost, a, b in edges:
    # 사이클이 발생하지 않는 경우에만 집합 포함
    if find(parent, a) != find(parent, b):
        union(parent, a, b)
        result += cost

print(result)