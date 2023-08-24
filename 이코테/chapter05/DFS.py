
""" 예제 5-4) DFS """

graph = []
visited = []

def dfs(graph, n, visited):
    
    visited[n] = True   # 해당 노드 방문 처리
    print(n, end=' ')

    # 해당 노드의 방문하지 않은 인접 노드 탐색
    for i in graph[n]:
        if not visited[i]:
            dfs(graph, i, visited)

    return 0



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

# 각 노드의 방문 여부
visited = [False] * 7

dfs(graph, 1, visited)