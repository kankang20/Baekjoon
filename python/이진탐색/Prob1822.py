
""" 실버 4. 차집합 """

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())
    A = sorted(list(map(int, input().split())))
    B = sorted(list(map(int, input().split())))

    def search(target:int):

        start = 0
        end = M-1

        while start <= end:

            mid = (start + end) // 2

            if B[mid] == target:
                return False
            elif B[mid] < target:
                start = mid + 1
            elif target < B[mid]:
                end = mid - 1 
            
        return True
    
    answer = []
    for a in A:
        if search(a):
            answer.append(str(a))

    print(len(answer))
    if answer:
        print(" ".join(answer))

solution()