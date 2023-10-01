
""" 예제 9-3) 플로이드 워셜 """

INF = int(1e9)      # 무한

N = int(input())    # 노드의 개수
M = int(input())    # 간선의 개수

graph = [[INF] * (N+1) for _ in range(N+1)]

# 대각선 0 
for i in range(1, N+1):
    for j in range(1, N+1):
        if i == j: 
            graph[i][j] = 0

for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a][b] = c

for k in range(1, N+1):
    for a in range(1, N+1):
        for b in range(1, N+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

for i in range(1, N+1):
    for j in range(1, N+1):
        print(graph[i][j], end = " ")
    print()