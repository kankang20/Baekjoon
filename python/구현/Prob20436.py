
""" 실버 4. ZOAC 3 """

left, right = input().split()
alphabet = list(input())

Pos = {'q':(0, 0), 'w':(0, 1), 'e':(0, 2), 'r':(0, 3), 't':(0, 4), 'y':(0, 5), 'u':(0, 6), 'i':(0, 7), 'o':(0, 8), 'p':(0, 9), 
        'a':(1, 0), 's':(1, 1), 'd':(1, 2), 'f':(1, 3), 'g':(1, 4), 'h':(1, 5), 'j':(1, 6), 'k':(1, 7), 'l':(1, 8), 
        'z':(2, 0), 'x':(2, 1), 'c':(2, 2), 'v':(2, 3), 'b':(2, 4), 'n':(2, 5), 'm':(2, 6)}

answer = len(alphabet)

for alp in alphabet:

    if alp in 'qwertasdfgzxcv':     # 왼손 검지손가락
        answer += (abs(Pos[left][0] - Pos[alp][0]) + abs(Pos[left][1] - Pos[alp][1]))
        left = alp

    elif alp in 'yuiophjklbnm':     # 오른손 검지손가락
        answer += (abs(Pos[right][0] - Pos[alp][0]) + abs(Pos[right][1] - Pos[alp][1]))
        right = alp
        
print(answer)