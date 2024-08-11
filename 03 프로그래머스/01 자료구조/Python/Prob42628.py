
"""
title  : 42628. 이중우선순위큐 (Level 3)
"""

from heapq import heappush, heappop

def solution(operations):

    min_answer = []
    max_answer = []

    selected = [False] * len(operations)
    
    for op in range(len(operations)):

        command = operations[op].split()

        if command[0] == 'I':
            number = int(command[1])
            heappush(min_answer, (number, op))         # 최소값 우선순위
            heappush(max_answer, (-number, op))        # 최대값 우선순위

        elif command[0] == "D" and command[1] == "1":     # 최댓값 삭제
            if max_answer:
                _, idx = heappop(max_answer)
                selected[idx] = True

        elif command[0] == "D" and command[1] == "-1":      # 최솟값 삭제
            if min_answer:
                _, idx = heappop(min_answer)
                selected[idx] = True

        while max_answer and selected[max_answer[0][1]]:
            _, idx = heappop(max_answer)
            selected[idx] = True

        while min_answer and selected[min_answer[0][1]]:
            _, idx = heappop(min_answer)
            selected[idx] = True

    return [abs(heappop(max_answer)[0]), heappop(min_answer)[0]] if min_answer else [0,0]

print(solution(["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]))                         # [0,0]
print(solution(["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]))        # [333,-45]