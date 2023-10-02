
""" 예제 10-4) 위상 정렬 """

from collections import deque

V, E = map(int, input().split())        # 노드의 개수 V, 간선의 개수 E

indegree = [0] * (V+1)                  # 각 노드에 대한 진입차수 초기화
graph = [[] for i in range(V+1)]        # 각 노드에 연결된 간선 정보를 담기 위한 그래프

# 방향 그래프의 모든 간선 정보
for _ in range(E):
    a, b = map(int, input().split())
    graph[a].append(b)                  # a에서 b로 이동
    indegree[b] += 1                    # 진입차수 1 증가

def topology_sort():
    result = []
    q = deque()

    # 진입차수가 0인 노드를 큐에 삽입 후 시작
    for i in range(1, V+1):
        if indegree[i] == 0:
            q.append(i)

    while q:
        now = q.popleft()
        result.append(now)

        for i in graph[now]:
            indegree[i] -= 1            # 해당 원소와 연결된 노드들의 진입차수에서 1 빼기
            if indegree[i] == 0:        # 진입 차수가 0이 된 경우 큐에 삽입
                q.append(i)

    for i in result:
        print(i, end=" ")

topology_sort()
