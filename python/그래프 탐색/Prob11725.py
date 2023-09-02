
""" 실버 2. 트리의 부모 찾기 """

import sys
sys.setrecursionlimit(10**6)

### 입력
input = sys.stdin.readline
N = int(input())                        # 노드의 개수
nodes = [[] for _ in range(N+1)]        # 인접 리스트    
for _ in range(N-1):
    i, j = map(int, input().split())
    nodes[i].append(j)
    nodes[j].append(i)

# 각 노드의 부모 테이블
parent = [-1] * (N+1)
parent[1] = 1


### 함수
def solution(start):
    for n in nodes[start]:
        if parent[n] == -1:
            parent[n] = start
            solution(n)


### 실행
solution(1)
for p in parent[2:]:
    print(p)