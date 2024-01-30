
""" Lv 3. [HSAT 6회 정기 코딩 인증평가 기출] 염기서열 커버 """

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())    # 염기서열의 개수 N, 염기서열 길이 M
    
    lines = [set(".") for _ in range(M)]
    for _ in range(N):
        command = list(input().rstrip())
        for jdx in range(M):
            lines[jdx].add(command[jdx])

    answer = 0
    for temp in lines:
        answer = max(answer, len(temp))
            
    return answer-1

print(solution())