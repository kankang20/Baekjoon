
""" 실버 2. N과 M (9) """

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())
    numbers = sorted(list(map(int, input().split())))

    check = set()

    def make(count:int, answer:list, selected:list):
        
        if count == M:
            temp = " ".join(answer)
            if temp not in check:
                print(temp)
                check.add(temp)
            return
        
        for idx in range(N):

            if selected[idx]:
                continue

            answer.append(str(numbers[idx]))
            selected[idx] = True
            
            make(count+1, answer, selected)
            
            answer.pop()
            selected[idx] = False

    make(0, [], [False] * N)

solution()