
""" 예제 10-1) 서로소 집합 """

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

# unoin 연산 수행
for _ in range(E):
    a, b = map(int, input().split())
    union(parent, a, b)

print("각 원소가 속한 집합 : ", end = "")
for i in range(1, V+1):
    print(find(parent, i), end=" ")

print()

print("부모 테이블 : ", end="")
for i in range(1, V+1):
    print(parent[i], end=" ")