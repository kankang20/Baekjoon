
""" 실버 3. 오리 """

word = input()         # 영선이가 녹음한 소리 quack

def solution():
    word_index = ['q', 'u', 'a', 'c', 'k']
    temp = []

    if word[0] != 'q':
        return -1

    for w in word:
        flag = True

        if w == 'q':
            for idx in range(len(temp)):
                if temp[idx] == 0:
                    temp[idx] += 1
                    flag = False
                    break
            if flag:
                temp.append(1)
                flag = False
        
        elif w == 'k':
            for idx in range(len(temp)):
                if temp[idx] == 4:
                    temp[idx] = 0
                    flag = False
                    break

        else:
            for idx in range(len(temp)):
                if word_index[temp[idx]] == w:
                    temp[idx] += 1
                    flag = False
                    break

        if flag:
            return -1

    for t in temp:
        if t > 0:
            return -1

    return len(temp)


print(solution())