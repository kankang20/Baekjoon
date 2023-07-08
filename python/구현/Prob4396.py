
""" 실버 4. 지뢰 찾기 """

# 입력 ---------------------------------------------------------------------------

N = int(input())

Board = []
Board_clicked = []

for num in range(N):                                # 지뢰판
    Board.append(list(input().split()))
for num in range(N):                                # 클릭한 지뢰판
    Board_clicked.append(list(input().split()))

# 실행 ---------------------------------------------------------------------------

