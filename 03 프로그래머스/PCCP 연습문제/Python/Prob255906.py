
"""
title  : 255906. 카페 확장
"""

def solution(menu, order, k):
    
    cur = 0
    length = len(order)
    
    answer = 0
    for odx in range(length):
            
        cur = max(odx*k, cur) + menu[order[odx]]
        
        people = min(length, cur//k+1) - odx
        
        if cur % k == 0:
            people -= 1
        
        answer = max(answer, people)
    
    return answer

print(solution([5, 12, 30], [1, 2, 0, 1], 10))              # 3
print(solution([5, 12, 30], [2, 1, 0, 0, 0, 1, 0], 10))     # 4
print(solution([5], [0, 0, 0, 0, 0], 5))                    # 1

print(solution([5, 6, 7, 11], [1, 2, 3, 3, 2, 1, 1], 10))   # 2