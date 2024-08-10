
""" 예제 10-5) 팀 결성 """

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

N, M = map(int, input().split())                # 팀 개수 N, 연산 개수 M
parent = [0] + [i for i in range(1, N+1)]       # 부모 테이블

for _ in range(M):
    command, a, b = map(int, input().split())

    if command == 0:
        union(parent, a, b)
    else:
        if find(parent, a) == find(parent, b):
            print("YES")
        else:
            print("NO")