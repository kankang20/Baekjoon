
""" 실버 4. 빙고 """

def doBingoCheck(check):

    all_count = 0

    # 빙고 대각선 확인
    count_left = 0
    count_right = 0

    # 빙고 가로, 세로 확인
    for num1 in range(5):
        count_row = 0
        count_col = 0

        # 대각선
        if check[num1][num1]:
            count_left += 1
        if check[num1][4 - num1]:
            count_right += 1
        
        # 가로, 세로
        for num2 in range(5):
            if check[num1][num2]:
                count_row += 1
            if check[num2][num1]:
                count_col += 1

        all_count += [count_row, count_col].count(5)

    all_count += [count_left, count_right].count(5)

    return all_count

Bingo = []          # 철수의 빙고판
Standard = []       # 사회자가 부르는 수 

for num in range(5):
    Bingo.append(list(map(int, input().split())))

for num in range(5):
    Standard.append(list(map(int, input().split())))

check = [[False] * 5 for _ in range(5)]      # 사회자가 부른 수이면 True
check_break = False                          # 이중 for문을 벗어나기 위한 변수

count_bingo = 0     # 빙고 개수
answer = 0          # 사회자가 몇 번째 수를 불렀는가

for row in Standard:
    for ele in row:

        answer += 1

        # 사회자가 부른 수 빙고판에 True 체크
        for num in range(5):
            if ele in Bingo[num]:
                col = Bingo[num].index(ele)
                check[num][col] = True
        
        # 빙고 개수 카운트
        if doBingoCheck(check) >= 3:
            check_break = True
            break

    if check_break:
        break

print(answer)
