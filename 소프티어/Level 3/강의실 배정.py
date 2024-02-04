
""" Lv 3. 강의실 배정 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())    # 강의 개수
    lecture = [list(map(int, input().split())) for _ in range(N)]   # 강의 (시작 시간, 종료 시간)

print(solution())