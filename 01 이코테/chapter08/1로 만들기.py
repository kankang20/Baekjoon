
""" 예제 8-3) 1로 만들기 """

"""
26

>> 3
"""

x = 26

dp = [0] * 30001        # 1 <= x <= 30000

for idx in range(2, x+1):
    
    dp[idx] = dp[idx-1] + 1

    if idx % 2 == 0:
        dp[idx] = min(dp[idx], dp[idx//2] + 1)
    if idx % 3 == 0:
        dp[idx] = min(dp[idx], dp[idx//3] + 1)
    if idx % 5 == 0:
        dp[idx] = min(dp[idx], dp[idx//5] + 1)

print(dp)
print(dp[x])