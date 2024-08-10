
""" 예제 6-6) 성적이 낮은 순서로 학생 출력하기 """

N = int(input())

array = []
for n in range(N):
    name, grade = input().split()
    array.append((int(grade), name))

array.sort()

for a in array:
    print(a[1], end = " ")
