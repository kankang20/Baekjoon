
"""
title  : 42860. 조이스틱 (Level 2)
"""

def solution(name):
    answer = 0              # 답 : 조이스틱 조작 횟수

    name_length = len(name)

    move = name_length - 1    # 최대 위치 이동 횟수 (하나씩 오른쪽으로 이동) 
    next = 0

    for num, char in enumerate(name):   # J A Z

        # 알파벳 변경 ord("A") = 65, ord("Z") = 90
        answer += min(ord(char) - 65, 90 - ord(char) + 1)

        # 위치 이동
        next = num + 1

        while next < name_length and name[next] == 'A':
            next += 1
        
        move = min([move, 2 * num + name_length - next, num + 2 * (name_length - next)])

    return answer + move

print(solution("JEROEN"))       # 56
print(solution("JAN"))          # 23
print(solution("JAZ"))          # 11
print(solution("BBBAABB"))      # 11
print(solution("ABABAABA"))     # 9
print(solution("BCDAAABC"))     # 15
print(solution("ABAAAAAA"))     # 2