
""" 골드 5. A와 B """

import sys

def solution():
    input = sys.stdin.readline

    S = input().rstrip()
    T = input().rstrip()

    max_length = len(T)
    answer = 0

    def search(target:str, length:int):
        
        if max_length <= length:
            if T == target:
                nonlocal answer
                answer = 1
            return
        
        search(target + "A", length + 1)
        search(target[::-1] + "B", length + 1)

    search(S, len(S))

    return answer

print(solution())