
""" 실버 3. 후외 표기식2 """

import sys

def solution():

    input = sys.stdin.readline

    N = int(input())                # 피연산자의 개수
    command = input().rstrip()      # 후위 표기식
    number = [int(input()) for _ in range(N)]   

    start, end = ord("A"), ord("Z")

    stack = []
    for c in command:

        if start <= ord(c) <= end:
            stack.append(number[ord(c) - start])
            continue

        num2 = stack.pop()
        num1 = stack.pop()

        stack.append(calculate_number(c, num1, num2))

    return "{:.2f}".format(stack.pop())


def calculate_number(check, num1, num2):

    if check == "+":
        return num1 + num2
    elif check == "-":
        return num1 - num2
    elif check == "*":
        return num1 * num2
    elif check == "/":
        return num1 / num2


print(solution())