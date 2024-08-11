
-- Level 1

-- 물고기 ID (as ID) 와 길이 (as LENGTH)
    -- 가장 큰 물고기 10마리
    -- 길이를 기준으로 내림차순 정렬, 같다면 물고기 ID에 대해 오름차순 정렬

SELECT ID, LENGTH
FROM FISH_INFO
ORDER BY LENGTH DESC, ID ASC LIMIT 10