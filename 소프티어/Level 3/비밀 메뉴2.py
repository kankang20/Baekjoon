
""" Lv 3. [21년 재직자 대회 본선] 비밀 메뉴2 """

import sys
from itertools import permutations

def solution():
    input = sys.stdin.readline

    N, M, K = map(int, input().split())     

    target1 = list(map(int, input().split()))
    target2 = list(map(int, input().split()))

    if N > M:
        N, M = M, N
        target1, target2 = target2, target1

    answer = 0

    subset = set()
    
    for num in range(1, N):
        for temp in list(permutations(target1, num)):
            subset.add(temp)

    print(subset)    

    return answer    

print(solution())