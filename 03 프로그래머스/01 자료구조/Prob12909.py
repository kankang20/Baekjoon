
"""
title  : 12909. 올바른 괄호 (Level 2)
"""

def solution(s):

    count = 0

    for c in s:

        if c == "(":
            count += 1
        else:
            count -= 1

        if count < 0:
            return False
    
    return True if count == 0 else False


print(solution("()()"))                 # true
print(solution("(())()"))               # true
print(solution(")()("))                 # false
print(solution("(()("))                 # false

print(solution("())))(((()"))           # false