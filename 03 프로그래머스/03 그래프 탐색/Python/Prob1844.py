
"""
title  : 1844. 게임 맵 최단거리 (Level 2)
"""

from collections import deque

def solution(maps):
    row = len(maps)
    col = len(maps[0])

    dr = [0, 0, 1, -1]
    dc = [-1, 1, 0, 0]

    visited = [[False] * col for _ in range(row)]

    queue = deque()

    queue.append((0, 0, 1))
    visited[0][0] = True

    while queue:

        r, c, count = queue.popleft()

        if r == row-1 and c == col-1:
            return count

        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]

            if nr < 0 or nc < 0 or nr >= row or nc >= col or visited[nr][nc] or not maps[nr][nc]:
                continue
            
            queue.append((nr, nc, count+1))
            visited[nr][nc] = True

    return -1


print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]))      # 11
print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]))      # -1