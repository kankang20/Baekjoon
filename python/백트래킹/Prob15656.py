
""" 실버 3. N과 M (7) """

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())
    numbers = sorted(list(map(int, input().split())))

    def make(count:int, answer:list):

        if count == M:
            print(" ".join(answer))
            return
        
        for num in numbers:
            answer.append(str(num))
            make(count+1, answer)
            answer.pop()

    make(0, [])

solution()