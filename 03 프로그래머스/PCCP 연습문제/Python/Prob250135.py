
"""
title  : 250135. 아날로그 시계 (Level 2)
"""

import decimal

def solution(h1, m1, s1, h2, m2, s2):

    answer = 0
    
    start = h1 * 3600 + m1 * 60 + s1 
    end = h2 * 3600 + m2 * 60 + s2

    for tt in range(start, end):

        now = calculate_degree(tt)
        next = calculate_degree(tt+1)

        is_hour = check_hour(now, next)
        is_minute = check_minute(now, next)

        if (is_hour and is_minute):
            answer += (1 if (next[1] == next[2]) else 2)
        elif (is_hour or is_minute):
            answer += 1

    if (start == 0 or start == 43200):
        answer += 1

    return answer

def calculate_degree(second:int):

    h = decimal.Decimal(second) / 3600
    m = (second % 3600) / 60
    s = (second % 3600) % 60

    hDegree = ((h % 12) * 30) + (m * 0.5) + (s * (1/120)) 
    mDegree = (m * 6) + (s * 0.1)
    sDegree = (s * 6)

    return [hDegree, mDegree, sDegree]

def check_hour(now:list, next:list):

    if (now[2] < now[0] and next[0] <= next[2]):
        return True
    
    if (now[2] == 354 and 354 < now[0]):
        return True

    return False

def check_minute(now:list, next:list):

    if (now[2] < now[1] and next[1] <= next[2]):
        return True
    
    if (now[2] == 354 and 354 < now[1]):
        return True
    
    return False


print(solution(0, 5, 30, 0, 7, 0))          # 2
print(solution(12, 0, 0, 12, 0, 30))        # 1
print(solution(0, 6, 1, 0, 6, 6))           # 0
print(solution(11, 59, 30, 12, 0, 0))       # 1
print(solution(11, 58, 59, 11, 59, 0))      # 1
print(solution(1, 5, 5, 1, 5, 6))           # 2
print(solution(0, 0, 0, 23, 59, 59))        # 2852