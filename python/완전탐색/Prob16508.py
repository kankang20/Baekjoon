
""" 실버 3. 전공책 """

import sys

answer = 1e9

def solution():

    input = sys.stdin.readline

    T = input().rstrip()        # 만들어야 하는 단어
    N = int(input())            # 전공책의 개수
    
    books = []
    for _ in range(N):
        temp = list(input().split())
        books.append((int(temp[0]), temp[1]))

    words = dict()
    for t in T:
        words[t] = words.get(t, 0) + 1

    selected_book = [0] * N

    dfs(T, N, books, words, selected_book, 0)

def dfs(T, N, books:list, words:dict, selected_book:list, price:int):

    print(words, selected_book, price)

    if not words:
        global answer
        answer = min(answer, price)
        return
    
    if selected_book.count(0) == 0:
        return

    for idx in range(N):

        print(words, idx)

        if selected_book[idx]:
            continue

        for t in T:
            if t in words.keys() and t in books[idx][1]:
                words[t] -= 1
                selected_book[idx] = 1
                price += books[idx][0]
                if words[t] == 0:
                    words.pop(t)
                dfs(T, N, books, words, selected_book, price)

solution()
print(answer if answer < 1e9 else -1)