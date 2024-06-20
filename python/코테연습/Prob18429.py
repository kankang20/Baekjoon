
""" 실버 3. 근손실 """

import sys
from itertools import permutations

def solution():
    input = sys.stdin.readline

    N, K = map(int, input().split())
    exer = list(map(int, input().split()))

    answer = 0
    for temp in list(permutations([num for num in range(N)], N)):
        count = 0
        for t in temp:
            count += (exer[t] - K)
            if count < 0:
                break
        else:
            answer += 1
    
    return answer

print(solution())