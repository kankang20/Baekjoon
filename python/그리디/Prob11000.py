
""" 골드 5. 강의실 배정 """

import sys
from heapq import heappush, heappop

def solution():
    input = sys.stdin.readline

    N = int(input())

    meeting = []
    for _ in range(N):
        start, end = map(int, input().split())
        heappush(meeting, (start, end))

    room = []
    heappush(room, heappop(meeting)[1])
    while meeting:
        start, end = heappop(meeting)
        if start < room[0]:
            heappush(room, end)
        else:
            heappop(room)
            heappush(room, end)

    return len(room)
    
print(solution())