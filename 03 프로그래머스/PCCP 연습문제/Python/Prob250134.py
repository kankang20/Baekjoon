
"""
title  : 250134. 수레 움직이기 (Level 3)
"""

from collections import deque
import copy

dr = [0, 0, -1, 1]
dc = [-1, 1, 0, 0]

def solution(maze):
    
    global R, C
    R = len(maze)
    C = len(maze[0])

    rpos = 0
    bpos = 0

    # 수레 시작 위치 탐색
    for r in range(R):
        for c in range(C):
            if maze[r][c] == 1:     # red 수레 시작 위치
                rpos = (r, c)
            elif maze[r][c] == 2:   # blue 수레 시작 위치
                bpos = (r, c)
    
    return bfs(maze, rpos, bpos)

def bfs(maze:list, rpos:tuple, bpos:tuple):
    q = deque()

    rselected = [[False] * C for _ in range(R)]     # red 이동 경로
    bselected = [[False] * C for _ in range(R)]     # blue 이동 경로

    # red와 blue의 현재 위치, 이동 경로 저장
    q.append((rpos, bpos, rselected, bselected, 0))

    rflag = False   # red 도착 여부
    bflag = False   # blue 도착 여부

    while q:
        (rr, rc), (br, bc), rseltemp, bseltemp, count = q.popleft()

        # red와 blue가 모두 도착했어요 :D
        if maze[rr][rc] == 3 and maze[br][bc] == 4:
            return count
        else:
            rflag = True if maze[rr][rc] == 3 else False    # red만 도착했어요 :)
            bflag = True if maze[br][bc] == 4 else False    # blue만 도착했어요 :)

        # ? 왜 두 과정을 바꾸면 틀릴까 ? ##########################################################################
        # rseltemp[rr][rc] = True
        # bseltemp[br][bc] = True
        
        rselected = copy.deepcopy(rseltemp)
        bselected = copy.deepcopy(bseltemp)

        rselected[rr][rc] = True
        bselected[br][bc] = True
        ##########################################################################################################

        for d in range(4):

            # 만약 red 수레가 도착했다면 blue 수레는 도착하지 않았겠지 :(
            if rflag:
                nbr = br + dr[d]
                nbc = bc + dc[d]
                
                # 격자 판 안에 있어야 하고, 가본 적 없는 공간이어야 하고, 벽이 아니어야 하고, 다른 수레가 있으면 안되고
                if check_boundary(nbr, nbc) or bselected[nbr][nbc] or maze[nbr][nbc] == 5 or (rr == nbr and rc == nbc):
                    continue
                
                q.append(((rr, rc), (nbr, nbc), rselected, bselected, count+1))

            # 만약 blue 수레가 도착했다면 red 수레는 도착하지 않았겠지 :(
            elif bflag:                 
                nrr = rr + dr[d]
                nrc = rc + dc[d]

                if check_boundary(nrr, nrc) or rselected[nrr][nrc] or maze[nrr][nrc] == 5 or (nrr == br and nrc == bc):
                    continue
                
                q.append(((nrr, nrc), (br, bc), rselected, bselected, count+1))

            # red, blue 둘 다 도착하지 않았지 :(
            else:
                # red 먼저 이동시키기
                nrr = rr + dr[d]
                nrc = rc + dc[d]

                if check_boundary(nrr, nrc) or rselected[nrr][nrc] or maze[nrr][nrc] == 5:
                    continue
                
                # red 이동에 따라 blue 하나씩 이동해보기
                for dd in range(4):
                    nbr = br + dr[dd]
                    nbc = bc + dc[dd]

                    if check_boundary(nbr, nbc) or bselected[nbr][nbc] or maze[nbr][nbc] == 5 or (nrr == nbr and nrc == nbc): 
                        continue
                    
                    # red와 blue가 서로 위치를 바꾸는 것은 불가능
                    if (nrr == br and nrc == bc) and (nbr == rr and nbc == rc):
                        continue
                    
                    # 돌리는 과정에 방문 체크를 해버리면 red에 따라 blue를 이동시킬 때 하는 방문 체크가 다른 이동에도 영향을 끼치게 됨
                    q.append(((nrr, nrc), (nbr, nbc), rselected, bselected, count+1))

    return 0

def check_boundary(r, c):
    return r < 0 or r >= R or c < 0 or c >= C


print(solution([[1, 4], [0, 0], [2, 3]]))                                   # 3
print(solution([[1, 0, 2], [0, 0, 0], [5, 0 ,5], [4, 0, 3]]))               # 7
print(solution([[1, 5], [2, 5], [4, 5], [3, 5]]))                           # 0
print(solution([[4, 1, 2, 3]]))                                             # 0

print(solution([[5, 0, 3, 5],[0, 0, 0, 0],[5, 0, 4, 0],[5, 2, 1, 0]]))      # 3
print(solution([[1, 0, 5, 2],[0, 3, 0, 0],[0, 4, 5, 0],[0, 0, 0, 0]]))      # 6
print(solution([[4, 3, 0, 0],[5, 5, 5, 0],[1, 0, 0, 0],[2, 0, 0, 0]]))      # 9