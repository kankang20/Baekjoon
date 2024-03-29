
""" 실버 2. N과 M (12) """

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())
    numbers = sorted(list(set(map(int, input().split()))))

    N = len(numbers)

    def dfs(count:int, idx:int, answer:str):

        if count == M:
            print(answer[1:])
            return
        
        for jdx in range(idx, N):
            dfs(count+1, jdx, answer + ' ' + str(numbers[jdx]))

    dfs(0, 0, '')

solution()