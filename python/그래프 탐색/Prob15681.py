
""" 골드 5. 트리와 쿼리 """

import sys
sys.setrecursionlimit(10**6)

def solution():
    input = sys.stdin.readline

    N, R, Q = map(int, input().split())     # 정점의 수 N, 루트 번호 R, 쿼리 수 Q
    
    tree = [[] for _ in range(N+1)]
    for _ in range(N-1):
        U, V = map(int, input().split())
        tree[U].append(V)
        tree[V].append(U)

    child = [[] for _ in range(N+1)]
    # parent = [-1] * (N+1)
    size = [1] * (N+1)

    # 트리 만들기 (currentNode : 현재 탐색 중인 정점 / parent: 해당 정점의 부모 정점)
    def makeTree(currentNode:int, parentNode:int):
        for node in tree[currentNode]:
            if node != parentNode:
                child[currentNode].append(node)
                # parent[node] = currentNode
                makeTree(node, currentNode)

    # 서브트리에 속한 정점의 개수 구하기
    def countSubtreeNodes(currentNode:int):
        for node in child[currentNode]:
            countSubtreeNodes(node)
            size[currentNode] += size[node]

    makeTree(R, -1)
    countSubtreeNodes(R)

    for _ in range(Q):
        print(size[int(input())])

solution()