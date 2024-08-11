
-- Level 1

-- 물고기의 길이 as MAX_LENGTH
    -- 잡은 물고기 중 가장 큰 물고기
    -- 물고기의 길이 + 'cm'

SELECT CONCAT(MAX(LENGTH), 'cm') AS MAX_LENGTH
FROM FISH_INFO