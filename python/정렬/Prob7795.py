
""" 실버 3. 먹을 것인가 먹힐 것인가 """

import sys

def solution():
    input = sys.stdin.readline

    T = int(input())
    for _ in range(T):

        N, M = map(int, input().split())        # A의 수 N, B의 수 M
        A = list(map(int, input().split()))
        B = list(map(int, input().split()))

        A.sort()
        B.sort(reverse=True)

        answer = 0

        bdx = M-1
        for a in A:
            while 0 <= bdx and B[bdx] < a:
                bdx -= 1
            answer += (M - bdx - 1)
        
        print(answer)

solution()