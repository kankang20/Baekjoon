
""" 골드 3. 코딩은 예쁘게 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())
    current = list(map(int, input().split()))
    target = list(map(int, input().split()))

    diff = [(target[i] - current[i]) for i in range(N)]

    idx, answer = 0, 0
    while idx < N:

        day = abs(diff[idx])

        if diff[idx] < 0:
            while idx < N and diff[idx] < 0:
                day = max(day, abs(diff[idx]))
                idx += 1
        elif diff[idx] > 0:
            while idx < N and diff[idx] > 0:
                day = max(day, abs(diff[idx]))
                idx += 1
            
        answer += day

    return answer

print(solution())