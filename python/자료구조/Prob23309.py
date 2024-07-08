
""" 골드 4. 철도 공사 """

import sys

class Station():
    def __init__(self, value, prev, next):
        self.value = value
        self.prev = prev
        self.next = next

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())
    N -= 1

    position = {}
    subway = []
    for idx, value in enumerate(list(map(int, input().split()))):
        position[value] = idx
        if idx == 0:
            subway.append(Station(value, N, 1))
        elif idx == (N-1):
            subway.append(Station(value, N-1, 0))
        else:
            subway.append(Station(value, idx-1, idx+1))

    for _ in range(M):
        com = list(input().rstrip().split())

        if com[0] == "BN":
            # position에서 현재 위치 가져오기
            temp = position[int(com[1])]
            # 현재 Station의 다음 역 출력, next 변경
            tnext, tprev = 0, 0
            station = subway[temp]
            print(subway[station.next].value)
            station.next = N
            


            # 다음 역의 prev 변경
            # 역 추가하기

            station = subway[temp]
            N += 1
        elif com[0] == "BP":
            N += 1
        elif com[0] == "CN":
            N -= 1
        elif com[0] == "CP":
            N -= 1


solution()