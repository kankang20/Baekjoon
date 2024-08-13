
"""
title  : 7568. 덩치 (Silver 5)
time   : 40ms       108ms
memory : 31120KB    109240KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())
    
    people = []
    for ndx in range(N):
        weight, height = map(int, input().split())
        people.append((ndx, weight, height))

    people.sort(key= lambda x : x[1])
    
    answer = [0] * N
    for idx in range(N):
        w, h = people[idx][1], people[idx][2]
        count = 0
        for jdx in range(idx+1, N):
            if w < people[jdx][1] and h < people[jdx][2]:
                count += 1
        answer[people[idx][0]] = count+1

    print(*answer)

solution()