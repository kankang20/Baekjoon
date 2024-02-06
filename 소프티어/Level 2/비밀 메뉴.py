
""" Lv 2. [21년 재직자 대회 예선] 비밀 메뉴 """

import sys

def solution():
    input = sys.stdin.readline

    M, N, K = map(int, input().split())     # 비밀 메뉴 개수 M, 사용자가 버튼 개수 N, 버튼 번호 K

    secret_menu = list(map(int, input().split()))
    user_menu = list(map(int, input().split()))

    if N < M:
        return "normal"

    idx = 0
    while idx < N:

        while idx < N and user_menu[idx] != secret_menu[0]:
            idx += 1

        jdx = 0
        while idx < N and jdx < M and user_menu[idx] == secret_menu[jdx]:
            idx += 1
            jdx += 1

        if jdx == M:
            return "secret"
        
    return "normal"

print(solution())