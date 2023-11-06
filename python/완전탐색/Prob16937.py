
""" 실버 3. 두 스티커 """

import sys
from itertools import combinations

def solution():

    input = sys.stdin.readline

    R, C = map(int, input().split())
    N = int(input())                        # 스티커 수
    sticker = []
    for _ in range(N):
        r, c = map(int, input().split())
        sticker.append((r, c))

    answer = 0

    for temp in list(combinations(sticker, 2)):
        if check(R, C, temp[0], temp[1]):
            answer = max(answer, temp[0][0]*temp[0][1] + temp[1][0]*temp[1][1])

    return answer

def check(R, C, s1, s2):

    # 둘다 회전하지 않음
    if s1[0] + s2[0] <= R and max(s1[1],s2[1]) <= C:
        return True
    if max(s1[0], s2[0]) <= R and s1[1] + s2[1] <= C:
        return True
    # s1만 90도 회전
    if s1[1] + s2[0] <= R and max(s1[0],s2[1]) <= C:            
        return True
    if max(s1[1], s2[0]) <= R and s1[0] + s2[1] <= C:
        return True
    # s2만 90도 회전
    if s1[0] + s2[1] <= R and max(s1[1],s2[0]) <= C:
        return True
    if max(s1[0], s2[1]) <= R and s1[1] + s2[0] <= C:
        return True
    # 둘다 회전
    if s1[1] + s2[1] <= R and max(s1[0],s2[0]) <= C:
        return True
    if max(s1[1], s2[1]) <= R and s1[0] + s2[0] <= C:
        return True

    return False

print(solution())