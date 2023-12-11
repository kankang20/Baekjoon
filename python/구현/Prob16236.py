
""" 골드 3. 아기 상어 """

import sys

def solution():
    
    input = sys.stdin.readline

    N = int(input())                # 공간의 크기

    shark = [0] * 3                 # 아기 상어의 위치
    fish = []                       # 물고기

    array = []
    for i in range(N):
        array.append(list(map(int, input().split())))
        for j in range(N):
            if array[i][j] == 9:
                shark[0], shark[1], shark[2] = i, j, 2
                array[i][j] = 0
            elif array[i][j] > 0:
                fish.append((i, j, array[i][j]))
    
    return move(N, array, shark, fish)


def move(N, array, shark:list, fish:list):

    time_count = 0

    fish.sort(key=lambda x:(x[0], x[1]))

    while fish:

        fish_index, fish_distnace = seek_fish(N, array, shark, fish)

        if fish_index == -1:
            return time_count
        
        # 상어
        shark[0], shark[1] = fish[fish_index][0], fish[fish_index][1]
        shark[2] += array[fish[fish_index][0]][fish[fish_index][1]]

        # 물고기
        array[fish[fish_index][0]][fish[fish_index][1]] = 0
        fish.pop(fish_index)

        # 시간 추가
        time_count += fish_distnace
        
    return time_count


def seek_fish(N, array, shark:list, fish:list):

    min_distance = N + N
    answer_index = -1

    for f in range(0, len(fish)):

        if not array[fish[f][0]][fish[f][1]] or array[fish[f][0]][fish[f][1]] >= shark[2]:
            continue 

        x = abs(shark[0] - fish[f][0])
        y = abs(shark[1] - fish[f][1])

        if x + y < min_distance:
            min_distance = x + y
            answer_index = f

    return (answer_index, min_distance)


print(solution())
