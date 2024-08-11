
"""
title  : 42576. 완주하지 못한 선수 (Level 1)
"""

def solution(participant, completion):

    answer = {}

    for p in participant:
        answer[p] = answer.setdefault(p, 0) + 1
    
    for c in completion:
        answer[c] -= 1

    for name, count in answer.items():
        if count == 1:
            return name

print(solution(["leo", "kiki", "eden"], ["eden", "kiki"]))                                                              # "leo"
print(solution(["marina", "josipa", "nikola", "vinko", "filipa"], 	["josipa", "filipa", "marina", "nikola"]))          # "vinko" 
print(solution(["mislav", "stanko", "mislav", "ana"], 	["stanko", "ana", "mislav"]))                                   # "mislav"