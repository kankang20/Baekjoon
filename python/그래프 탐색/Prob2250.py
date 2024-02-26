
"""  골드 2. 트리의 높이와 너비 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())    # 노드의 개수

    node_level = [0] * (N+1)    # 노드 레벨
    node_width = [0] * (N+1)    # 노드 너비
    
    for _ in range(N):
        parent, c1, c2 = map(int, input().split())
        
        child_level = node_level[parent] + 1

        if c1 > 0:
            node_level[c1] = child_level

        if c2 > 0:
            node_level[c2] = child_level

    print(node_level)

print(solution())