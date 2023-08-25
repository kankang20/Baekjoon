
""" 예제 6-2) 삽입정렬 """

N = [9, 5, 8, 3, 1, 13]

for i in range(1, len(N)):
    for j in range(i, 0, -1):
        
        # 작은 데이터를 앞으로 이동
        if N[j] < N[j-1]:
            N[j], N[j-1] = N[j-1], N[j]

        else:
            break

print(N)