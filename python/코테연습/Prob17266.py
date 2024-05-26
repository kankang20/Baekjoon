
""" 실버 4. 어두운 굴다리 """

import sys
import math

def solution():
    input = sys.stdin.readline

    N = int(input())                        # 굴다리의 길이
    M = int(input())                        # 가로등의 개수
    pos = list(map(int, input().split()))   # 가로등 위치

    answer = pos[0]
    for idx in range(1, M):
        answer = max(answer, math.ceil((pos[idx] - pos[idx-1]) / 2))

    return max(answer, N - pos[-1])

print(solution())