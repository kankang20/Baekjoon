
""" 예제 10-7) 커리큘럼 """

from collections import deque
import copy

N = int(input())                    # 듣고자 하는 강의의 수

graph = [[] for _ in range(N+1)]  
indegree = [0] * (N+1)              # 진입차수 
time = [0] * (N+1)                  # 강의 시간

for i in range(1, N+1):
    temp = list(map(int, input().split()))
    time[i] = temp[0]
    for j in temp[1:-1]:
        indegree[i] += 1
        graph[j].append(i)


def topology_sort():
    result = copy.deepcopy(time)
    q = deque()

    for i in range(1, N+1):
        if indegree[i] == 0:
            q.append(i)
    
    while q:
        now = q.popleft()
        
        for i in graph[now]:
            indegree[i] -= 1
            result[i] = max(result[i], result[now] + time[i])
            if indegree[i] == 0:
                q.append(i)

    for i in range(1, N+1):
        print(result[i], end=" ")

topology_sort()

