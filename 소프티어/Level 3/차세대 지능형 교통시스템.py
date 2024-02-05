
""" Lv 3. [HSAT 1회 정기 코딩 인증평가 기출] 안전운전을 도와줄 차세대 지능형 교통시스템 """

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    N, T = map(int, input().split())

    global cross_line
    cross_line = dict()
    for r in range(1, N+1):
        for c in range(1, N+1):
            cross_line[(r, c)] = list(map(int, input().split()))

    global dir
    dir = [(-1, 0), (0, 1), (1, 0), (0, -1)]  # 상(0) 우(오른쪽)(1) 하(2) 좌(왼쪽)(3)

    global signal
    signal = [0, (0, 1, 2), (0, 1, 3), (2, 3, 0), (1, 2, 3), 
                (0, 1), (3, 0), (2, 3), (1, 2), (1, 2), (0, 1), (3, 0), (2, 3)]

    return bfs(N, T)

def bfs(N, T):

    q = deque()
    selected = [[False] * (N+1) for _ in range(N+1)]

    q.append((1, 1))
    selected[1][1] = True

    time_count, answer = 0, 1
    while q and time_count < T:

        for _ in range(len(q)):
            r, c = q.popleft()

            for s in signal[cross_line[(r, c)][time_count % 4]]:
                nr = r + dir[s][0]
                nc = c + dir[s][1]

                if nr <= 0 or nr > N or nc <= 0 or nc > N or selected[nr][nc]:
                    continue
                
                q.append((nr, nc))
                selected[nr][nc] = True
                answer += 1

        time_count += 1

    return answer

print(solution())

# 3 3
# 2 6 12 9
# 7 1 11 6
# 6 3 5 11
# 1 1 12 9
# 3 11 8 2
# 1 7 11 9
# 4 6 2 3
# 2 4 2 4
# 6 9 2 6