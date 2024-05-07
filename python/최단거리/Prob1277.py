
""" 골드 4. 발전소 설치 """

import sys
import math
from heapq import heappush, heappop

def solution():
    input = sys.stdin.readline

    N, W = map(int, input().split())    # 발전소의 수 N, 남아있는 전선 수 M
    M = float(input())                  # 제한 길이
    
    pos = [0]
    for _ in range(N):
        x, y = map(int, input().split())
        pos.append([x, y])
    
    edge = [[] for _ in range(N+1)]
    for n1 in range(1, N+1):
        for n2 in range(n1+1, N+1):
            dist = calculate(pos[n1][0], pos[n1][1], pos[n2][0], pos[n2][1])
            if dist <= M:
                edge[n1].append((n2, dist))
                edge[n2].append((n1, dist))

    for _ in range(W):
        n1, n2 = map(int, input().split())
        edge[n1].append((n2, 0))
        edge[n2].append((n1, 0))

    return dijkstra(N, edge)

def calculate(x1, y1, x2, y2):
    return math.sqrt(math.pow((x1 - x2), 2) + math.pow((y1 - y2), 2))

def dijkstra(N, edge):

    q = []
    distance = [math.inf] * (N+1)

    heappush(q, (0.0, 1))
    distance[1] = 0.0

    while q:
        dist, node = heappop(q)
        if distance[node] < dist:
            continue

        for (n, d) in edge[node]:
            cost = dist + d
            if cost < distance[n]:
                distance[n] = cost
                heappush(q, (cost, n))

    return int(distance[N] * 1000)


print(solution())