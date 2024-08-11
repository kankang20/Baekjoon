
"""
title  : 87694. 아이템 줍기 (Level 3)
"""

from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):

    board = [[-1] * 102 for _ in range(102)]

    for rect in rectangle:
        x1, y1, x2, y2 = map(lambda x: x*2, rect)
        for x in range(x1, x2+1):
            for y in range(y1, y2+1):
                if x1 < x < x2 and y1 < y < y2:
                    board[x][y] = 0
                elif board[x][y] == -1:
                    board[x][y] = 1
                    
    characterX *= 2
    characterY *= 2
    itemX *= 2
    itemY *= 2

    selected = [[False] * 102 for _ in range(102)]
    selected[characterX][characterY] = True

    q = deque()
    q.append((characterX, characterY, 1))

    dir = [(0, -1), (0, 1), (1, 0), (-1, 0)]

    while q:

        x, y, count = q.popleft()
        if itemX == x and itemY == y:
            return count//2

        for d in range(4):
            nx = x + dir[d][0]
            ny = y + dir[d][1]

            if x < 0 or x >= 102 or y < 0 or y >= 102 or selected[nx][ny]:
                continue
            if board[nx][ny] == 1:
                selected[nx][ny] = True
                q.append((nx, ny, count+1))
    
    return -1


print(solution([[1,1,7,4],[3,2,5,5],[4,3,6,9],[2,6,8,8]], 1, 3, 7, 8))      # 17
print(solution([[1,1,8,4],[2,2,4,9],[3,6,9,8],[6,3,7,7]], 9, 7, 6, 1))      # 11
print(solution([[1,1,5,7]], 1, 1, 4, 7))                                    # 9
print(solution([[2,1,7,5],[6,4,10,10]], 3, 1, 7, 10))                       # 15
print(solution([[2,2,5,5],[1,3,6,4],[3,1,4,6]], 1, 4, 6, 3))                # 10
