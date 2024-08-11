
"""
title  : 42578. 의상 (Level 2)
"""

def solution(clothes):
    
    all_clothes = {}

    for _, key in clothes:
        all_clothes[key] = all_clothes.setdefault(key, 0) + 1

    answer = 1

    for value in all_clothes.values():
        answer *= (value+1)

    return answer-1

print(solution([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]))     # 5
print(solution([["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]))                 # 3