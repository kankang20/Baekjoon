
"""
title  : 2805. 나무 자르기 (Silver 2)
time   : 2140ms       504ms
memory : 143400KB     259860KB
"""

import sys

input = sys.stdin.readline
N, M = map(int, input().split())            # 나무의 수 N, 가져가려는 나무의 길이 M
trees = list(map(int, input().split()))     # 나무들의 높이

def solution(start, end):
    answer = 0

    while start <= end:
        mid = (start + end) // 2

        total = 0
        for t in trees:
            if t > mid:
                total += (t - mid)

        if total < M:
            end = mid - 1
        else:
            answer = mid
            start = mid + 1

    return answer

print(solution(0, max(trees)))