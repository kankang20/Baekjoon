
"""
title  : 11657. 타임머신 (Gold 4)
time   : ms       ms
memory : KB     KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())

    edges = []
    for _ in range(M):
        A, B, C = map(int, input().split())
        edges.append((A, B, C))

    distance = [1e9] * (N+1)

def bfs(N, M, edges, node):

    distance = [1e9] * (N+1)
    distance[node] = 0

    for n in range(N):
        for m in range(M):
            cn = edges[m][0]
            nn = edges[m][1]
            cost = edges[m][2]

            

