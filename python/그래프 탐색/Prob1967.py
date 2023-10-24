
""" 골드 4. 트리의 지름 """

import sys

input = sys.stdin.readline

def solution():

    N = int(input())    # 노드의 개수

    graph = [[] for _ in range(N)]
    for _ in range(N-1):
        a, b, c = map(int, input().split())     # 부모 노드 a, 자식 노드 b, 가중치 c
        graph[a].append((b, c))

    

def search(graph, start):



    return 0

print(solution())