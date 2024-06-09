
""" 실버 2. 결혼식 """

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    N = int(input())
    M = int(input())

    edge = [[] for _ in range(N+1)]
    for _ in range(M):
        a, b = map(int, input().split())
        edge[a].append(b)
        edge[b].append(a)

    def bfs():

        check = [False] * (N+1)
        check[1] = True

        q = deque()
        q.append(1)

        answer = 0
        for _ in range(2):
            for _ in range(len(q)):
                node = q.popleft()

                for nn in edge[node]:
                    if not check[nn]:
                        q.append(nn)
                        check[nn] = True
            
            answer += len(q)

        return answer
    
    return bfs()

print(solution())

