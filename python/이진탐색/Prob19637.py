
""" 실버 3. IF문 좀 대신 써줘 """

import sys

input = sys.stdin.readline
N, M = map(int, input().split())    # 칭호의 개수 N, 칭호를 출력해야 하는 캐릭터들의 개수 M
awards = []
for _ in range(N):
    name, grade = input().split()
    awards.append((name, int(grade)))


def solution(target):
    
    if target <= awards[0][1]:
        return awards[0][0]
    else:
        for idx in range(1, N):
            if awards[idx-1][1] < target <= awards[idx][1]:
                return awards[idx][0]


for _ in range(M):
    grade = int(input())
    print(solution(grade))
