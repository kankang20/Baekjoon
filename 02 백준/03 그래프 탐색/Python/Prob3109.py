
"""
title  : 3109. 빵집 (Gold 2)
time   : 
memory : 
"""

import sys

answer = 0

dir = [[0, 1], [-1, 1], [1, 1]]

def solution():
    
    input = sys.stdin.readline
    R, C = map(int, input().split())
    graph = [list(input()) for _ in range(R)]

    search(R, C, graph, 0, 0, 0, 0)

    return answer

def search(R, C, graph, start_row, row, col, count):

    if start_row == R-1 and col == C-1:
        print(answer, count)
        answer = max(count, answer)
        return
    
    print(start_row, row, col)

    for (r, c) in dir:
        nr = row + r
        nc = col + c

        if 0 <= nr < R and 0 <= nc < C and graph[nr][nc] == '.':

            if nc == C-1:
                graph[nr][nc] = 'O'
                search(R, C, graph, start_row+1, start_row+1, 0, count+1)
                graph[nr][nc] = '.'
            else:
                graph[nr][nc] = 'O'
                search(R, C, graph, start_row, nr, nc, count)
                graph[nr][nc] = '.'

print(solution())

