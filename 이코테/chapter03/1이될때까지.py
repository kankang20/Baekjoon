
""" 예제 3-4) 1이 될 때까지 """

N, K = map(int, input().split())    # 숫자, 나눌 수

answer = 0

while N >= K:

    temp = (N // K) * K
    answer += (N - temp)

    N = temp // K
    answer += 1

print(answer + N - 1)

