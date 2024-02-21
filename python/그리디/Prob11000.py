
""" 골드 5. 강의실 배정 """

import sys
from heapq import heappush, heappop

def solution():
    input = sys.stdin.readline

    N = int(input())

    meeting = []
    for _ in range(N):
        s, t = map(int, input().split())
        heappush(meeting, (t, s))

    answer, previous_t = 0, 0
    while meeting:

        t, s = heappop(meeting)
        if previous_t <= s:
            answer += 1
            previous_t = t
    
    return answer
    
print(solution())