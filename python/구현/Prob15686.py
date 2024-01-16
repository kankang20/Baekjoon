
""" 골드 5. 치킨 배달 """

import sys

answer = 1e9

def solution():

    input = sys.stdin.readline

    N, M = map(int, input().split())

    global chicken
    chicken = []

    global house
    house = []

    for i in range(N):              
        temp = list(map(int, input().split()))      # 0 빈칸, 1 집, 2 치킨집
        for j in range(N):
            if temp[j] == 1:
                house.append((i, j))
            if temp[j] == 2:
                chicken.append((i, j))

    global chicken_count
    chicken_count = len(chicken)

    # 치킨집의 개수가 작거나 같아서 M개를 고르지 않아도 되는 경우
    if chicken_count <= M:
        return calculate_chicken_distance([True for _ in range(chicken_count)])

    # 치킨집의 개수가 M보다 큰 경우
    global selected    
    selected = [False for _ in range(chicken_count)]

    select_chicken(M, 0)

    return answer

def select_chicken(M, count):

    if count == M:
        global answer
        answer = min(answer, calculate_chicken_distance(selected))
        return
    
    for i in range(chicken_count):
        if not selected[i]: 
            selected[i] = True
            select_chicken(M, count+1)
            selected[i] = False

def calculate_chicken_distance(selected:list):

    temp_answer = 0
    for (hr, hc) in house:
        distance = 1e9
        for c in range(chicken_count):
            if selected[c]:
                cr, cc = chicken[c]
                distance = min(distance, abs(hr-cr) + abs(hc-cc))
        temp_answer += distance
    
    return temp_answer

print(solution())