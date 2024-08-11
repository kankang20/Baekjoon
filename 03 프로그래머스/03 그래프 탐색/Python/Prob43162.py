
"""
title  : 43162. 네트워크 (Level 3)
"""

from collections import deque

def solution(n, computers):
    answer = 0
    visited = [False] * n

    for idx in range(n):
        if not visited[idx]:
            answer += 1
            visited = bfs(n, computers, idx, visited)

    return answer


def bfs(n, computers, node, visited):

    queue = deque()
    
    queue.append(node)
    visited[node] = True

    while queue:

        now = queue.popleft()

        for idx in range(n):
            if not visited[idx] and computers[now][idx]:
                queue.append(idx)
                visited[idx] = True

    return visited


print(solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]]))       # 2
print(solution(3, [[1, 1, 0], [1, 1, 1], [0, 1, 1]]))       # 1