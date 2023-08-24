
""" 예제 4-4) 게임 개발 """

N, M = map(int, input().split())                                # 맵 크기 (행, 열)
r, c, dir = map(int, input().split())                           # 캐릭터의 현재 위치, 방향
map = [list(map(int, input().split())) for _ in range(N)]       # 바다(1) 육지(0)가 있는 맵

visited = [[0] * M for _ in range(N)]       # 방문여부
map[r][c] = 1                               # 현재 위치 방문 표시

# 북 서 남 동
dr = [-1, 0, 1, 0]
dc = [0, -1, 0, 1]

def turnLeft(direction):    # 왼쪽으로 회전
    direction += 1
    if direction == 4:
        direction = 0
    return direction

answer = 1      # 캐릭터가 방문한 칸의 수
turn = 0

while True:

    # 1. 왼쪽으로 회전
    dir = turnLeft(dir) 

    nr = r + dr[dir]
    nc = c + dc[dir]

    # 2-1. 아직 가보지 않은 칸이 존재 -> 전진
    if visited[nr][nc] == 0 and map[nr][nc] == 0:
        visited[nr][nc] = 1
        r, c = nr, nc
        answer += 1
        turn = 0
        continue
    # 2-2. 가보지 않은 칸의 개수 += 1
    else:
        turn += 1
    
    # 3-1. 네 방향 모두 이미 가본 칸이거나 바다로 되어 있는 칸인 경우 
    if turn == 4:
        nr = r - dr[dir]
        nc = c - dc[dir]
        turn = 0
        # 3-2. 바라보는 방향을 유지한 채로 한 칸 뒤로 이동
        if map[nr][nc] == 0:
            r, c = nr, nc
        # 3-3. 뒤쪽 방향이 바다인 칸이면 게임 stop
        else:
            break

print(answer)