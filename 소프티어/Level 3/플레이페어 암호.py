
""" Lv 3. [HSAT 3회 정기 코딩 인증평가 기출] 플레이페어 암호 """

import sys

def solution():
    input = sys.stdin.readline

    plain_text = input().rstrip()
    text_key = list(input().rstrip())

    # 1. playpair key를 5x5 크기의 표로 변환하기
    table_key = [[0] * 5 for _ in range(5)]

    # ord("A") chr(65) - 90
    check_character = [False] * (90 - 65 + 1)
    
    r , c = 0, -1
    for key in text_key:
        table_key[r][c] = key

        c += 1

        if c == 5:
            r += 1
            c = 0

    for table in table_key:
        print(table)



print(solution())

# HELLOWORLD
# PLAYFAIRCIPHERKEY