
"""
title  : 255901. 체육대회
"""

from itertools import permutations

def solution(ability):
    
    sport_count = len(ability[0])
    student = [num for num in range(len(ability))]
    
    answer = 0
    for st in list(permutations(student, sport_count)):
        
        count = 0
        for sport in range(sport_count):
            count += ability[st[sport]][sport]
        
        answer = max(answer, count)
    
    return answer

print(solution([[40, 10, 10], [20, 5, 0], [30, 30, 30], [70, 0, 70], [100, 100, 100]]))         # 210
print(solution([[20, 30], [30, 20], [20, 30]]))   