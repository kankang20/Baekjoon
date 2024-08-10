
"""
title  : 23309. 철도 공사 (Gold 4)
time   : 
memory : 
"""

import sys

class Station():
    def __init__(self, value, prev, next):
        self.value = value
        self.prev = prev
        self.next = next

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())

    position = {}
    subway = []
    for idx, value in enumerate(list(map(int, input().split()))):
        position[value] = idx
        if idx == 0:
            subway.append(Station(value, N-1, 1))
        elif idx == (N-1):
            subway.append(Station(value, N-2, 0))
        else:
            subway.append(Station(value, idx-1, idx+1))

    for _ in range(M):
        com = list(input().rstrip().split())

        if com[0] == "BN":
            now_pos = position[int(com[1])]
            now_station = subway[now_pos]

            next_pos = now_station.next
            next_station = subway[next_pos]

            print(next_station.value)
            
            subway.append(Station(int(com[2]), now_pos, next_pos))
            now_station.next = N
            next_station.prev = N

            position[int(com[2])] = N

            N += 1

        elif com[0] == "BP":
            now_pos = position[int(com[1])]
            now_station = subway[now_pos]

            prev_pos = now_station.prev
            prev_station = subway[prev_pos]

            print(prev_station.value)

            subway.append(Station(int(com[2]), prev_pos, now_pos))
            prev_station.next = N
            now_station.prev = N

            position[int(com[2])] = N

            N += 1

        elif com[0] == "CN":
            now_pos = position[int(com[1])]
            now_station = subway[now_pos]

            next_pos = now_station.next
            next_station = subway[next_pos]

            print(next_station.value)

            nnext_pos = next_station.next
            nnext_station = subway[nnext_pos]

            now_station.next = nnext_pos
            nnext_station.prev = now_pos

            N -= 1

        elif com[0] == "CP":
            now_pos = position[int(com[1])]
            now_station = subway[now_pos]

            prev_pos = now_station.prev
            prev_station = subway[prev_pos]

            print(prev_station.value)

            pprev_pos = prev_station.prev
            pprev_station = subway[pprev_pos]

            pprev_station.next = now_pos
            now_station.prev = pprev_pos

            N -= 1

solution()