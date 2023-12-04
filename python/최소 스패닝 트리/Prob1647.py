
""" 골드 4. 도시 분할 계획 """

import sys

def solution():

    input = sys.stdin.readline

    N, M = map(int, input().split())            # 집(노드)의 개수 N, 길(간선)의 개수 M
    parent = [0] + [i for i in range(1, N+1)]

    edges = []      # 집과 집 사이의 유지비

    for _ in range(M):
        a, b, c = map(int, input().split())
        edges.append((c, a, b))

    

print(solution())