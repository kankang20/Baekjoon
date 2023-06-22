
""" 실버5. 카약과 강풍 """

# N 팀의 수, S 카약이 손상된 팀의 수, R 카약을 하나 더 가져온 팀의 수
N, S, R = map(int, input().split())

brokenTeam = set(map(int, input().split()))    # 카약이 손상됨 팀의 번호
onemoreTeam = set(map(int, input().split()))   # 카약을 하나 더 가져온 팀의 번호

answer = 0

intersection = brokenTeam & onemoreTeam         # 카약이 망가졌지만 하나 더 가져온 팀은 제외 - 다른 팀에게 빌려줄 수 없음
brokenTeam = list(brokenTeam - intersection)
onemoreTeam = list(onemoreTeam - intersection)

brokenTeam.sort()

for t in brokenTeam:
    if t-1 in onemoreTeam:          # 왼쪽 팀에게 카약을 먼저 빌림
        onemoreTeam.remove(t-1)
    elif t+1 in onemoreTeam:        # 오른쪽 팀에게 카약을 빌림
        onemoreTeam.remove(t+1)
    else:                           # 카약을 빌리지 못했기 때문에 출발을 할 수 없는 팀
        answer += 1  

print(answer)
