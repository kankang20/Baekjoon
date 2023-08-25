
""" 예제 6-3) 퀵정렬 """


def quick_sort_detail(N, start, end):

    # 리스트의 길이가 1이면 stop
    if end <= start:
        return
    
    # 기준 설정
    pivot = start

    left = start + 1
    right = end

    # 엇갈리면 더이상 진행하지 않음
    while left <= right:    

        # pivot보다 큰 수가 있을 경우 stop (왼쪽)
        while left <= end and N[left] <= N[pivot]:
            left += 1

        # pivot보다 작은 수가 있을 경우 stop (오른쪽)
        while right > start and N[right] >= N[pivot]:
            right -= 1

        # 엇갈린 경우 작은 right 데이터와 pivot 교환
        if right < left:
            N[right], N[pivot] = N[pivot], N[right]
        # 엇갈리지 않은 경우 left와 right 데이터 교환
        else:   
            N[left], N[right] = N[right], N[left]

    quick_sort_detail(N, start, right-1)
    quick_sort_detail(N, right+1, end)


def quick_sort_simple(N):

    # 리스트의 길이가 1이면 stop
    if len(N) <= 1:
        return N
    
    # 기준 설정
    pivot = N[0]
    # 기준인 pivot을 제외한 리스트
    tail = N[1:]

    # 리스트 안의 모든 데이터 중 pivot보다 작거나 같은 데이터만을 선택
    left = [x for x in tail if x <= pivot]
    # 리스트 안의 모든 데이터 중 pivot보다 큰 데이터만을 선택
    right = [x for x in tail if x > pivot]

    return quick_sort_simple(left) + [pivot] + quick_sort_simple(right)



N = [9, 5, 8, 3, 1, 13]

N_detail = N[:]
N_simple = N[:]

quick_sort_detail(N_detail, 0, len(N)-1)
print(N_detail)

# 데이터 비교 연산 횟수가 증가하기 때문에 시간 면에서는 quick_sort_detail보다 비효율적
print(quick_sort_simple(N_simple))
