
""" Lv 3. 강의실 배정 """

import sys
from heapq import heappush, heappop

def solution():
    input = sys.stdin.readline

    N = int(input())    # 강의 개수
    lecture = []        # 강의 (종료 시간, 시작 시간)

    for _ in range(N):
        start, end = map(int, input().split())
        heappush(lecture, (end, start))

    answer = 1
    previous_time, _ = heappop(lecture)
    while lecture:
        
        end_time, start_time = heappop(lecture)

        if previous_time <= start_time:
            answer += 1
            previous_time = end_time

    return answer

print(solution())