
""" 골드 5. 계란으로 계란치기 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())    # 계란 수

    # 계란으로 계란을 치게 되면 각 계란의 내구도는 상대 계란의 무게만큼 깎이게 된다.
    egg = [list(map(int, input().split())) for _ in range(N)]   # 내구도, 무게

    global answer
    answer = 0

    def dfs(idx, count):

        print(idx, count)
        if idx == N:
            answer = max(answer, count)
            return

        # 단, 손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다.
        if egg[idx][0] < 0 or count == N-1:
            return
        
        for jdx in range(idx+1, N):
            if 0 < egg[jdx][0]:
                egg[jdx][0] -= egg[idx][1]
                egg[idx][0] -= egg[jdx][1]
                dfs(idx+1, count+1 if egg[jdx][0] < 0 else count)
                egg[jdx][0] += egg[idx][1]
                egg[idx][0] -= egg[jdx][1]
    dfs(0, 0)

    return answer

print(solution())