
""" 예제 9-4) 미래 도시 """

INF = int(1e9)

N, M = map(int, input().split())        # 회사 개수 N, 경로 개수 M
graph = [[INF] * (N+1) for _ in range(N+1)]

for i in range(1, N+1):
    graph[i][i] = 0

for _ in range(M):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a] = 1

X, K = map(int, input().split())        # 1번 회사 출발 - K번 회사 방문 - X번 회사 도착

for k in range(1, N+1):
    for a in range(1, N+1):
        for b in range(1, N+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

answer = graph[1][K] + graph[K][X]
print(-1 if answer >= INF else answer)

for i in graph:
    print(i)
