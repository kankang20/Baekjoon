
"""
title  : 43236. 징검다리 (Level 4)
"""

def solution(distance, rocks, n):

    rocks.sort()

    rocks = sorted(rocks) + [distance]

    answer, start, end = 0, 0, distance

    while start <= end:
        mid = (start + end) // 2

        count, i = 0, 0
        for rock in rocks:
            if rock - i < mid:
                count += 1
            else:
                i = rock

        if count > n:
            end = mid - 1
        else:
            answer = mid
            start = mid + 1

    return answer

print(solution(25, [2, 14, 11, 21, 17], 2))     # 4

print(solution(16, [4, 8, 11], 2))              # 8
print(solution(1, [1], 1))                      # 1
print(solution(23, [3, 6, 9, 10, 14, 17], 2))   # 3
print(solution(5, [3], 1))                      # 5