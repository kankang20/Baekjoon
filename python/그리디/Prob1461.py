
""" 골드 4. 도서관 """

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())
    books = sorted(list(map(int, input().split())))

    # -39 -37 -29 -28 -6 2 11

    answer = 0

    print(books)

    target, temp = 0, -1
    while target < N:

        temp, count = target, 1
        while temp < (N-1) and books[temp] * books[temp+1] > 0 and count < M:
            temp += 1
            count += 1
        
        print(target, temp)

        # answer += max(abs(books[target]), abs(books[temp])) * 2
        answer += abs(books[target]) * 2
        target = temp + 1

        print(answer)
    

    return answer 

print(solution())