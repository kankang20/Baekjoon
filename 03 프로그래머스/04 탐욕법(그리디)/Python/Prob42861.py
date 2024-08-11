
"""
title  : 42861. 섬 연결하기 (Level 3)
"""

from heapq import heappush, heappop

def find(x, parent):
    if parent[x] != x:
        parent[x] = find(parent[x], parent)
    return parent[x]

def union(x, y, parent):
    x = find(x, parent)
    y = find(y, parent)

    if x == y:
        return False
    elif x < y:
        parent[y] = x
    else:
        parent[x] = y

    return True

def solution(n, costs):

    board = []
    for a, b, c in costs:
        heappush(board, (c, a, b))

    parent = [num for num in range(n)]
    
    answer = 0
    idx = 0
    while idx < n-1:
        cost, a, b = heappop(board)
        if union(a, b, parent):
            answer += cost
            idx += 1
        
    return answer

print(solution(4, [[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]))                       # 4
print(solution(5, [[0,1,5],[1,2,3],[2,3,3],[3,1,2],[3,0,4],[2,4,6],[4,0,7]]))       # 15