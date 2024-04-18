
""" 골드 5. 계란으로 계란치기 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())    # 계란 수

    # 계란으로 계란을 치게 되면 각 계란의 내구도는 상대 계란의 무게만큼 깎이게 된다.
    eggs = [list(map(int, input().split())) for _ in range(N)]   # 내구도, 무게

    global answer
    answer = 0

    def dfs(idx):

        global answer

        # 모든 계란을 마지막까지 확인하였기 때문에 깨진 계란의 개수를 세자!
        if idx == N:
            count = 0
            for ndx in range(N):
                if eggs[ndx][0] <= 0:
                    count += 1
            answer = max(answer, count)
            return
        
        # 이미 깨진 계란이면 그 다음 계란 확인하러 가기
        if eggs[idx][0] <= 0:
            dfs(idx+1)
            return
        
        # 내가 들고 있는 계란을 제외한 모든 계란이 깨졌다면 깨진 계란의 개수는 N-1
        flag = True
        for ndx in range(N):
            if ndx == idx: continue
            if 0 < eggs[ndx][0]:
                flag = False
                break
        
        if flag:
            answer = max(answer, N-1)
            return

        # 깨지지 않은 계란 중 하나를 친다.
        for jdx in range(N):
            if jdx != idx and 0 < eggs[jdx][0]:
                eggs[jdx][0] -= eggs[idx][1]
                eggs[idx][0] -= eggs[jdx][1]
                dfs(idx+1)
                eggs[jdx][0] += eggs[idx][1]
                eggs[idx][0] += eggs[jdx][1]
        
    dfs(0)

    return answer

print(solution())