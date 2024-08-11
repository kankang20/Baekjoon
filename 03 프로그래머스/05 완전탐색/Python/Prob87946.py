
"""
title  : 87946. 피로도 (Level 2)
"""

def solution(k, dungeons):

    # 최소 필요 피로도 - 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도
    # 소모 피로도 - 던전을 탐험한 후 소모되는 피로도
    
    global answer
    answer = 0

    length = len(dungeons)
    selected = [False] * length

    def move(total_hp, dcount):
        
        global answer
        answer = max(answer, dcount)

        for idx in range(length):
            if not selected[idx] and total_hp >= dungeons[idx][0]:
                selected[idx] = True
                move(total_hp - dungeons[idx][1], dcount+1)
                selected[idx] = False

    move(k, 0)

    return answer

print(solution(80, [[80,20],[50,40],[30,10]]))      # 3