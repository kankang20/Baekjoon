
""" 골드 5. A와 B """

import sys
sys.setrecursionlimit(10**6)

def solution():
    input = sys.stdin.readline

    S = input().rstrip()
    T = input().rstrip()

    min_length = len(S)
    answer = 0

    def search(target:str, length:int):
        
        if length <= min_length:
            if target == S:
                nonlocal answer
                answer = 1
            return
        
        if target[-1] == 'A':
            search(target[:-1], length - 1)
        
        if target[-1] == 'B':
            search(target[:-1][::-1], length - 1)
        
    search(T, len(T))

    return answer

print(solution())