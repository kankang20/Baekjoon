
""" 실버 4. 빙고 """

# def ---------------------------------------------------------------------------

def doBingoCheck(row, col, check):

    count_row = 0
    count_col = 0
    count_left = 0
    count_right = 0

    # 빙고 확인
    for num in range(5):
        if check[row][num]:     # 행
            count_row += 1
        if check[num][col]:     # 열
            count_col += 1
        if row == 2 or col == 2:
            if check[num][num]:
                count_left += 1
            if check[4 - num][4 - num]:
                count_right += 1
            
    # 빙고 개수
    return [count_row, count_col, count_left, count_right].count(5)

# 입력 ---------------------------------------------------------------------------

Bingo = []          # 철수의 빙고판
Standard = []       # 사회자가 부르는 수 

for num in range(5):
    Bingo.append(list(map(int, input().split())))

for num in range(5):
    Standard.append(list(map(int, input().split())))

# 실행 ---------------------------------------------------------------------------

check = [[False] * 5 for _ in range(5)]      # 사회자가 부른 수이면 True
check_break = False                          # 이중 for문을 벗어나기 위한 변수

count_bingo = 0     # 빙고 개수
answer = 0          # 사회자가 몇 번째 수를 불렀는가

for row in Standard:
    for ele in row:

        answer += 1

        row = 0
        col = 0
        
        # 사회자가 부른 수 빙고판에 True 체크
        for num in range(5):
            if ele in Bingo[num]:
                row = num
                col = Bingo[num].index(ele)
                check[row][col] = True

        # 빙고가 만들어지는지 확인
        count_bingo += doBingoCheck(row, col, check)
        print(row, ", ", col, " = ", Bingo[row][col], " : ", doBingoCheck(row, col, check))

        if count_bingo >= 3:
            check_break = True      
            break
    
    if check_break:
        break

print(answer)
