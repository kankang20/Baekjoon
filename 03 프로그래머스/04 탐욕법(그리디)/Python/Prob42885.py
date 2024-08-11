
"""
title  : 42885. 구명보트 (Level 2)
"""

def solution(people, limit):
    answer = 0

    people.sort()

    start, target = 0, len(people) - 1
    while start <= target:

        p1 = people[start]
        while start <= target and p1 + people[target] > limit:
            answer += 1
            target -= 1

        if start <= target:
            answer += 1

        start += 1
        target -= 1

    return answer

print(solution([70, 50, 80, 50], 100))      # 3
print(solution([70, 80, 50], 100))          # 3

print(solution([70], 100))                  # 1