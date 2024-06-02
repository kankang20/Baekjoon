
""" 실버 3. 빈도 정렬 """

import sys

def solution():
    input = sys.stdin.readline

    N, C = map(int, input().split())

    number = list(map(int, input().split()))
    
    count = dict()
    for idx in range(N):
        num = number[idx]
        count[num] = count.get(num, 0) + 1

    for (key, value) in sorted(count.items(), key=lambda x : (-x[1])):
        for _ in range(value):
            print(key, end=" ")

solution()