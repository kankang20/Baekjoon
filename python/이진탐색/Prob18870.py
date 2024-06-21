
""" 실버 2. 좌표 압축 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())
    coor = list(map(int, input().split()))

    sorted_coor = sorted(list(set(coor)))
    
    number = {}
    for idx in range(len(sorted_coor)):
        number[sorted_coor[idx]] = idx
    
    for c in coor:
        print(number[c], end=" ")
    
solution()