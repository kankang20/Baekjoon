
""" 골드 5. 선 긋기 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())

    lines = []
    for _ in range(N):
        s, t = map(int, input().split())
        lines.append((s, t))

    lines.sort()

    answer = 0
    start, target = 0, 0
    for (s, t) in lines:
        
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