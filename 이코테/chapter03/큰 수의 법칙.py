
""" 예제 3-2) 큰 수의 법칙 """

N, M, K = map(int, input().split())         # 배열의 크기, 숫자가 더해지는 횟수, 가능한 연속 횟수
numbers = list(map(int, input().split()))   # 자연수들

numbers.sort()

print(numbers)

num1 = numbers[-1]   # 가장 큰 수
num2 = numbers[-2]   # 두번째로 큰 수

answer = ((M // K) * K * num1) + ((M % K) * num2)

print(answer)

