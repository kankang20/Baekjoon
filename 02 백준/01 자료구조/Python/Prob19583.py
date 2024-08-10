
"""
title  : 19583. 싸이버개강총회 (Silver 2)
time   : 100ms     196ms
memory : 43548KB   123820KB
"""

import sys

input = sys.stdin.readline

def solution():
    S, E, Q = input().split()       # 개강총회를 시작한 시간 S, 끝낸 시간 E, 스트리밍을 끝낸 시간 Q

    people = set()
    answer = 0

    while True:
        try:
            time, name = input().split()

            if time <= S:
                people.add(name)
            elif E <= time <= Q:
                if name in people:
                    people.remove(name)
                    answer += 1
        except:
            break

    return answer

print(solution())