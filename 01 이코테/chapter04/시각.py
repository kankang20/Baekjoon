
""" 예제 4-2) 시각 """

N = int(input())    

answer = 0

for h in range(N+1):
    for m in range(60):
        for s in range(60):

            if '3' in str(h) + str(m) + str(s):
                answer += 1

print(answer)