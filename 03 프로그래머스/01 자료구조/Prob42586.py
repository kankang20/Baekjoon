
"""
title  : 42586. 기능개발 (Level 2)
"""

import math

def solution(progresses, speeds):

    P = [math.ceil((100 - p) / s) for p, s in zip(progresses, speeds)]

    answer = []
    standard = 0

    for next in range(len(P)):

        if P[standard] < P[next]:
            answer.append(next - standard)
            standard = next

    answer.append(next - standard + 1)

    return answer


print(solution([93, 30, 55], [1, 30, 5]))                           # [2, 1]
print(solution([95, 90, 99, 99, 80, 99], [1, 1, 1, 1, 1, 1]))       # [1, 3, 2]