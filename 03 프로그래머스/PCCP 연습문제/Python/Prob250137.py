
"""
title  : 250137. 붕대 감기 (Level 1)
"""

def solution(bandage, health, attacks):
    
    now_time = 0
    now_health = health
    
    for at, ad in attacks:
        
        temp_time = at - now_time - 1
        
        now_health += (temp_time * bandage[1])
        now_health += (temp_time // bandage[0]) * bandage[2] 
        
        if now_health >= health:
            now_health = health
            
        now_health -= ad
        
        if now_health <= 0:
            return -1
        
        now_time = at

    return now_health

print(solution([5, 1, 5], 30, [[2, 10], [9, 15], [10, 5], [11, 5]]))    # 5
print(solution([3, 2, 7], 20, [[1, 15], [5, 16], [8, 6]]))              # -1
print(solution([4, 2, 7], 20, [[1, 15], [5, 16], [8, 6]]))              # -1
print(solution([1, 1, 1], 20, [[1, 2], [3, 2]]))                        # 3