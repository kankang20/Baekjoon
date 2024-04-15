
""" 골드 3. 최소비용 구하기 2 """

import sys
from heapq import heappush, heappop

def solution():
    input = sys.stdin.readline

    N = int(input())    # 도시의 개수
    M = int(input())    # 버스의 개수

    edges = [[] for _ in range(N+1)]

    for _ in range(M):
        start, end, cost = map(int, input().split())
        edges[start].append((end, cost))

    start_edge, end_edge = map(int, input().split())    # 구하고자 하는 출발점, 도착점
    
    distance = [1e9] * (N+1)
    previous_edge = [num for num in range(N+1)]

    def dijkstra():

        q = []
        distance[start_edge] = 0
        heappush(q, (0, start_edge))

        while q:
            cost, edge = heappop(q)
            if distance[edge] < cost:
                continue

            for (ne, nc) in edges[edge]:
                total_cost = cost + nc
                if distance[ne] > total_cost:
                    heappush(q, (total_cost, ne))
                    distance[ne] = total_cost
                    previous_edge[ne] = edge

    dijkstra()

    answer = [end_edge]
    idx = end_edge
    while idx != start_edge:
        idx = previous_edge[idx]
        answer.append(idx)

    print(distance[end_edge])
    print(len(answer))
    print(" ".join(list(map(str, answer[::-1]))))

solution()