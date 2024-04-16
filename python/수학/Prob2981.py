
""" 골드 4. 검문 """

import sys

def solution():
    input = sys.stdin.readline

    # 유클리드 호제법 (숫자 A, B)
    # 'A를 B로 나눈 나머지'와 B의 최대 공약수 = A와 B의 최대 공약수
    # gcd(A, B) = gcd(B, A % B), A % B가 0이면 그때 B가 최대공약수

    N = int(input())    # 숫자 개수
    numbers = [int(input()) for _ in range(N)]

    numbers.sort(reverse=True)

    answer = []
    
    def gcd(a, b):
        while b > 0:
            a = b
            b = a % b
        return a
    
    print(gcd(28, 14))
    print(gcd(numbers[0], numbers[1]))

solution()