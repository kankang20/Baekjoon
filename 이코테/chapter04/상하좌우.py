
""" 예제 4-1) 상하좌우 """

N = int(input())                  # 공간의 크기
Moves = list(input().split())     # 이동할 계획서

dr = [0, 0, -1, 1]              # 행
dc = [-1, 1, 0, 0]              # 열
dir = ['L', 'R', 'U', 'D']      # 이동

pos = [1, 1]    # 여행가의 위치

for move in Moves:

    i = dir.index(move)   
    
    nr = pos[0] + dr[i]
    nc = pos[1] + dc[i]

    if nr < 1 or nc < 1 or nr > N or nc > N:
        continue

    pos[0], pos[1] = nr, nc

print(pos[0], pos[1])