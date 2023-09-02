
""" 실버 2. 트리의 부모 찾기 """

from collections import deque
import sys

### 입력
input = sys.stdin.readline
N = int(input())                        # 노드의 개수
nodes = [[] for _ in range(N+1)]        # 인접 리스트    
for _ in range(N-1):
    i, j = map(int, input().split())
    nodes[i].append(j)
    nodes[j].append(i)


### 함수

def solution():
    parent = [-1] * (N+1)

    queue = deque()

    queue.append(1)
    parent[1] = 1

    while queue:
        now = queue.popleft()

        for nn in nodes[now]:
            if parent[nn] == -1:
                parent[nn] = now
                queue.append(nn)

    return parent[2:]

### 실행
parent = solution()
for p in parent:
    print(p)