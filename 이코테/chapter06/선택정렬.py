
""" 예제 6-1) 선택정렬 """

N = [9, 5, 8, 3, 1, 13]

for i in range(len(N)):

    min = i

    # 가장 작은 데이터 찾기
    for j in range(i+1, len(N)):
        if N[min] > N[j]:
            min = j

    # 데이터 교환
    N[i], N[min] = N[min], N[i]

print(N)