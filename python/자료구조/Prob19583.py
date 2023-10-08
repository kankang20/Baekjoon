
""" 실버 2. 싸이버개강총회 """

import sys

input = sys.stdin.readline

def solution():
    S, E, Q = input().split()       # 개강총회를 시작한 시간 S, 끝낸 시간 E, 스트리밍을 끝낸 시간 Q

    people = {}
    answer = 0

    while True:
        try:
            time, name = input().split()

            if time <= S:
                people[name] = 0
            elif E <= time <= Q:
                if name in people.keys():
                    people.pop(name)
                    answer += 1
        except:
            break

    return answer

print(solution())