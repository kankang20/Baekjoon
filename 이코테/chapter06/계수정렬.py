
""" 예제 6-4) 계수정렬 """

N = [5, 9, 8, 3, 1, 13]

count = [0] * (max(N) + 1)      # 별도의 리스트가 필요

for n in N:
    count[n] += 1

for i in range(len(count)):
    for j in range(count[i]):
        print(i, end = " ")
