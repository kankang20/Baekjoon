
"""
title  : 255900. 외톨이 알파벳 
"""

def solution(input_string):

    answer = set()
    word = set()

    length = len(input_string)
    i = 0
    while i < length:
        
        temp = input_string[i]
        while i < length and input_string[i] == temp:
            i += 1

        if temp in word:
            answer.add(temp)
        else:
            word.add(temp)
    
    return "".join(sorted(list(answer))) if answer else "N"

print(solution("edeaaabbccd"))      # "de"
print(solution("eeddee"))           # "e"
print(solution("string"))           # "N"
print(solution("zbzbz"))            # bz