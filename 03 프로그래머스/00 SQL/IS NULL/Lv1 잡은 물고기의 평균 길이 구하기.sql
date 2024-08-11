
-- Level 1

-- 물고기의 평균 길이 AS AVERAGE_LENGTH
    -- 평균 길이는 소수점 3째자리에서 반올림
    -- 10cm 이하의 물고기들은 10cm로 취급

SELECT ROUND(AVG(IFNULL(LENGTH, 10)), 2) AS AVERAGE_LENGTH
FROM FISH_INFO

SELECT ROUND(AVG(CASE 
                    WHEN LENGTH IS NULL THEN 10
                    ELSE LENGTH
                END), 2) AS AVERAGE_LENGTH
FROM FISH_INFO