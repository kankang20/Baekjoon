
""" 실버 5. 폴리오미노 """

board = list(input()) + ["q"]   # 보드판 

answer = ""
count = 0

for i, str in enumerate(board):

    if str == "X":
        count += 1
    else:
        
        # count가 홀수면 덮을 수 없음 :(  
        if count % 2 == 1:                                    
            print(-1)
            break

        # count가 짝수면 덮을 수 있음 :)
        countA = count // 4
        answer += ("AAAA" * countA + "BB" * ((count - countA * 4) // 2) + ".")   

        count = 0

else:
    print(answer[:-1])

