
""" 실버 2. N과 M (12) """

import sys

def solution():
    input = sys.stdin.readline

    global N, M, numbers
    N, M = map(int, input().split())
    numbers = list(input().split())

    numbers.sort()

    global answer
    answer = set()

    dfs(0, 0, [])

    for ans in sorted(list(answer)):
        print(ans)

def dfs(count:int, pos:int, selected:list):

    if count == M:
        answer.add(" ".join(selected))
        return 
    
    for idx in range(pos, N):
        selected.append(numbers[idx])
        dfs(count+1, idx, selected)
        selected.pop()
    
solution()