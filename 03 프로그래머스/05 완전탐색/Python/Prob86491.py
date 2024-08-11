
"""
title  : 86491. 최소직사각형 (Level 1)
"""

def solution(sizes):
    
    maxAnswer = 0
    minAnswer = 0
    
    for size in sizes:
        maxAnswer = max(maxAnswer, max(size))
        minAnswer = max(minAnswer, min(size))
    
    return maxAnswer * minAnswer

print(solution([[60, 50], [30, 70], [60, 30], [80, 40]]))
print(solution([[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]))
print(solution([[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]))