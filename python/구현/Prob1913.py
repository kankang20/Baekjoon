
""" 실버 3. 달팽이 """

N = int(input())        # 달팽이의 크기
answer = int(input())   # 찾아야 하는 수

def solution():
    graph = [[0] * N for _ in range(N)]
    
    r, c = N//2, N//2
    flag, ansr, ansc = True, 0, 0

    dir = [[-1, 0], [0, 1], [1, 0], [0, -1]]    # 위 오른쪽 아래 왼쪽
    dir_idx = 0

    number, count = 1, 1

    for _ in range(N-1):
        for _ in range(2):
            for _ in range(count):
                graph[r][c] = number
                if flag and number == answer:
                    flag, ansr, ansc = False, r, c
                r += dir[dir_idx][0]
                c += dir[dir_idx][1]
                number += 1
            dir_idx = (dir_idx + 1) % 4
        count += 1

    for _ in range(count):
        graph[r][c] = number
        if flag and number == answer:
            flag, ansr, ansc = False, r, c
        r += dir[dir_idx][0]
        c += dir[dir_idx][1]
        number += 1

    for i in range(N):
        for j in range(N):
            print(graph[i][j], end=" ")
        print()

    print(ansr+1, ansc+1)
    
solution()