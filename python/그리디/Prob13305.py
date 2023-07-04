
""" 실버 3. 주유소 """

N = int(input())                                # 도시 개수
roads = list(map(int, input().split()))         # 도로의 길이
costs = list(map(int, input().split()))         # 주유소 리터당 가격

min_cost = max(costs)
answer = 0      # 이동하는 최소 비용

for num, road in enumerate(roads):
    min_cost = min(min_cost, costs[num])
    answer += min_cost * road

print(answer)
