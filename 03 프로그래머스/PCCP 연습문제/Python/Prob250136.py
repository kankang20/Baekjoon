
"""
title  : 250136. 석유 시추 (Level 2)
"""

from collections import deque

dr = [0, 0, -1, 1]
dc = [1, -1, 0, 0]

def solution(land):
    
    R = len(land)
    C = len(land[0])
        
    selected = [[False] * C for _ in range(R)]
    
    answer = [0] * C
    for r in range(R):
        for c in range(C):
            if not selected[r][c] and land[r][c]:
                count, column = bfs(land, selected, R, C, r, c)
                for col in column:
                    answer[col] += count

    return max(answer)

def bfs(land, selected, R, C, r, c):
    
    q = deque()
    q.append((r, c))
    selected[r][c] = True
    
    count = 1
    column = set()
    column.add(c)
    while q:
        
        r, c = q.popleft()
        
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            
            if nr < 0 or nr >= R or nc < 0 or nc >= C:
                continue
            
            if selected[nr][nc] or not land[nr][nc]:
                continue
                
            q.append((nr, nc))
            selected[nr][nc] = True
                
            count += 1
            column.add(nc)
            
    return count, column

# print(solution([[0, 0, 0, 1, 1, 1, 0, 0], [0, 0, 0, 0, 1, 1, 0, 0], [1, 1, 0, 0, 0, 1, 1, 0], [1, 1, 1, 0, 0, 0, 0, 0], [1, 1, 1, 0, 0, 0, 1, 1]]))             # 9
print(solution([[1, 0, 1, 0, 1, 1], [1, 0, 1, 0, 0, 0], [1, 0, 1, 0, 0, 1], [1, 0, 0, 1, 0, 0], [1, 0, 0, 1, 0, 1], [1, 0, 0, 0, 0, 0], [1, 1, 1, 1, 1, 1]]))   # 16