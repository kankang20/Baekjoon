
"""
title  : 2003. 수들의 합 2 (Silver 4)
time   : 44ms       140ms
memory : 32140KB    109240KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())
    numbers = list(map(int, input().split()))

    answer = 0
    start, end, count = 0, 0, numbers[0]
    while end < N and start <= end:

        if count <= M:
            if count == M:
                answer += 1
            if end == N-1:
                break
            end += 1
            count += numbers[end]
        elif count > M:
            if start == end:
                if end == N-1:
                    break
                end += 1
                count += numbers[end]
            else:
                count -= numbers[start]
                start += 1

    return answer

print(solution())