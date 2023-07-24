
""" 예제 10-1) 팀 결성 (서로소 집합)"""

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

N, M = map(int, input().split())        # 팀 개수, 연산 개수
parent = [num for num in range(N+1)]    # 부모 테이블 초기화

for i in range(M):
    check, a, b = map(int, input().split()) 

    if check == 0:
        union(parent, a, b)
    else:   # 같은 팀 여부 확인
        if find(parent, a) == find(parent, b):      # 같은 팀
            print("YES")    
        else:                                       # 다른 팀
            print("NO")
        
