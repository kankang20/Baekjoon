
""" 예제 5-1) 스택 """

stack = []

stack.append(1)     # [1]
stack.append(5)     # [1, 5]
stack.append(21)    # [1, 5, 21]
stack.pop()         # [1, 5]
stack.append(7)     # [1, 5, 7]
stack.pop()         # [1, 5]

print(stack)        # 최하단 원소부터 출력 [1, 5]
print(stack[::-1])  # 최상단 원소부터 출력 [5, 1]


