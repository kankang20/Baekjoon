
"""
title  : 13335. 트럭 (Silver 1)
time   : 68ms      152ms
memory : 34160KB   113164KB
"""

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    N, M, L = map(int, input().split())                 # 트럭의 수 N, 다리 길이 M, 다리의 최대하중 L
    trucks = deque(list(map(int, input().split())))     # 각 트럭의 무게

    bridge = deque()

    weight = trucks.popleft()
    bridge.append(weight)

    answer = 1
    while weight:

        if len(bridge) == M:
            weight -= bridge.popleft()

        if trucks and weight + trucks[0] <= L:
            weight += trucks[0]
            bridge.append(trucks.popleft())
        else:
            bridge.append(0)

        answer += 1

    return answer

print(solution())