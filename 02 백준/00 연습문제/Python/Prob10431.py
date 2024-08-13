
"""
title  : 10431. 줄세우기 (Silver 5)
time   : 60ms       152ms
memory : 31120KB    110640KB
"""

import sys

def solution():
    input = sys.stdin.readline

    T = int(input())
    for _ in range(T):

        numbers = list(map(int, input().split()))

        answer = 0
        student = []
        for ndx in range(1, 21):
            
            temp = []
            while student and numbers[ndx] < student[-1]:
                temp.append(student.pop())
                answer+=1

            student.append(numbers[ndx])
            while temp:
                student.append(temp.pop())
    
        print(numbers[0], answer)

solution()