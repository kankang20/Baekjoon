
""" 실버 4. 괄호 """

import sys

def solution():

    input = sys.stdin.readline
    testcase = int(input())                # 테스트 케이스 개수

    for _ in range(testcase):
        
        word = list(input().rstrip())
        print(check(word))

def check(word:list):

    answer = 0

    while word:

        temp = word.pop()
        answer += (1 if temp == ")" else -1)
        
        if answer < 0:
            return "NO"
        
    return "NO" if answer else "YES"

solution()