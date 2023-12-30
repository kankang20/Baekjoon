
""" 골드 4. 로봇 조립 """

import sys

parent = dict()

def find(x):
    if x not in parent.keys():
        parent[x] = x

    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

def solution():

    input = sys.stdin.readline

    for _ in range(int(input())):

        command = input().split()

        if command[0] == "I":
            union(int(command[1]), int(command[2]))
            # print(parent)

        elif command[0] == "Q":
            number = int(command[1])
            print(1 if number not in parent.keys() else list(parent.values()).count(number))

solution()