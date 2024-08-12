
"""
title  : 3584. 가장 가까운 공통 조상 (Gold 4)
time   : 64ms       140ms
memory : 31256KB    115200KB
"""

import sys

input = sys.stdin.readline
T = int(input())        # 테스트케이스 개수

def solution():

    N = int(input())        # 트리를 구성하는 노드의 수

    trees = [-1] * (N+1)        # 각 노드의 부모
    visited = [True] + [False] * (N)   # 노드의 방문 여부

    for _ in range(N-1):
        a, b = map(int, input().split())
        trees[b] = a

    node1, node2 = map(int, input().split())

    visited[node1] = True
    while trees[node1] != -1:
        node1 = trees[node1]
        visited[node1] = True
    
    while not visited[node2]:
        visited[node2] = True
        node2 = trees[node2]

    return node2

for _ in range(T):
    print(solution())