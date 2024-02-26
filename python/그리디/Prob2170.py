
""" 골드 5. 선 긋기 """

import sys
from heapq import heappush, heappop

def solution():
    input = sys.stdin.readline

    N = int(input())

    lines = []
    for _ in range(N):
        s, t = map(int, input().split())
        heappush(lines, (s, t))

    answer = 0
    start, target = 0, 0
    while lines:
        s, t = heappop(lines)

        if target < s:
            answer += (target - start)
            start, target = s, t
            continue

        if s < start:
            start = s
        if target < t:
            target = t

    return answer + (target - start)

print(solution())