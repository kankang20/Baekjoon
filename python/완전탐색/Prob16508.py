
""" 실버 3. 전공책 """

import sys

answer = 1e9

def solution():

    input = sys.stdin.readline

    T = input().rstrip()        # 만들어야 하는 단어
    N = int(input())            # 전공책의 개수
    
    book = []
    for _ in range(N):
        temp = list(input().split())
        book.append((int(temp[0]), temp[1]))

    word = dict()
    for t in T:
        word[t] = word.get(t, 0) + 1

    selected_word = [False] * N

    check(T, N, book, word, 0, selected_word, 0)


def check(T, N, book:list, word:dict, price:int, selected_word:list, seleced_count:int):

    print(word, price, selected_word)

    # 전공책에서 모든 단어를 선택하였으면    
    if not word:
        answer = min(answer, price)
        return
    
    # 모든 전공책을 확인하였으면
    if not seleced_count:
        return
    
    for i in range(N):

        flag = False

        pr, na = book[i]

        if selected_word[i]:
            continue

        for n in na:

            if n in word.keys():
                word[n] -= 1
                flag = True
                if word[n] == 0:
                    word.pop(n)
        
        if flag:
            selected_word[i] = True
            seleced_count += 1
            price += pr

        check(T, N, book, word, price, selected_word, seleced_count)


solution()
print(answer if answer < 1e9 else -1)