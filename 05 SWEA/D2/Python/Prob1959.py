
"""
title  : 1959. 두 개의 숫자열 (D2)
time   : 111ms
memory : 44004kb
"""

def solution():

    T = int(input())
    for tc in range(1, T+1):

        N, M = map(int, input().split())
        A = list(map(int, input().split()))
        B = list(map(int, input().split()))

        answer = 0

        if N <= M:
            answer = compute(N, M, A, B)
        else:
            answer = compute(M, N, B, A)

        print(f'#{tc} {answer}')

def compute(a:int, b:int, A:list, B:list):

    answer = 0

    for i in range(b - a + 1):
        count = 0
        for j in range(a):
            count += A[j] * B[j + i]
        answer = max(answer, count)
    
    return answer

solution()