
""" 예제 8-2) 피보나치(반복) """

# 메모제이션
dp = [0] * 100

dp[1], dp[2] = 1, 1
n = 6
# n = 99

for idx in range(3, n+1):
    dp[idx] = dp[idx-1] + dp[idx-2]

print(dp[n])