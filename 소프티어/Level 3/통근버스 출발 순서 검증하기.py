
""" Lv 3. [HSAT 4회 정기 코딩 인증평가 기출] 통근버스 출발 순서 검증하기 """

import sys
from itertools import combinations

def solution():
    input = sys.stdin.readline

    N = int(input())
    bus= list(map(int, input().split()))

    answer = 0
    for temp in list(combinations(bus, 3)):
        if temp[2] < temp[0] < temp[1]:
            answer += 1

    return answer

print(solution())