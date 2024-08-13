
"""
title  : 1561. 놀이 공원 (Gold 1)
time   : 
memory : 
"""

import sys

def solution():

    N, M = map(int, sys.stdin.readline().split())               # 아이들의 수 N, 1인승 놀이기구 종류 M
    plays = list(map(int, sys.stdin.readline().split()))        # 각 놀이기구의 운행 시간 

    if N <= M:
        return N
    
    answer = 0
    start, end = 0, 2000000000 * 30

    # 시간 계산
    while start <= end:
        mid = (start + end) // 2

        count = M
        for p in plays:
            count += mid // p

        if N <= count:
            answer = mid
            end = mid - 1
        else:
            start = mid + 1 

    # 마지막 아이가 타게되는 놀이기구
    last_child, idx = M, 0

    for p in plays:
        last_child += (answer - 1) // p

    while last_child < N:
        last_child += (1 if answer % plays[idx] == 0 else 0)
        idx += 1
    
    return idx

print(solution())
