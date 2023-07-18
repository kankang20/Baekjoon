
""" A와 B 2 """

s = input()     # 시작 문자열
t = input()     # 최종 문자열

def doCheck(n):   

    if n == t:
        print(1)
        exit(0)

    if len(n) >= len(t):
        return
    
    doCheck(n + 'A')

    temp = n + 'B'
    doCheck(temp[::-1])

doCheck(s)
print(0)