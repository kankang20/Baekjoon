
""" 실버 2. 트리의 부모 찾기 """

from collections import deque
import sys

### 입력
input = sys.stdin.readline

N = int(input())    # 노드의 개수
# 인접 리스트
nodes = [[] for _ in range(N+1)]
for _ in range(N-1):
    i, j = map(int, input().split())
    nodes[i].append(j)
    nodes[j].append(i)


### 함수
def solution():

    for idx in range(2, N+1):

        if len(nodes[idx]) == 1:
            print(nodes[idx][0])
            continue

        for nn in nodes[idx]:
            if bfs(nn):
                print(nn)
                break
        

def bfs(start):

    visited = [False] * (N+1)

    queue = deque()
    
    queue.append(start)
    visited[start] = True

    while queue:

        node = queue.popleft()

        if node == 1:
            return True

        for nn in nodes[node]:
            if not visited[nn]:
                queue.append(nn)
                visited[nn] = True

    return False


### 실행
solution()