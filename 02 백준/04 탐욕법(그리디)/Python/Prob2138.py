
"""
title  : 2138. 전구와 스위치 (Gold 5)
time   : 80ms       140ms
memory : 33468KB    119604KB
"""

import sys

def solution():

    input = sys.stdin.readline

    N = int(input())
    current = list(map(int, input().rstrip()))
    target = list(map(int, input().rstrip()))

    # 0번을 누르지 않고 시작
    count, changed_current = change_switch(N, current[:], target)

    if isPossible(changed_current, target):
        return count

    # 0번을 누르고 시작
    current[0] = abs(current[0]-1)
    current[1] = abs(current[1]-1)
    count, changed_current = change_switch(N, current, target)

    if isPossible(changed_current, target):
        return count+1

    return -1

def change_switch(N:int, current:list, target:list):

    count = 0
    for idx in range(1, N):
        if target[idx-1] != current[idx-1]:
            count += 1
            current[idx-1] = abs(current[idx-1]-1)
            current[idx] = abs(current[idx]-1)
            if idx+1 < N:
                current[idx+1] = abs(current[idx+1]-1)
        
    return count, current

def isPossible(current, target):
    if current[-1] == target[-1]:
        return True
    return False

print(solution())