
"""
title  : 1845. 폰켓몬 (Level 1)
"""

def solution(nums):
    
    mons = set()
    for n in nums:
        mons.add(n)

    count = len(nums) // 2
    return count if count <= len(mons) else len(mons)

print(solution([3,1,2,3]))          # 2
print(solution([3,3,3,2,2,4]))      # 3
print(solution([3,3,3,2,2,2]))      # 2