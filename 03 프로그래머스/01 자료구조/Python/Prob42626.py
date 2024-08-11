
"""
title  : 42626. 더 맵게 (Level 2)
"""

from heapq import heappush, heappop, heapify

def solution(scoville, K):
    
    answer = 0
    slen = len(scoville)

    heapify(scoville)

    while scoville[0] < K and slen > 1:

        num1 = heappop(scoville)
        num2 = heappop(scoville)
        heappush(scoville, num1 + num2 * 2)

        answer += 1
        slen -= 1

    return answer if scoville[0] >= K else -1

print(solution([1, 2, 3, 9, 10, 12], 7))            # 2
print(solution([1, 1, 1, 1, 1, 1], 1500))           # -1