
"""
title  : 42627. 디스크 컨트롤러 (Level 3)
"""

from heapq import heappush, heappop, heapify

def solution(jobs):
    answer = 0
    answer_length = len(jobs)

    heapify(jobs)
    
    disk_time, temp = 0, []
    while jobs:

        temp.clear()

        while jobs and jobs[0][0] <= disk_time:
            s, l = heappop(jobs)
            heappush(temp, [l, s])

        if temp:
            l, s = heappop(temp)
            answer += (disk_time - s + l) 
            disk_time += l
        elif jobs:
            s, l = heappop(jobs)
            answer += l
            disk_time = s + l

        while temp:
            l, s = heappop(temp)
            heappush(jobs, [s, l])

    return answer//answer_length

print(solution([[0, 3], [1, 9], [2, 6]]))   # 9

print(solution([[0, 3], [2, 5], [4, 2]]))   # 5
print(solution([[2, 3], [2, 5], [4, 2]]))   # 5
print(solution([[0, 6], [2, 8], [3, 7], [7, 1], [11, 11], [19, 25], [30, 15], [32, 6], [40, 3]]))   # 19