
"""
title  : 255903. 운영체제
"""

from heapq import heappush, heappop

def solution(program):      # (우선순위, 호출 시각, 실행 시간)
    
    # 호출 시각, 우선순위 기준으로 정렬
    program.sort(key=lambda x : (x[1], x[0]))
    plength = len(program)
    
    system = []
    heappush(system, program[0])
    
    pdx = 1
    now = program[0][1]

    answer = [0] * 11
    while pdx < plength or system:
        
        while pdx < plength and program[pdx][1] <= now:
            heappush(system, program[pdx])
            pdx += 1
        
        if not system:
            heappush(system, program[pdx])
            now = program[pdx][1]
            pdx += 1
            
        temp = heappop(system)
        
        answer[temp[0]] += (now - temp[1])
        now += temp[2]
    
    answer[0] = now

    return answer

print(solution([[2, 0, 10], [1, 5, 5], [3, 5, 3], [3, 12, 2]]))         # [20, 5, 0, 16, 0, 0, 0, 0, 0, 0, 0]
print(solution([[3, 6, 4], [4, 2, 5], [1, 0, 5], [5, 0, 5]]))           # [19, 0, 0, 4, 3, 14, 0, 0, 0, 0, 0]