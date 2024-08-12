
"""
title  : 6266. [21년 재직자 대회 예선] 회의실 예약 (Level 2)
time   : 104ms
memory : 37.44MB
"""

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())

    room = dict()
    for _ in range(N):
        room[input().rstrip()] = []

    for _ in range(M):
        name, start, end = input().rstrip().split()
        room[name].append((int(start), int(end)))

    for (idx, name) in enumerate(sorted(room.keys())):
        print("Room {0}:".format(name))
        available_time = room_time(room[name])

        if not available_time:
            print("Not available")
        else:
            print("{0} available:".format(len(available_time)))
            for (st, et) in available_time:
                print("{0}-{1}".format(str(st).zfill(2), str(et).zfill(2)))
        
        if idx < N-1:
            print("-----")
    
def room_time(reserved_time:list):
    answer = []     # 09 - 18

    tt = 9
    for (st, et) in sorted(reserved_time):
        if tt < st:
            answer.append((tt, st))
        tt = et

    if tt < 18:
        answer.append((tt, 18))
        
    return answer

solution()