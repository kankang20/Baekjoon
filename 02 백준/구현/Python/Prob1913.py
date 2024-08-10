
"""
title  : 1913. 달팽이 (Silver 3)
time   : 756ms     416ms
memory : 70168KB   128656KB
"""

N = int(input())        # 달팽이의 크기
answer = int(input())   # 찾아야 하는 수


def solution():
    graph = [[0] * N for _ in range(N)]
    
    r, c = N//2, N//2
    flag = True             # True면 위로 오른쪽으로 / False면 아래로 왼쪽으로
    flag_answer = True      # 좌표를 찾은 경우 False / 좌표를 찾지 못한 경우 True

    dr = [-1, 0, 1, 0]             # 위 오른 아래 왼
    dc = [0, 1, 0, -1]

    dir1, dir2, number = 0, 0, 2
    ansr, ansc = 0, 0

    graph[r][c] = 1
    if answer == 1: 
        flag_answer = False
        ansr, ansc = r, c

    for num in range(1, N):
        
        if flag:
            dir1, dir2 = 0, 1
            flag = False
        else:
            dir1, dir2 = 2, 3
            flag = True

        for _ in range(num):
            r += dr[dir1]
            c += dc[dir1]
            graph[r][c] = number
            if flag_answer and number == answer: 
                flag_answer = False
                ansr, ansc = r, c
            number += 1

        for _ in range(num):
            r += dr[dir2]
            c += dc[dir2]
            graph[r][c] = number
            if flag_answer and number == answer: 
                flag_answer = False
                ansr, ansc = r, c
            number += 1

    for _ in range(num):
        r += dr[0]
        c += dc[0]
        graph[r][c] = number
        if flag_answer and number == answer: 
                flag_answer = False
                ansr, ansc = r, c
        number += 1

    for i in range(N):
        for j in range(N):
            print(graph[i][j], end=" ")
        print()

    print(ansr+1, ansc+1)
    
solution()