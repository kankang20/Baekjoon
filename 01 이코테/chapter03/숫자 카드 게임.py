
""" 예제 3-3) 숫자 카드 게임 """

N, M = map(int, input().split())        # 행, 열

answer = 0

for _ in range(N):
    numbers = list(map(int, input().split()))   # 행 리스트

    answer = max(answer, min(numbers))          # 그 중 가장 작은 수 찾기

print(answer)