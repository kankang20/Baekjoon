
""" 실버 3. 선분 위의 점 """

import sys

input = sys.stdin.readline
N, M = map(int, input().split())            # 점의 개수 N, 선분의 개수 M
dots = list(map(int, input().split()))      # 점의 좌표

def binary_min(start, end, target):
    
    while start <= end:
        mid = (start + end) // 2

        if dots[mid] < target:
            start = mid + 1
        else:
            end = mid - 1

    return end+1

def binary_max(start, end, target):

    while start <= end:
        mid = (start + end) // 2

        if dots[mid] <= target:
            start = mid + 1
        else:
            end = mid - 1

    return end


dots.sort()
for _ in range(M):
        start, end = map(int, input().split())
        print(binary_max(0, N-1, end) - binary_min(0, N-1, start) + 1)