
"""
title  : 255905. 신입사원 교육
"""

from heapq import heappush, heappop, heapify

def solution(ability, number):
    
    heapify(ability)
    
    for _ in range(number):
        
        temp = heappop(ability) + heappop(ability)
        
        heappush(ability, temp)
        heappush(ability, temp)
    
    return sum(ability)

print(solution([10, 3, 7, 2], 2))       # 37
print(solution([1, 2, 3, 4], 3))        # 26