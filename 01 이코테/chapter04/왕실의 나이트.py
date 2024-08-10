
""" 예제 4-3) 왕실의 나이트 """

N = input()

r = int(N[1])
c = ord(N[0]) - ord('a') + 1

dr = [-2, -1, 1, 2, 2, 1, -1, -2]
dc = [-1, -2, -2, -1, 1, 2, 2, 1]

answer = 0

for d in range(8):

    nr = r + dr[d]
    nc = c + dc[d]

    if nr < 1 or nc < 1 or nr > 8 or nc > 8:
        continue

    answer += 1

print(answer)