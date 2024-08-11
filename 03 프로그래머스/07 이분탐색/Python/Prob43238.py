
"""
title  : 43238. 입국심사 (Level 3)
"""

def solution(n, times):
    answer = 0
    start, end = 0, 1000000000*100000

    while start <= end:

        mid = (start+ end) // 2

        count = 0
        for t in times:
            count += mid // t
        
        if n <= count:
            answer = mid
            end = mid - 1
        else:
            start = mid + 1

    return answer

print(solution(6, [7, 10]))         # 28

print(solution(6, [10, 1]))         # 6
print(solution(6, [2, 5]))          # 10