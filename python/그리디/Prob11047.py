
""" 실버 4. 동전 0 """

N, K = map(int, input().split())            # 동전 종류, 동전으로 만드는 가치의 합

coin = [int(input()) for _ in range(N)]     # 동전의 가치

answer = 0

for num in reversed(coin):

    if K < num:
        continue

    answer += (K // num)

    K %= num

print(answer)