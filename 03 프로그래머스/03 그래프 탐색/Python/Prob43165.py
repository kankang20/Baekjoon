
"""
title  : 43165. 타겟 넘버 (Level 2)
"""

from collections import deque

def solution(numbers, target):
    queue = deque()

    queue.append(numbers[0])
    queue.append(-numbers[0])

    idx = 1

    while idx < len(numbers):

        for _ in range(len(queue)):

            num = queue.popleft()

            queue.append(num + numbers[idx])
            queue.append(num - numbers[idx])

        idx += 1

    return queue.count(target)


## 실행
print(solution([1, 1, 1, 1, 1], 3))     # 5
print(solution([4, 1, 2, 1], 4))        # 2