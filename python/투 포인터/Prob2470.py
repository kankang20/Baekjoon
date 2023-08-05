
""" 골드 5. 두 용액 """

import sys

N = int(sys.stdin.readline())                       # 전체 용액의 수
P = list(map(int, sys.stdin.readline().split()))    # 각 용액의 특성값

answer = sys.maxsize
number = ()

for idx in range(N-1):

    num1 = P[idx]

    i = idx + 1

    while i < N:
        num2 = P[i]
        sum = abs(num1 + num2)

        if sum < answer:
            answer = sum
            number = (num1, num2)

        i += 1

if number[0] < number[1]:
    print(number[0], number[1])
else:
    print(number[1], number[0])