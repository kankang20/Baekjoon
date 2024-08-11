
"""
title  : 42747. H-Index (Level 2)
"""

def solution(citations):
    answer = 0

    start = 0
    end = max(citations)

    while start <= end:
        
        mid = (start + end) // 2

        check = 0
        for c in citations:
            if c >= mid:
                check += 1
        
        if check >= mid:
            answer = mid
            start += 1
        else:
            end -= 1

    return answer


print(solution([3, 0, 6, 1, 5]))        # 3