
""" 예제 5-2) 큐 """

from collections import deque

queue = deque()

queue.append(1)     # [1]        
queue.append(5)     # [1, 5]
queue.append(21)    # [1, 5, 21]
queue.popleft()     # [5, 21]
queue.append(7)     # [5, 21, 7]
queue.popleft()     # [21, 7]

print(queue)        # 먼저 들어온 순서대로 [21, 7]
queue.reverse()
print(queue)        # 나중에 들어온 순서대로 [7, 21]