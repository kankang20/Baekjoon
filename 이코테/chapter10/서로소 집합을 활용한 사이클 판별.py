
""" 예제 10-2) 서로소 집합을 활용한 사이클 판별 """

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

cycle = False

for i in range(E):
    a, b = map(int, input().split())

    if find(parent, a) == find(parent, b):      # 사이클이 발생한 경우 종료
        cycle = True
        break
    else:                                       # 사이클이 발생하지 않았따면 합집합
        union(parent, a, b)

if cycle:
    print("사이클이 발생하였습니다.")
else:
    print("사이클이 발생하지 않았습니다.")