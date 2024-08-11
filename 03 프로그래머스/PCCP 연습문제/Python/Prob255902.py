
"""
title  : 255902. 유전법칙
"""

def solution(queries):
    answer = []
    
    for query in queries:   # 완두콩의 세대 query[0], 해당 세대 내에서 객체 번호 query[1]
        answer.append(find(query[0], query[1]-1))
    
    return answer

def find(generation, order):
    
    stack = []
    while generation > 1:
        generation -= 1
        stack.append(order % 4)
        order //= 4
        
    while stack:
        temp = stack.pop()
        if temp == 0:
            return "RR"
        if temp == 3:
            return "rr"
        
    return "Rr"

print(solution([[3, 5]]))                       # ["RR"]
print(solution([[3, 8], [2, 2]]))               # ["rr", "Rr"]
print(solution([[3, 1], [2, 3], [3, 9]]))       # ["RR", "Rr", "RR"]
print(solution([[4, 26]]))                      # ["Rr"]