
"""
title  : 42842. 카펫 (Level 2)
"""

import math

def solution(brown, yellow):

    # 노란색의 개수 = (가로 - 2) * (세로 - 2)
    # 갈색의 개수 = 가로 * 2 + (세로 - 2) * 2 = (가로 + 세로 - 2) * 2

    total = (brown // 2) + 2

    for width in range(math.ceil(total / 2), total):
        
        height = total - width

        if yellow == (width - 2) * (height - 2):
            return [width, height] 

print(solution(10, 2))      # [4, 3]
print(solution(8, 1))       # [3, 3]
print(solution(24, 24))     # [8, 6]