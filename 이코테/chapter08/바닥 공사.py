
""" 예제 8-5) 바닥 공사 """


"""
3

>> 5
"""

N = int(input())    # 가로 길이

def solution():

    d = [0]

    d.append(1)
    d.append(3)

    for idx in range(N+1):
        d.append((d[idx-1] + d[idx-2] * 2) % 796796)

    return d[N]

print(solution())