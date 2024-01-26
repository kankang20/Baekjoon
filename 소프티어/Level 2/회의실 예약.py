
""" Lv 2. [21년 재직자 대회 예션] 회의실 예약 """

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())

    room_info = dict()
    for _ in range(N):
        room_info[input().rstrip()] = []

    for _ in range(M):
        name, start, end = input().split()      # 회의실 이름 name, 시작 시각 start, 종료 시각 end
        room_info[name].append((int(start), int(end)))

    room_sorted_name = sorted(room_info.keys())
    for idx in range(N):

        name = room_sorted_name[idx]
        print_room_time(name, room_info[name])
        
        if idx < N-1:
            print("-----")

def print_room_time(name:str, info:list):

    print("Room ", name, ":", sep="")
    available_time = calculate_time(info)

    if available_time:
        print(len(available_time), "available:")
        for (s, e) in available_time:
            print(str(s).zfill(2), "-", str(e).zfill(2), sep="")
    else:
        print("Not available")

def calculate_time(info:list):

    if not info:
        return [(9, 18)]

    answer, check = [], 9
    for (start, end) in sorted(info):
        if check < start:
            answer.append((check, start))
        check = end

    if check < 18:
        answer.append((check, 18))

    return answer

solution()