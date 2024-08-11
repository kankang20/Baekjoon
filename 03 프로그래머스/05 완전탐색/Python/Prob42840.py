
"""
title  : 42840. 모의고사 (Level 1)
"""

def solution(answers):
    
    S1 = [1, 2, 3, 4, 5]
    S2 = [2, 1, 2, 3, 2, 4, 2, 5]
    S3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    check = [0, 0, 0]
    
    for i, num in enumerate(answers):
        
        if S1[i % 5] == num:
            check[0] += 1
        if S2[i % 8] == num:
            check[1] += 1
        if S3[i % 10] == num:
            check[2] += 1
    
    maxCheck = max(check)
    
    answer = [i+1 for i in range(len(check)) if check[i] >= maxCheck]
    
    return answer

print(solution([1, 2, 3, 4, 5]))
print(solution([1, 3, 2, 4, 2]))