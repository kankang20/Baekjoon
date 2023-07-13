
""" 실버 4. 스위치 켜고 끄기 """

switch_count = int(input())                         # 스위치 개수                 
switch_state = list(map(int, input().split()))      # 각 스위치의 상태 (1 켜져있음 0 꺼져있음)
switch_state.insert(0, 0)    
student_count = int(input())                        # 학생 수                      

for student in range(student_count):
    gender, number = map(int, input().split())      # 입력받으면서 스위치 변경
    s = 1

    if gender == 1:     # 남학생
        while number * s < len(switch_state):
            switch_state[number * s] = abs(switch_state[number * s] - 1)
            s += 1

    else:               # 여학생
        switch_state[number] = abs(switch_state[number] - 1)
        while number - s > 0 and number + s < switch_count+1 and switch_state[number - s] == switch_state[number + s]:
            switch_state[number - s] = abs(switch_state[number - s] - 1)
            switch_state[number + s] = abs(switch_state[number + s] - 1)
            s += 1

for num in range(1, len(switch_state)):
    print(switch_state[num], end = " ")
    if num % 20 == 0:print()