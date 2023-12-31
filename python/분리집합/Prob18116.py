
""" 골드 4. 로봇 조립 """

import sys

parent = [num for num in range(10**6 + 1)]
count = [1] * (10**6 + 1)

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a = find(a)
    b = find(b)

    if a == b:
        pass
    elif a < b:
        parent[b] = a
        count[a] += count[b]
        count[b] = 0
    else:
        parent[a] = b
        count[b] += count[a]
        count[a] = 0

def solution():

    input = sys.stdin.readline

    for _ in range(int(input())):

        command = input().split()

        if command[0] == "I":
            union(int(command[1]), int(command[2]))
        elif command[0] == "Q":
            print(count[find(int(command[1]))])
            
solution()