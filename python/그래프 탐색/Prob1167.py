
""" 골드 2. 트리의 지름 """

import sys
from collections import deque

def solution():

    input = sys.stdin.readline

    V = int(input())    # 트리의 정점 개수

    graph = [[] * (V+1) for _ in range(V+1)]
    
    for _ in range(V):
        temp = list(map(int, input().split()))
        for idx in range(1, len(temp)-1, 2):
            graph[temp[0]].append((temp[idx], temp[idx+1]))
    
    answer = 0

    for idx in range(1, V+1):
        answer = max(answer, search(graph, V, idx))

    return answer

def search(graph, V, start):
    
    visited = [False] * (V+1)
    distance = [0] * (V+1)

    q = deque()

    q.append(start)
    visited[start] = True
    distance[start] = 0
    
    while q:

        node, dis = q.popleft()

        

    return max(distance)


print(solution())