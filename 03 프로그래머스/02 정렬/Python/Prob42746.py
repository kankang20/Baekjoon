
"""
title  : 42746. 가장 큰 수 (Level 2)
"""

def solution(numbers):
    
    sorted_numbers = sorted(list(map(str, numbers)), reverse=True, key=lambda x : (x*4)[:4])
    answer = "".join(sorted_numbers)
    
    idx = 0
    while answer[idx] == '0' and idx < len(answer)-1:
        idx+=1

    return answer[idx:] 

print(solution([6, 10, 2]))             # "6210"
print(solution([3, 30, 34, 5, 9]))      # "9534330"

print(solution([0, 0, 0, 0]))      # "0"