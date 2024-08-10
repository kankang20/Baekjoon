
""" 예제 3-1) 거스름돈 """

N = int(input())

coins = [500, 100, 50, 10]
answer = 0

for coin in coins:
    answer += N // coin
    N %= coin

print(answer)