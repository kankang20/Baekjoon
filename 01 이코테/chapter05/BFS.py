
""" 예제 5-5) BFS """

from collections import deque

def bfs(graph, start):

    # 각 노드의 방문 여부
    visited = [False] * len(graph)
    
    queue = deque([start])
    visited[start] = True

    while queue:

        n = queue.popleft()
        print(n, end=" ")

        for i in graph[n]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True



# 노드 1부터 시작하기 떄문에 0은 제외
graph = [
    [],
    [2, 3, 6],
    [4, 5],
    [1, 6],
    [2],
    [2],
    [1, 3]
]

bfs(graph, 1)

