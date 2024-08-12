
"""
title  : 6268. [21년 재직자 대회 예선] 전광판 (Level 2)
time   : 129ms
memory : 37.39MB
"""

import sys

def solution():
    input = sys.stdin.readline

    board = dict()
    board["0"] = [1, 1, 0, 1, 1, 1, 1]
    board["1"] = [0, 0, 0, 1, 0, 0, 1]
    board["2"] = [1, 0, 1, 1, 1, 1, 0]
    board["3"] = [1, 0, 1, 1, 0, 1, 1]
    board["4"] = [0, 1, 1, 1, 0, 0, 1]
    board["5"] = [1, 1, 1, 0, 0, 1, 1]
    board["6"] = [1, 1, 1, 0, 1, 1, 1]
    board["7"] = [1, 1, 0, 1, 0, 0, 1]
    board["8"] = [1, 1, 1, 1, 1, 1, 1]
    board["9"] = [1, 1, 1, 1, 0, 1, 1]
    board[" "] = [0, 0, 0, 0, 0, 0, 0]

    for _ in range(int(input())):
        A, B = input().rstrip().split()
        A = A.rjust(5, " ")
        B = B.rjust(5, " ")

        answer = 0
        for idx in range(5):
            answer += check(board[A[idx]], board[B[idx]])

        print(answer)

def check(a:list, b:list):
    count = 0
    for idx in range(7):
        if a[idx] != b[idx]:
            count += 1
    return count

solution()
