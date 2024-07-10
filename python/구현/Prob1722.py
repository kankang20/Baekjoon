
""" 골드 5. 순열의 순서 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())    
    command = list(map(int, input().split()))

    position = [1] + [0] * N
    for idx in range(1, N+1):
        position[idx] = position[idx-1] * idx

    selected = [False] * (N+1)

    if command[0] == 1:
        search_permutation(N, position, command[1], selected)
    elif command[0] == 2:
        search_kth(N, position, command, selected)
    

def search_permutation(N:int, position:list, K:int, selected:list):

    answer = [0] * (N+1)
    for idx in range(1, N+1):
        
        count = 1
        pos = N - idx       # permutation의 남은 자릿수
        for jdx in range(1, N+1):
            
            if selected[jdx]:
                continue

            if K <= count * position[pos]:
                K -= (count-1) * position[pos]
                answer[idx] = jdx
                selected[jdx] = True
                break

            count += 1

    for ans in answer[1:]:
        print(ans, end=" ")

def search_kth(N:int, position:list, number:list, selected:list):

    answer = 1
    for idx in range(1, N+1):

        count = 0
        pos = N - idx
        for jdx in range(1, number[idx]):

            if not selected[jdx]:
                count += 1
        
        answer += count * position[pos]
        selected[number[idx]] = True

    print(answer)

solution()