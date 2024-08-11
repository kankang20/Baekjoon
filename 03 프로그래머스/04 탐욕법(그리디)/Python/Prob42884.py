
"""
title  : 42884. 단속카메라 (Level 3)
"""

def solution(routes):
    
    answer = 0
    st, se = -30002, -30001
    for start, end in sorted(routes):

        if st <= start <= se and st <= end <= se:
            st, se = start, end
        elif st <= start <= se:
            st = start
        else:
            answer += 1
            st, se = start, end

    return answer

print(solution([[-20,-15], [-14,-5], [-18,-13], [-5,-3]]))              # 2

print(solution([[-2,-1], [1,2],[-3,0]]))                                #2
print(solution([[0,0],]))                                               #1
print(solution([[0,1], [0,1], [1,2]]))                                  #1
print(solution([[0,1], [2,3], [4,5], [6,7]]))                           #4
print(solution([[-20,-15], [-14,-5], [-18,-13], [-5,-3]]))              #2
print(solution([[-20,15], [-14,-5], [-18,-13], [-5,-3]]))               #2
print(solution([[-20,15], [-20,-15], [-14,-5], [-18,-13], [-5,-3]]))    #2