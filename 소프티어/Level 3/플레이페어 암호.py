
""" Lv 3. [HSAT 3회 정기 코딩 인증평가 기출] 플레이페어 암호 """

import sys

def solution():
    input = sys.stdin.readline

    plain_text = input().rstrip()
    text_key = list(input().rstrip())

    # 1. playpair key를 5x5 크기의 표로 변환하기
    global table_key
    global coordinate_key
    table_key, coordinate_key = make_key_table(text_key)

    # 2. 메세지를 두 글자씩 나누고 
    # 3. Playfair cipher 암호화
    return divide_ciper_plain(plain_text)

# 1. playpair key를 5x5 크기의 표로 변환하기
def make_key_table(text_key:list):

    table_key = [[0] * 5 for _ in range(5)]
    coordinate_key = dict()

    check_character = [False] * (90 - 65 + 1)
    check_character[ord("J") - 65] = True
    
    row, column = 0, 0
    for key in text_key:
        if not check_character[ord(key) - 65]:
            table_key[row][column] = key
            coordinate_key[key] = (row, column)
            check_character[ord(key) - 65] = True
            row, column = move_coordinate(row, column)

    idx = -1
    while row < 5 and column < 5:
        idx += 1
        if not check_character[idx]:
            coordinate_key[chr(idx + 65)] = (row, column)
            table_key[row][column] = chr(idx + 65)
            row, column = move_coordinate(row, column)

    return table_key, coordinate_key

def move_coordinate(row:int, column:int):
    column += 1
    if column == 5:
        row += 1
        column = 0
    return row, column

# 2. 메세지를 두 글자씩 나누고 
def divide_ciper_plain(plain_text:str):

    ciper_answer = ""
    plain_length, idx = len(plain_text), 0
    while idx < plain_length:

        temp = plain_text[idx]
        
        if idx == plain_length-1:
            temp += "X"
        else:
            if temp == plain_text[idx+1]:
                temp += "Q" if temp == "X" else "X"
            else:
                idx += 1
                temp += plain_text[idx]

        # 3. Playfair cipher 암호화
        ciper_answer += ciper_text(temp)
        idx += 1

    return ciper_answer

# 3. Playfair cipher 암호화
def ciper_text(plain:str):

    ciper = ""
    r1, c1 = coordinate_key[plain[0]]
    r2, c2 = coordinate_key[plain[1]]

    if r1 == r2:    # 3-1. 같은 행에 존재하면
        ciper += table_key[r1][(c1 + 1) % 5]
        ciper += table_key[r2][(c2 + 1) % 5]
    elif c1 == c2:  # 3-2. 같은 열에 존재하면
        ciper += table_key[(r1 + 1) % 5][c1]
        ciper += table_key[(r2 + 1) % 5][c2]
    else:           # 3-3. 다 아니면
        ciper += table_key[r1][c2]
        ciper += table_key[r2][c1]

    return ciper

print(solution())

# HELLOWORLD
# PLAYFAIRCIPHERKEY