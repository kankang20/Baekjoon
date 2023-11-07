
""" 골드 5. 공주님을 구해라! """

import sys
from collections import deque

def solution():

    input = sys.stdin.readline
    R, C, T = map(int, input().split())                             # 성의 크기 N, M, 제한 시간 T
    graph = [list(map(int, input().split())) for _ in range(R)]     # 성

    answer = search(R, C, T, graph) 
    return answer if answer <= T else "Fail"

def search(R, C, T, graph):

    dir = [[0, 1], [0, -1], [1, 0], [-1, 0]]

    q = deque()
    
    q.append((0, 0, 0))      # 현재 위치, 시간, 그람 소지 여부
    graph[0][0] = -1

    gram_distance = T+1

    while q:

        r, c, time = q.popleft()
        
        if r == R-1 and c == C-1:
            return min(time, gram_distance)
        
        for d in range(4):
            
            nr = r + dir[d][0]
            nc = c + dir[d][1]

            if nr < 0 or nc < 0 or nr >= R or nc >= C or graph[nr][nc] == 1 or graph[nr][nc] == -1:
                continue

            if graph[nr][nc] == 2:
                gram_distance = time + 1 + ((R-1) - nr) + ((C-1) - nc)
            
            q.append((nr, nc, time+1))
            graph[nr][nc] = -1
                
    return gram_distance

print(solution())