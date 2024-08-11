
-- Level 2

-- 동물 이름의 개수
    -- 동물 보호소에 들어온 동물 
    -- 이름이 NULL인 경우 집계 x, 중복되는 이름은 하나

SELECT COUNT(DISTINCT NAME) AS COUNT
FROM ANIMAL_INS
WHERE NAME IS NOT NULL