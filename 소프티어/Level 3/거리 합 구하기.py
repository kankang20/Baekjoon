
""" Lv 3. [21년 재직자 대회 본선] 거리 합 구하기 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())

    graph = [[1e9] * (N+1) for _ in range(N+1)]
    for _ in range(N-1):
        x, y, t = map(int, input().split())
        graph[x][y] = graph[y][x] = t

    # for n in range(1, N+1):
    #     graph[n][n] = 0

    for k in range(1, N+1):
        for i in range(1, N+1):
            graph[i][i] = 0
            for j in range(1, N+1):
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

    for ans in graph[1:]:
        print(sum(ans[1:]))
    
solution()