
""" Lv 3. [21년 재직자 대회 예선] 좌석 관리 """

import sys

def solution():
    input = sys.stdin.readline

    N, M, Q = map(int, input().split())     # N 행 M 열, 작업 개수 Q

    seat = [[0] * (M+1) for _ in range(N+1)]
    current_seat = dict()   # 현재 밥을 먹고 있다면 (x, y) 밥을 먹고 떠났다면 -1

    for _ in range(Q):

        command, id = input().split()
        id = int(id)

        if command == "Out":
            check = current_seat.get(id)
            
            if check == None:
                print(f"{id} didn't eat lunch.")
            elif check == -1:
                print(f"{id} already left seat.")
            else:
                print(f"{id} leaves from the seat {check}.")
                current_seat[id] = -1
                seat[check[0]][check[1]] = 0

        elif command == "In":
            check = current_seat.get(id)

            if check == None:
                is_seat = search_seat(N, M, seat)
                if is_seat == -1:
                    print("There are no more seats.")
                else:
                    print(f"{id} gets the seat {is_seat}.")
                    current_seat[id] = is_seat
            elif check == -1:
                print(f"{id} already ate lunch.")
            else:
                print(f"{id} already seated.")

def search_seat(N:int, M:int, seat:list):

    # X가 가장 낮도록, Y가 가장 낮도록
    for idx in range(1, N+1):
        start = 1 if idx % 2 else 2
        for jdx in range(start, M+1, 2):
            if not seat[idx][jdx]:
                seat[idx][jdx] = 1
                return (idx, jdx)

    return -1
        
solution()