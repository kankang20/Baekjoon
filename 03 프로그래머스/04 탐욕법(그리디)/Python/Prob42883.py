
"""
title  : 42883. 큰 수 만들기 (Level 2)
"""

def solution(number, k):
    answer = []
    
    for num in range(0, len(number)):

        temp = number[num]

        if not answer:
            answer.append(temp)
            continue

        while answer and answer[-1] < temp and k > 0:
            answer.pop()
            k -= 1

        answer.append(temp)
    
    return ''.join(answer if k == 0 else answer[:-k])

print(solution("1924", 2))              # "94"
print(solution("1231234",3))            # "3234"
print(solution("4177252841", 4))        # "775841"

print(solution("1924", 3))              # "9"
print(solution("1231234",6))            # "4"
print(solution("4177252841", 9))        # "8"
