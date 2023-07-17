
""" 실버 4. 스위치 켜고 끄기 """

sc = int(input())                                # 스위치 개수                 
state = [0] + list(map(int, input().split()))    # 각 스위치의 상태 (1 켜져있음 0 꺼져있음)   
student = int(input())                           # 학생 수                      

for num in range(student):
    ge, sw = map(int, input().split())      # 입력받으면서 스위치 변경
    s = 1

    if ge == 1:         # 남학생
        while sw * s < sc + 1:
            state[sw * s] = abs(state[sw * s] - 1)
            s += 1

    else:               # 여학생
        state[sw] = abs(state[sw] - 1)
        while sw - s > 0 and sw + s < sc + 1 and state[sw - s] == state[sw + s]:
            state[sw - s] = abs(state[sw - s] - 1)
            state[sw + s] = abs(state[sw + s] - 1)
            s += 1

for num in range(1, sc+1):
    print(state[num], end = " ")
    if num % 20 == 0:print()