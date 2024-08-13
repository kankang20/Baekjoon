
"""
title  : 4659. 비밀번호 발음하기 (Silver 5)
time   : 40ms        108ms
memory : 31120KB     109108KB
"""

import sys

def solution():

    input = sys.stdin.readline
    
    while True:

        password = input().rstrip()

        if password == 'end':
            break

        if check_aeiou(password) and check_triple(password) and check_sameword(password):
            print("<{}> is acceptable.".format(password))
        else:
            print("<{}> is not acceptable.".format(password))

def check_aeiou(password):

    for word in ['a','e','i','o','u']:
        if word in password:
            return True
    return False

def check_triple(password):

    left_count, right_count = 0, 0

    for word in password:
        
        if word in ['a','e','i','o','u']:
            left_count += 1
            right_count = 0
        else:
            left_count = 0
            right_count += 1
        
        if left_count == 3 or right_count == 3:
            return False
        
    return True

def check_sameword(password):

    idx = 0

    while idx < len(password)-1:

        temp = password[idx]
        idx += 1

        if temp in ['e', 'o']:
            continue

        if temp == password[idx]:
            return False
        
    return True

solution()