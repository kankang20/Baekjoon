
""" 실버 3. 두 수의 합 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())
    number = sorted(list(map(int, input().split())))
    X = int(input())

    start, end = 0, N-1
    answer = 0
    while start < end:

        temp = number[start] + number[end]

        if temp == X:
            answer += 1
    
        if temp <= X:
            start += 1
        else:
            end -= 1 

    return answer

print(solution())