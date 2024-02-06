
""" Lv 3. [HSAT 3회 정기 코딩 인증평가 기출] 교차로 """

import sys
from heapq import heappush, heappop

def solution():
    input = sys.stdin.readline

    N = int(input())                # 자동차 개수

    answer = [0] * N

    cross_line = []
    for idx in range(N):
        t, w = input().rstrip().split()    # 시간 t, 교차로 위치 w
        heappush(cross_line, (int(t), w, idx+1))

    temp = {0 : 0, 1 : 0, 2 : 0, 3 : 0}
    while cross_line:

        t, w, idx = heappop(cross_line)
        temp[ord(w) - ord("A")] = idx

        car_count = 0
        while cross_line and cross_line[0][0] == t:
            tt, tw, tdx = heappop(cross_line)
            temp[ord(tw) - ord("A")] = tdx
            car_count += 1

        if car_count == 4:
            for key in temp.keys():
                answer[temp[key] - 1] = -1
            break
        
        print("1. temp = ", temp)
        for key in temp.keys():
            if temp[key] and not temp[(key+3) % 4]:
                answer[temp[key] - 1] = t
                temp[key] = 0

        print("2. answer = ", answer)
        print("2. temp = ", temp)

        t += 1
        for key in temp.keys():
            if temp[key] and not temp[(key+3) % 4]:
                answer[temp[key] - 1] = t
                temp[key] = 0

        print("3. answer = ", answer)
        print("3. temp = ", temp)

    for ans in answer:
        print(ans)
    

solution()