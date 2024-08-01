
""" 골드 4. 마법사 상어와 파이어볼 """

import sys
from collections import deque

dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, 1, 1, 1, 0, -1, -1, -1]

def solution():
    input = sys.stdin.readline

    N, M, K = map(int, input().split())
    
    fireballs = deque()
    for _ in range(M):
        r, c, m, d, s = map(int, input().split())
        fireballs.append((r-1, c-1, m, d, s))

    board = [[deque() for _ in range(N)] for _ in range(N)]

    for _ in range(K):

        # 1. 모든 파이어볼이 자신의 방향 d로 속력 s칸 만큼 이동한다.
        while fireballs:
            r, c, m, d, s = fireballs.popleft()
            nr = (r + dr[d] * s) % N
            nc = (c + dc[d] * s) % N
            board[nr][nc].append((m, d, s))

        # 2. 이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 칸에서는 다음과 같은 일이 일어난다.
        for r in range(N):
            for c in range(N):
                
                if len(board[r][c]) == 0:
                    continue

                if len(board[r][c]) == 1:
                    nm, nd, ns = board[r][c][0]
                    fireballs.append((r, c, nm, nd, ns))

                else:
                    # 2-1. 같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
                    # 2-2. 파이어볼은 4개의 파이어볼로 나누어진다.
                    # 2-3. 나누어진 파이어볼의 질량, 속력, 방향은 다음과 같다. 
                    totalf = 0      # 파이어볼의 개수
                    totalm = 0      # 파이어볼 질량의 합
                    totals = 0      # 파이어볼 속력의 합

                    check = board[r][c][0][1] % 2
                    flag = True
                    for (m, d, s) in board[r][c]:
                        totalf += 1
                        totalm += m
                        totals += s
                        if d % 2 != check:
                            flag = False
                
                    nm = totalm // 5
                    ns = totals // totalf

                    if nm == 0:
                        continue

                    if flag:    # 방향 [0, 2, 4, 6]
                        for nd in [0, 2, 4, 6]:
                            fireballs.append((r, c, nm, nd, ns))
                    else:
                        for nd in [1, 3, 5, 7]:
                            fireballs.append((r, c, nm, nd, ns))

    answer = 0
    while fireballs:
        _, _, m, _, _ = fireballs.popleft()
        answer += m

    return answer


print(solution())